package com.dev.rubickon.crocodile.screen.send;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.screen.BaseActivity;
import com.dev.rubickon.crocodile.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;

public class SendActivity extends BaseActivity implements SendView{


    @BindView(R.id.et_phrase)
    EditText mEtPhrase;
    @BindView(R.id.rg_level)
    RadioGroup mRgLevel;
    @BindView(R.id.btn_send)
    Button mBtSend;


    private SendPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.activity_content);
        getLayoutInflater().inflate(R.layout.activity_send, contentFrameLayout);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
        presenter = new SendPresenter(this);
    }

    @OnClick(R.id.btn_send)
    public void sendPhrase(){
        String phrase = mEtPhrase.getText().toString();
        String level = "0";
        int checked = mRgLevel.getCheckedRadioButtonId();
        switch (checked){
            case R.id.radio_easy:
                level = "1";
                break;
            case R.id.radio_medium:
                level = "2";
                break;
            case R.id.radio_hard:
                level = "3";
                break;
        }
        presenter.sendPhrase(phrase, level);
    }


    @Override
    public void handleResponse(ResponseBody response) {
       showDialog(Constants.DIALOG_KEY, getResources().getString(R.string.msg_success_response));
    }

    @Override
    public void handleError(Throwable error) {
        showDialog(Constants.DIALOG_KEY, error.getMessage());
    }

    private void showDialog(String key, String value){
        Bundle args = new Bundle();
        args.putString(key, value);
        ResponseDialogFragment responseDialogFragment = new ResponseDialogFragment();
        responseDialogFragment.setArguments(args);
        responseDialogFragment.show(getSupportFragmentManager(), "response");
    }
}
