package com.dev.rubickon.crocodile.screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.screen.phrase.PhraseActivity;
import com.dev.rubickon.crocodile.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.et_level)
    EditText mEtLevel;
    @BindView(R.id.btn_level)
    Button mBtLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_level)
    public void result(){
        int level = Integer.parseInt(mEtLevel.getText().toString());
        Intent intent = new Intent(getApplicationContext(), PhraseActivity.class);
        intent.putExtra(Constants.LEVEL_EXTRAS, level);
        startActivity(intent);

    }
}
