package com.example.app4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class IntentFragment extends Fragment {
    View view;
    Button buttonRegulations;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_intent, container, false);
        buttonRegulations = (Button)view.findViewById(R.id.buttonRegulations);

        buttonRegulations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(IntentFragment.this).commit();
            }
        });

        return view;
    }
}