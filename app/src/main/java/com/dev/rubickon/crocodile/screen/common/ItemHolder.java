package com.dev.rubickon.crocodile.screen.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dev.rubickon.crocodile.R;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by DNS1 on 27.05.2017.
 */
public class ItemHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.level)
    TextView mLevel;
    @BindView(R.id.rate)
    TextView mRate;


    @NonNull
    public static ItemHolder create(@NonNull Context context) {
        View view = View.inflate(context, R.layout.phrase_item, null);
        ItemHolder holder = new ItemHolder(view);
        ButterKnife.bind(holder, view);
        return holder;
    }

    public ItemHolder(View itemView) {
        super(itemView);
    }

    public void bind(@NonNull ListItem item) {
        mName.setText(item.getPhrase());
        mLevel.setText(item.getLevel());
        mRate.setText(item.getRate());
    }

}
