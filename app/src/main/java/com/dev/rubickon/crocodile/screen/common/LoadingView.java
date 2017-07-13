package com.dev.rubickon.crocodile.screen.common;

import io.reactivex.disposables.Disposable;

/**
 * Created by DNS1 on 13.07.2017.
 */

public interface LoadingView {

    void hideLoading();

    void showLoading(Disposable disposable);

}
