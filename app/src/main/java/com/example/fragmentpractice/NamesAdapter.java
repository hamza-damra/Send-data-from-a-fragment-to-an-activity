package com.example.fragmentpractice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NameHolder> {
    ArrayList<Name> names;
    Context context;
    OnItemClickListener listener;

    FragmentManager fragmentManager;

    public NamesAdapter(ArrayList<Name> names, Context context, OnItemClickListener listener, FragmentManager fragmentManager) {
        this.names = names;
        this.context = context;
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_recyclerview,parent,false);
        return new NameHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameHolder holder, int position) {
         holder.bind(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class NameHolder extends RecyclerView.ViewHolder
    {
        TextView name_tv;
        Name name;
        View rootView;
        public NameHolder(@NonNull View itemView) {
            super(itemView);
            name_tv = itemView.findViewById(R.id.textView);
            rootView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(name, fragmentManager);
                    Intent intent = new Intent(rootView.getContext(),DetailsActivity.class);
                    rootView.getContext().startActivity(intent);
                }
            });
        }

        void bind(Name name)
        {
            this.name = name;
            name_tv.setText(name.getName());
        }

    }


}
