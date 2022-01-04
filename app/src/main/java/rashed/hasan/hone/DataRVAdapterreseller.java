package rashed.hasan.hone;

import android.Manifest;
import android.Manifest.permission;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


import static androidx.constraintlayout.motion.widget.MotionScene.TAG;
import static org.xmlpull.v1.XmlPullParser.TEXT;

public class DataRVAdapterreseller extends RecyclerView.Adapter<DataRVAdapterreseller.ViewHolder> {

    private ArrayList<DataModalreseller> dataModalArrayList;
    private Context context;
    LinearLayout linearLayout1;
    private Activity activity;
    private static final int REQUEST_PERMISSION = 0;
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private ViewHolder holder;

    // constructor class for our Adapter
    public DataRVAdapterreseller(ArrayList<DataModalreseller> dataModalArrayList, Context context) {
        this.dataModalArrayList = dataModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataRVAdapterreseller.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new DataRVAdapterreseller.ViewHolder(LayoutInflater.from(context).inflate(R.layout.themerecycler, parent, false));
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        // setting data to our views in Recycler view items.
        final DataModalreseller modal = dataModalArrayList.get(position);
        //holder.courseNameTV.setText(modal.getProductname());
        //holder.price.setText(modal.getPrice());
        //holder.totalorder.setText(modal.getTotalstock());


        // we are using Picasso to load images
        // from URL inside our image view.
        Picasso.get().load(modal.getDownloadUr2()).into(holder.courseIV);


        holder.courseIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setting on click listener
                // for our items of recycler items.
                Toast.makeText(context, "Clicked item is " + modal.getProductname(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(),resellerproductdetails.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return dataModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView copy;
        // creating variables for our
        // views of recycler items.
        private TextView courseNameTV,shareproduct,editproduct,price,totalorder;
        private ImageView courseIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing the views of recycler views.
            //courseNameTV = itemView.findViewById(R.id.idTVtext);
            courseIV = itemView.findViewById(R.id.idIVimage);
            shareproduct=itemView.findViewById(R.id.Shareproduct);
            editproduct=itemView.findViewById(R.id.editproduct);
            price=itemView.findViewById(R.id.price);
            totalorder=itemView.findViewById(R.id.order);
            copy=(ImageView) itemView.findViewById(R.id.copy);
            ImageView content = (ImageView)itemView.findViewById(R.id.idIVimage);


        }
    }



}