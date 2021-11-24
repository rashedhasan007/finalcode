package rashed.hasan.hone;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class test extends Activity {
    RecyclerView recyclerView;
    Query query1;
    private DatabaseReference mdatabasereference;
    private ProgressDialog progressDialog;
    FirebaseRecyclerAdapter<product_getter_setter, BlogViewHolder> firebaseRecyclerAdapter;
    LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        progressDialog = new ProgressDialog(test.this);
        progressDialog.setMessage("Loading Products Please Wait...");
        progressDialog.show();
        mdatabasereference = FirebaseDatabase.getInstance().getReference("products").child("accessories");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGirdView);
    }
    @Override
    protected void onStart() {
        super.onStart();
        query1 = FirebaseDatabase.getInstance().getReference().child("products").child("accessories");
        FirebaseRecyclerOptions<product_getter_setter> options =
                new FirebaseRecyclerOptions.Builder<product_getter_setter>()
                        .setQuery(query1, product_getter_setter.class)
                        .build();
        Log.d("Options"," data : "+options);
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<product_getter_setter, BlogViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull BlogViewHolder blogViewHolder, final int i, @NonNull product_getter_setter product_get_set_v) {
                blogViewHolder.setname(product_get_set_v.getName());
                String image_url =blogViewHolder.setimage(product_get_set_v.getImage());
                String link= product_get_set_v.getLink();
                Log.d("LINKDATA"," data : "+link);
                blogViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String productid=getRef(i).getKey();
                        Log.d("productid"," data : "+productid);
                        mdatabasereference.child(productid).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String finallink = dataSnapshot.child("link").getValue(String.class);
                                Log.d("productLink"," data : "+finallink);
                                if(finallink!=null)
                                {
                                    Uri uriUrl = Uri.parse(finallink);
                                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(launchBrowser);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                    }
                });
            }
            @NonNull
            @Override
            public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.customelayout, parent, false);
                progressDialog.dismiss();
                return new BlogViewHolder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public BlogViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setname(String name)
        {
            //TextView ename=(TextView)mView.findViewById(R.id.text1);
            //ename.setText(name);
        }
        public String setimage(String url)
        {
            ImageView image = (ImageView)mView.findViewById(R.id.productimage);
            Picasso.get().load(url).into(image);
            return url;
        }
    }

}