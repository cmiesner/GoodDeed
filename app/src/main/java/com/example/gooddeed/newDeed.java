package com.example.gooddeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newDeed extends AppCompatActivity {
    MyDBHandlerClass mDatabaseHelper;
    private Button btnAdd;
    EditText newDeed;
    EditText usersName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_deed);
        newDeed = findViewById(R.id.newDeed);
        usersName = findViewById(R.id.usersName);
        btnAdd = findViewById(R.id.btnAdd);
        mDatabaseHelper = new MyDBHandlerClass(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newDeedString = newDeed.getText().toString();
                String usersNameString = usersName.getText().toString();
                if (newDeedString.length() != 0 && usersNameString.length() != 0) {
                    mDatabaseHelper.addData(newDeedString, usersNameString);
                    newDeed.setText("");
                    usersName.setText("");
                    Intent mainActivity = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(mainActivity);
                } else {
                    Toast.makeText(newDeed.this,"The text field can't be blank", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
