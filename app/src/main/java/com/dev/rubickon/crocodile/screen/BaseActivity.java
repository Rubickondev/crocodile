package com.dev.rubickon.crocodile.screen;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.utils.CustomTypefaceSpan;

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
        View header = mNavigationView.getHeaderView(0);
        final TextView tv_title = (TextView) header.findViewById(R.id.tv_nav_title);
        setFontToTextView(tv_title);
        setFontToMenu(mNavigationView.getMenu());
        setActionBar(mToolbar);
    }

    protected void setActionBar(Toolbar toolbar) {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setActionBarTitle(getResources().getString(R.string.app_name_ru));
    }

    protected void setFontToTextView(TextView textView) {
        Typeface font = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.font_default));
        textView.setTypeface(font);
    }

    protected void setActionBarTitle(String title){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            ActionBar bar = getSupportActionBar();
            Typeface font = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.font_default));
            SpannableStringBuilder s = new SpannableStringBuilder(bar.getTitle());
            s.setSpan(new CustomTypefaceSpan(font), 0, s.length(),
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            bar.setTitle(s);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void setFontToMenu(Menu m){
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    setFontToMenuItem(subMenuItem);
                }
            }
            setFontToMenuItem(mi);
        }
    }

    private void setFontToMenuItem(MenuItem item){
        Typeface font = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.font_default));
        SpannableStringBuilder s = new SpannableStringBuilder(item.getTitle());
        s.setSpan(new CustomTypefaceSpan(font), 0, s.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        item.setTitle(s);
    }



}
