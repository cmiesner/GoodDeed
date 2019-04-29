package com.example.gooddeed;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class newDeedFragment extends Fragment {
    private Button btnAdd, btnViewData;
    private EditText editText;
    MyDBHandlerClass mDatabaseHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_new_deed, container, false);
        getActivity().setContentView(R.layout.fragment_new_deed);
        editText = getView().findViewById(R.id.editText);
        btnAdd = getView().findViewById(R.id.btnAdd);
        btnViewData = getView().findViewById(R.id.btnView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    Toast.makeText(getActivity(),"You must put something in the text field!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), recentDeeds.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    public void AddData(String newEntry) {
        mDatabaseHelper = new MyDBHandlerClass(getActivity());

        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            Toast.makeText(getActivity(),"Data Successfully Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(),"Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
