package com.dev.rubickon.crocodile.screen.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.screen.BaseActivity;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.activity_content);
        getLayoutInflater().inflate(R.layout.activity_settings, contentFrameLayout);
        Fragment preferenceFragment = new SettingsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.pref_container, preferenceFragment);
        ft.commit();

    }
}
