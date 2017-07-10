package com.dev.rubickon.crocodile.screen.phrase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.model.Phrase;
import com.dev.rubickon.crocodile.screen.common.CommonAdapter;
import com.dev.rubickon.crocodile.screen.common.CommonListView;

import com.dev.rubickon.crocodile.utils.Constants;
import com.dev.rubickon.crocodile.utils.DividerItemDecoration;
import com.dev.rubickon.crocodile.utils.EmptyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhraseActivity extends AppCompatActivity implements CommonListView<Phrase>{


    @BindView(R.id.recyclerView)
    EmptyRecyclerView mRecyclerView;
    @BindView(R.id.empty)
    View mEmptyView;

    private CommonAdapter<Phrase> mAdapter;
    private PhrasePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);
        ButterKnife.bind(this);
        presenter = new PhrasePresenter(this);
        initRecycler();
        int level = getIntent().getIntExtra(Constants.LEVEL_EXTRAS, 0);
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
        mAdapter.changeDataSet(items);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
        mAdapter.clear();
    }


}
