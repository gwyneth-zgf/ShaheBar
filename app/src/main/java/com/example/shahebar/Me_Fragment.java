package com.example.shahebar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.widget.TextView;
import android.widget.Toast;

public class Me_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment,container,false);
        TextView txt = (TextView) view.findViewById(R.id.me);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("dd","dddd");
                Toast.makeText(getActivity(), "当前页面：2", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
