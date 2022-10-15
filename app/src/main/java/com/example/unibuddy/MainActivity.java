package com.example.unibuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigator);
        BottomNavigationView finderTopNavigationView = findViewById(R.id.finder_top_navigator);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId())
                {
                    case R.id.finder_nav:
                        selectedFragment = new FinderFragment();
                        finderTopNavigationView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.chat_nav:
                        selectedFragment = new ChatFragment();
                        finderTopNavigationView.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.share_nav:
                        selectedFragment = new ShareFragment();
                        finderTopNavigationView.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.me_nav:
                        selectedFragment = new MeFragment();
                        finderTopNavigationView.setVisibility(View.INVISIBLE);
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

        finderTopNavigationView.setOnNavigationItemSelectedListener(topNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FinderFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener topNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId())
            {
                case R.id.student_nav:
                    selectedFragment = new FinderFragment();
                    break;
                case R.id.campus_nav:
                    selectedFragment = new FinderCampusFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}