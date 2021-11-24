package rashed.hasan.hone;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class theme extends Fragment {
    RecyclerView recyclerView,recyclerView4,recyclerView2,recyclerView3;
    Query query1,query2;
    private DatabaseReference mdatabasereference;
    private ProgressDialog progressDialog;
    FirebaseRecyclerAdapter<product_getter_setter, test.BlogViewHolder> firebaseRecyclerAdapter,firebaseRecyclerAdapter1;
    LinearLayoutManager mLayoutManager;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment theme.
     */
    // TODO: Rename and change types and number of parameters

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_theme, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading Products Please Wait...");
        progressDialog.show();
        mdatabasereference = FirebaseDatabase.getInstance().getReference("products").child("accessories");
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewGirdView);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerViewGirdView1);
        recyclerView3 = (RecyclerView) view.findViewById(R.id.recyclerViewGirdView2);
        recyclerView4 = (RecyclerView) view.findViewById(R.id.recyclerViewGirdView3);

        return view;
    }
    public void onStart() {
        super.onStart();
        query1 = FirebaseDatabase.getInstance().getReference().child("products").child("accessories");
        FirebaseRecyclerOptions<product_getter_setter> options =
                new FirebaseRecyclerOptions.Builder<product_getter_setter>()
                        .setQuery(query1, product_getter_setter.class)
                        .build();
        Log.d("Options"," data : "+options);
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<product_getter_setter, test.BlogViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull test.BlogViewHolder blogViewHolder, final int i, @NonNull product_getter_setter product_get_set_v) {
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
                                customwebview ldf=new customwebview();
                                Bundle args = new Bundle();
                                args.putString("linktheme",finallink);
                                ldf.setArguments(args);
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,ldf).commit();
                                //loadFragment();
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
            public test.BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.customlayout1, parent, false);
                progressDialog.dismiss();
                return new test.BlogViewHolder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);

        query2 = FirebaseDatabase.getInstance().getReference().child("products").child("accessories");
        FirebaseRecyclerOptions<product_getter_setter> options1 =
                new FirebaseRecyclerOptions.Builder<product_getter_setter>()
                        .setQuery(query2, product_getter_setter.class)
                        .build();
        Log.d("Options"," data : "+options);
        firebaseRecyclerAdapter1 = new FirebaseRecyclerAdapter<product_getter_setter, test.BlogViewHolder>(options1) {
            @Override
            protected void onBindViewHolder(@NonNull test.BlogViewHolder blogViewHolder, final int i, @NonNull product_getter_setter product_get_set_v) {
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
                                customwebview ldf=new customwebview();
                                Bundle args = new Bundle();
                                args.putString("linktheme",finallink);
                                ldf.setArguments(args);
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,ldf).commit();
                                //loadFragment();
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
            public test.BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.customlayout1, parent, false);
                progressDialog.dismiss();
                return new test.BlogViewHolder(view);
            }
        };
        firebaseRecyclerAdapter1.startListening();
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager1);
        recyclerView2.setAdapter(firebaseRecyclerAdapter1);

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
