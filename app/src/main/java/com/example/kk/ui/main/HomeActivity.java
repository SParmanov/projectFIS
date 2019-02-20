package com.example.kk.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.kk.ui.asma.AsmaFragment;
import com.example.kk.ui.kuran.KuranFragment;
import com.example.kk.ui.namaz.NamazFragment;
import com.example.kk.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(navigationItemReselectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NamazFragment()).commit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    private BottomNavigationView.OnNavigationItemReselectedListener navigationItemReselectedListener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.namaz:
                            selectedFragment = new NamazFragment();
                            break;
                        case R.id.kuran:
                            selectedFragment = new KuranFragment();
                            break;
                        case R.id.asma:
                            selectedFragment = new AsmaFragment();
                            break;
                        default:
                            selectedFragment = new NamazFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                }
            };
}
