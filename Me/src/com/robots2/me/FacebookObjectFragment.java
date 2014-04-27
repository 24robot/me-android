package com.robots2.me;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FacebookObjectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
        rootView.setBackgroundColor(Color.argb(255, 59, 85, 159));
        TextView tv = (TextView) rootView.findViewById(android.R.id.text1);
        tv.setText("Facebook");
        tv.setTextColor(Color.WHITE);
        
        ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
        logo.setImageResource(R.drawable.facebook_logo);
        
        Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
        loginButton.getBackground().setColorFilter(0xFF3B559F, PorterDuff.Mode.MULTIPLY);
        
        return rootView;
    }
}