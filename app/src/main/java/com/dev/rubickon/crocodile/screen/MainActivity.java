package com.dev.rubickon.crocodile.screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.screen.phrase.PhraseActivity;
import com.dev.rubickon.crocodile.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.et_level) EditText mEtLevel;
    @BindView(R.id.btn_level) Button mBtLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.activity_content);
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);
        ButterKnife.bind(this);
    }

    public void result(){
        String level = mEtLevel.getText().toString();
        Intent intent = new Intent(getApplicationContext(), PhraseActivity.class);
        intent.putExtra(Constants.LEVEL_EXTRAS, level);
        startActivity(intent);

    }
}
