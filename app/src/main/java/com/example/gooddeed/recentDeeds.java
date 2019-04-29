package com.example.gooddeed;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class recentDeeds extends Fragment {
    private static final String TAG = "ListDataActivity";
    MyDBHandlerClass mDatabaseHelper;
    private ListView mListView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_recent_deeds, container, false);
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_recent_deeds);
        mListView = getView().findViewById(R.id.listView);
        mDatabaseHelper = new MyDBHandlerClass(getActivity());

        populateListView();

        View v = inflater.inflate(R.layout.fragment_recent_deeds, container, false);
        return rootView;
    }
    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }
}
