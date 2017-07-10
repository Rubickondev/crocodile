package com.dev.rubickon.crocodile.screen.common;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by DNS1 on 27.05.2017.
 */

public interface CommonListView<T> {

    void showItems(@NonNull List<T> items);

    void showError(Throwable throwable);


}
