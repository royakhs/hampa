package com.arayeh.hampa.fragments.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arayeh.hampa.MainActivity;
import com.arayeh.hampa.R;

import androidx.fragment.app.Fragment;


public class StartFragment extends Fragment {
private Button mRegisterBtn;
private Button mSighnInBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_start, container, false);
        mRegisterBtn=view.findViewById(R.id.registerBtn);
        mSighnInBtn=view.findViewById(R.id.sighInBtn);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if(activity instanceof MainActivity){
                    MainActivity myactivity = (MainActivity) activity;
                    myactivity.loadStatusFragment();
                }
            }
        });
        mSighnInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if(activity instanceof MainActivity){
                    MainActivity myactivity = (MainActivity) activity;
                    myactivity.loadLoginFragment();
                }
            }
        });


        return view;
    }

}
