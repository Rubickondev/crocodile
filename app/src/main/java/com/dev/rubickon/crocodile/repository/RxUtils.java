package com.dev.rubickon.crocodile.repository;

import android.support.annotation.NonNull;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DNS1 on 03.06.2017.
 */

public final class RxUtils {

    private RxUtils() {
    }

    @NonNull
    public static <T> ObservableTransformer<T, T> async() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    public static <T> ObservableTransformer<T, T> async(@NonNull final Scheduler background,
                                                         @NonNull final Scheduler main) {
        return observable -> observable
                .subscribeOn(background)
                .observeOn(main);
    }

}
