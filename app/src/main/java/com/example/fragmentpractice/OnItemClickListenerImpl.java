package com.example.fragmentpractice;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

// OnItemClickListenerImpl.java
public class OnItemClickListenerImpl extends OnItemClickListener {
    @Override
    public void onItemClicked(Name name, FragmentManager fragmentManager) {
         TV_Fragment nameFragment = TV_Fragment.newInstance(name.getName());
         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.fragmentContainerView, nameFragment);
         fragmentTransaction.commit();
    }
}
