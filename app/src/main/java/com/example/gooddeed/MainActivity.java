    package com.example.gooddeed;

import android.content.ClipData;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

    public class MainActivity extends AppCompatActivity {
    MyDBHandlerClass mDatabaseHelper;

    private ListView mListView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newDeed = new Intent(getBaseContext(), newDeed.class);
                startActivity(newDeed);
            }
        });
        mListView = findViewById(R.id.listView);
        mDatabaseHelper = new MyDBHandlerClass(this);

        populateListView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_info) {
            Intent intent = new Intent(this,information.class);
            this.startActivity(intent);
            return true;
        }
        if (itemId == R.id.menu_search) {
            Toast.makeText(this, "We're Sorry! Search hasn't been implemented yet...", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<Map<String, String>> itemDataList = new ArrayList<>();

        while(data.moveToNext()){
            Map<String,String> listItemMap = new HashMap<>();
            listItemMap.put("goodDeed", data.getString(1));
            listItemMap.put("usersName", data.getString(2));
            System.out.println(data.getString(1));
            System.out.println(data.getString(2));
            itemDataList.add(listItemMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,itemDataList, android.R.layout.simple_list_item_2  , new String[]{"usersName", "goodDeed"}, new int[]{android.R.id.text1, android.R.id.text2});
        mListView.setAdapter(adapter);

    }
}
