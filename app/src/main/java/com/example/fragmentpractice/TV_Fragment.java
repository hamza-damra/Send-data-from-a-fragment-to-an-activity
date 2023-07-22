package com.example.fragmentpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TV_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "name";
    private String mParam1;

    public TV_Fragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @NonNull
    public static TV_Fragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name",name);
        TV_Fragment fragment = new TV_Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_layout, container, false);
        TextView tv_name = view.findViewById(R.id.tv_name);
        tv_name.setText(mParam1);
        return view;
    }
}