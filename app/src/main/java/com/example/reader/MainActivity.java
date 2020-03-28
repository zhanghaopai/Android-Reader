package com.example.reader;

import android.os.Bundle;

import com.example.reader.fragment.DashboradFragment;
import com.example.reader.fragment.HotFragment;
import com.example.reader.fragment.MeFragment;
import com.example.reader.fragment.TitleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "com.zhp.mainactivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Log.i(TAG,"点击navigation_home");
                    getSupportFragmentManager().beginTransaction().replace(R.id.page, new HotFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    Log.i(TAG,"点击navigation_dashboard");
                    getSupportFragmentManager().beginTransaction().replace(R.id.page, new DashboradFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    Log.i(TAG,"点击navigation_notifications");
                    getSupportFragmentManager().beginTransaction().replace(R.id.page, new MeFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setDefaultFragment();
    }

    private void setDefaultFragment(){//进入Activity时，设置默认的Fragment
       getSupportFragmentManager().beginTransaction().add(R.id.page, new HotFragment()).commit();
       getSupportFragmentManager().beginTransaction().add(R.id.title_bar, new TitleFragment()).commit();
        Log.i(TAG,"默认设置setDefaultFragment");
    }

}
