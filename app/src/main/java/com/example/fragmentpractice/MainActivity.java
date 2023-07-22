package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Name> names;
    NamesAdapter Adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        names = new ArrayList<>();
        names.add(new Name("hamza"));
        names.add(new Name("asem"));
        names.add(new Name("saker"));
        names.add(new Name("damra"));
        names.add(new Name("hamza"));
        names.add(new Name("asem"));
        names.add(new Name("saker"));
        names.add(new Name("damra"));
        names.add(new Name("hamza"));
        names.add(new Name("asem"));
        names.add(new Name("saker"));
        names.add(new Name("damra"));
        FragmentManager fragmentManager = getSupportFragmentManager();
        Adapter = new NamesAdapter(names, getBaseContext(), new OnItemClickListenerImpl(), fragmentManager);
        recyclerView.setAdapter(Adapter);


    }


}