package com.dev.rubickon.crocodile.screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.screen.phrase.PhraseActivity;
import com.dev.rubickon.crocodile.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btn_easy)
    Button mBtEasy;
    @BindView(R.id.btn_medium)
    Button mBtMedium;
    @BindView(R.id.btn_hard)
    Button mBtHard;
    @BindView(R.id.tv_main_title)
    TextView mTvTitle;
    @BindView(R.id.tv_level)
    TextView mTvLevel;
    @BindView(R.id.toolbar_main)
    Toolbar mMainToolbar;

    private Boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.activity_content);
        getLayoutInflater().inflate(R.layout.activity_main2, contentFrameLayout);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        setSupportActionBar(mMainToolbar);
        setActionBar(mMainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setFontToTextView(mTvTitle);
        mBtEasy.setOnClickListener(v -> result(getResources().getString(R.string.level_easy)));
        mBtMedium.setOnClickListener(v -> result(getResources().getString(R.string.level_medium)));
        mBtHard.setOnClickListener(v -> result(getResources().getString(R.string.level_hard)));
    }


    public void result(String level) {
        Intent intent = new Intent(getApplicationContext(), PhraseActivity.class);
        intent.putExtra(Constants.LEVEL_EXTRAS, level);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.double_back_exit), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 6 * 100);
    }
}
