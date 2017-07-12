package com.dev.rubickon.crocodile.screen;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;


import com.dev.rubickon.crocodile.R;

/**
 * Created by DNS1 on 10.07.2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected DrawerLayout mDrawer;
    protected Toolbar mToolbar;
    protected NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(mToolbar);
        initNavigationDrawer();

    }


    private void initNavigationDrawer() {

        mNavigationView.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            switch (id) {
                case R.id.menu_single_play:

//                    Intent single = new Intent(getApplicationContext(), .class);
//                    startActivity(single);
                    mDrawer.closeDrawers();
                    break;
                case R.id.menu_time_play:
//                    Intent time = new Intent(getApplicationContext(), .class);
//                    startActivity(time);
                    mDrawer.closeDrawers();
                    break;
                case R.id.menu_settings:
//                    Intent settings = new Intent(getApplicationContext(), .class);
//                    startActivity(settings);
                    mDrawer.closeDrawers();
                    break;
                case R.id.menu_rules:
//                    Intent rules = new Intent(getApplicationContext(), .class);
//                    startActivity(rules);
                    mDrawer.closeDrawers();
                    break;
                case R.id.menu_dev:
//                    Intent dev = new Intent(getApplicationContext(), .class);
//                    startActivity(dev);
                    mDrawer.closeDrawers();
                    break;
                case R.id.menu_exit:
                    mDrawer.closeDrawers();
                    finish();
                    break;
            }
            return true;
        });
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/round_script.ttf");
        View header = mNavigationView.getHeaderView(0);
        final TextView tv_title = (TextView) header.findViewById(R.id.tv_main_title);
        tv_title.setTypeface(font);
        Menu m = mNavigationView .getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    SpannableString s = new SpannableString(subMenuItem.getTitle());
                    s.setSpan(new TypefaceSpan("fonts/round_script.ttf"), 0, s.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    subMenuItem.setTitle(s);
                }
            }
        }

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
