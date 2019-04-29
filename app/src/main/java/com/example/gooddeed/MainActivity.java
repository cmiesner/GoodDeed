    package com.example.gooddeed;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.support.v4.app.Fragment;

    public class MainActivity extends AppCompatActivity {

        private static final String TAG = "MainActivity";
        Fragment fragment1;
        Fragment fragment2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            fragment1 = new Fragment();
            fragment2 = new Fragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();


            TabLayout tabs = findViewById(R.id.tabs);
            tabs.addTab(tabs.newTab().setText("Recent Deeds"));
            tabs.addTab(tabs.newTab().setText("New Deed"));
            tabs.setOnTabSelectedListener((new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int position = tab.getPosition();
                    Fragment selected = null;
                    if(position == 0) {
                        selected = fragment1;
                    }
                    else if(position == 1) {
                        selected = fragment2;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            }));
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
    }
