package rashed.hasan.hone;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import static androidx.constraintlayout.motion.widget.MotionScene.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link customwebview.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link customwebview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class editprofile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public editprofile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment customwebview.
     */
    // TODO: Rename and change types and number of parameters
    public static customwebview newInstance(String param1, String param2) {
        customwebview fragment = new customwebview();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        // Inflate the layout for this fragment
        final EditText valuedata=view.findViewById(R.id.editprofile);
        Button button=view.findViewById(R.id.editprofilesubmit);
        String value = getArguments().getString("editprofile");
        Log.d(TAG,  value);
        if (value=="name") button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                final String valuedata1 = valuedata.getText().toString();
                Editname(valuedata1);
                Log.d(TAG,  valuedata1);
               loadFragment();

            }
        });
        if (value=="bkash") button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                final String valuedata1 = valuedata.getText().toString();
                Editbkash(valuedata1);
                Log.d(TAG,  valuedata1);
                loadFragment();

            }
        });
        if (value=="nid") button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                final String valuedata1 = valuedata.getText().toString();
                Editnid(valuedata1);
                Log.d(TAG,  valuedata1);
                loadFragment();

            }
        });

        return view;
        //inflater.inflate(R.layout.fragment_customwebview, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    private void loadFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, new first()).commit();
    }
    private void Editname(String valuedata) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //CollectionReference dbCourses = db.collection("Courses").document("jf");
        CollectionReference dbCourses = db.collection("Courses");
        editname courses = new editname(valuedata);

        db.collection("profile").document("editname")
                .set(courses)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }
    private void Editnid(String valuedata) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //CollectionReference dbCourses = db.collection("Courses").document("jf");
        CollectionReference dbCourses = db.collection("Courses");
        editbkash courses = new editbkash(valuedata);

        db.collection("profile").document("editnid")
                .set(courses)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }
    private void Editbkash(String valuedata) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //CollectionReference dbCourses = db.collection("Courses").document("jf");
        CollectionReference dbCourses = db.collection("Courses");
        editnid courses = new editnid(valuedata);

        db.collection("profile").document("editbkash")
                .set(courses)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

}

