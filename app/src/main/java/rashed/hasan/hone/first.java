package rashed.hasan.hone;

import android.Manifest;
import android.Manifest.permission;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.constraintlayout.motion.widget.MotionScene.TAG;
import static androidx.core.content.PermissionChecker.checkSelfPermission;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class first<db> extends Fragment {
    RecyclerView recyclerView;
    Query query1;
    private DatabaseReference mdatabasereference;
    Spinner dropdown;
    private ProgressDialog progressDialog;
    FirebaseRecyclerAdapter<product_getter_setter, test.BlogViewHolder> firebaseRecyclerAdapter;
    LinearLayoutManager mLayoutManager;
    private Object db;
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        dropdown = view.findViewById(R.id.spiner);
        Button logout=view.findViewById(R.id.Logout);
        LinearLayout editname=view.findViewById(R.id.editname);
        LinearLayout editbkash=view.findViewById(R.id.bkashnumber);
        LinearLayout editnid=view.findViewById(R.id.nidnumber);
        final TextView yourname=view.findViewById(R.id.yourname);
        final TextView yournid=view.findViewById(R.id.nid);
        final TextView yourbkash=view.findViewById(R.id.bkash);
        final TextView totalearn=view.findViewById(R.id.totalearn);
        final TextView totaldelivery=view.findViewById(R.id.totalshipped);
        final TextView totalorder=view.findViewById(R.id.totalorder);
        //db = FirebaseFirestore.getInstance();
        requestAppPermissions();




        DocumentReference docRef = FirebaseFirestore.getInstance().collection("profile").document("editname");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("editnameid").toString());
                        yourname.setText( document.getData().get("editnameid").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        DocumentReference docRef1 = FirebaseFirestore.getInstance().collection("profile").document("editnid");
        docRef1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("valuedata").toString());
                        yournid.setText( document.getData().get("valuedata").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        DocumentReference docRef2 = FirebaseFirestore.getInstance().collection("profile").document("editbkash");
        docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("editnid").toString());
                        yourbkash.setText( document.getData().get("editnid").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        DocumentReference docRef3 = FirebaseFirestore.getInstance().collection("profile").document("totalearn");
        docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("totalearn").toString());
                        totalearn.setText( document.getData().get("totalearn").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        DocumentReference docRef4 = FirebaseFirestore.getInstance().collection("profile").document("totalorder");
        docRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("totalorder").toString());
                        totalorder.setText( document.getData().get("totalorder").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        DocumentReference docRef5 = FirebaseFirestore.getInstance().collection("profile").document("totalshipped");
        docRef5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("totalshipped").toString());
                        totaldelivery.setText( document.getData().get("totalshipped").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });


        editname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                editprofile ldf=new editprofile();
                Bundle args = new Bundle();
                args.putString("editprofile","name");
                ldf.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,ldf).commit();
                //loadFragment();
            }
        });

        editbkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                editprofile ldf=new editprofile();
                Bundle args = new Bundle();
                args.putString("editprofile","bkash");
                ldf.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,ldf).commit();
                //loadFragment();
            }
        });

        editnid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                editprofile ldf=new editprofile();
                Bundle args = new Bundle();
                args.putString("editprofile","nid");
                ldf.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,ldf).commit();
                //loadFragment();
            }
        });





        //initspinnerfooter();
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        CollectionReference subjectsRef = rootRef.collection("Shop");
        Spinner spinner = (Spinner) view.findViewById(R.id.spiner);
        final List<String> subjects = new ArrayList<>();
        final List<String> urls = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        subjectsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String subject = document.getString("shopname");
                        String url=document.getString("url");
                        subjects.add(subject);
                        urls.add(url);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = subjects.get(position).toString();
                String selectedurl=urls.get(position).toString();
                Log.e("Clicked:",""+selected);
                //String fAge = ageList.get(position).toString();
                if (position==0){
                    Log.e("Clicked:",""+selected);
                    try {
                        Log.e("Clicked:",""+selected);
                    } catch (Exception e) {
                        System.out.println("Oops!");
                    }
                }
                //tv_1st.setText(fAge);
                else {
                    //customwebview ldf = new customwebview();
                    //Bundle args = new Bundle();
                    //args.putString("linktheme", selected);
                    //ldf.setArguments(args);
                    //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    //fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, ldf).commit();
                    //loadFragment();
                    //Log.e("Clicked:",""+selected);
                    try {
                        customwebviewshare ldf = new customwebviewshare();
                        Bundle args = new Bundle();
                        args.putString("linktheme", selectedurl);
                        ldf.setArguments(args);
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, ldf).commit();
                        //loadFragment();
                    } catch (Exception e) {
                        System.out.println("Oops!");
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), login.class);
                startActivity(intent);
            }
        });




        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Products Please Wait...");
        progressDialog.show();
        mdatabasereference = FirebaseDatabase.getInstance().getReference("products").child("accessories");
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewGirdView);
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
                        .inflate(R.layout.customelayout, parent, false);
                progressDialog.dismiss();
                return new test.BlogViewHolder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        return view;
        //inflater.inflate(R.layout.fragment_product, container, false);

        //Toast.makeText(getActivity(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
        //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.addproduct, new addproduct()).commit();
    }



    private void loadFragment() {
        addproduct ldf=new addproduct();
        Bundle args = new Bundle();
        args.putString("linktheme","");
        ldf.setArguments(args);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,ldf).commit();
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
    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(getContext(), permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(getActivity(), new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(getContext(), "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.

    private void requestAppPermissions() {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        ActivityCompat.requestPermissions(getActivity(),
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 0); // your request code
    }

    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

}
