package com.dev.rubickon.crocodile.api;

import android.support.annotation.NonNull;

import com.dev.rubickon.crocodile.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DNS1 on 10.07.2017.
 */

public final class ApiFactory {


    private static OkHttpClient sClient;


    private static volatile PhraseService phraseService;

    private ApiFactory() {
    }

    @NonNull
    public static PhraseService getPhraseService() {
        PhraseService service = phraseService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = phraseService;
                if (service == null) {
                    service = phraseService = buildRetrofit().create(PhraseService.class);
                }
            }
        }
        return service;
    }

    public static void recreate() {
        sClient = null;
        sClient = getClient();
        phraseService = buildRetrofit().create(PhraseService.class);

    }


    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }



    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .build();
    }


}
