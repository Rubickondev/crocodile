package com.dev.rubickon.crocodile.screen.phrase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.model.Phrase;
import com.dev.rubickon.crocodile.screen.BaseActivity;
import com.dev.rubickon.crocodile.screen.common.CommonAdapter;
import com.dev.rubickon.crocodile.screen.common.CommonListView;
import com.dev.rubickon.crocodile.screen.common.LoadingDialog;
import com.dev.rubickon.crocodile.screen.common.LoadingView;
import com.dev.rubickon.crocodile.utils.Constants;
import com.dev.rubickon.crocodile.utils.DividerItemDecoration;
import com.dev.rubickon.crocodile.utils.EmptyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

public class PhraseActivity extends BaseActivity implements CommonListView<Phrase>{


    @BindView(R.id.recyclerView) EmptyRecyclerView mRecyclerView;
    @BindView(R.id.empty) View mEmptyView;

    private CommonAdapter<Phrase> mAdapter;
    private LoadingView mLoadingView;
    private PhrasePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.activity_content);
        getLayoutInflater().inflate(R.layout.activity_phrase, contentFrameLayout);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());
        presenter = new PhrasePresenter(this);
        initRecycler();
        String level = getIntent().getStringExtra(Constants.LEVEL_EXTRAS);
        presenter.init(level);

    }


    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mRecyclerView.setEmptyView(mEmptyView);
        mAdapter = getAdapter();
        mAdapter.attachToRecyclerView(mRecyclerView);

    }

    private CommonAdapter<Phrase> getAdapter() {
        return new CommonAdapter<>(new ArrayList<>());
    }



    @Override
    public void showItems(@NonNull List<Phrase> items) {
        /**TO DO**/
        mAdapter.changeDataSet(items);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
        mAdapter.clear();
    }


    @Override
    public void hideLoading() {
        mLoadingView.hideLoading();
    }

    @Override
    public void showLoading(Disposable disposable) {
        mLoadingView.showLoading(disposable);
    }
}
