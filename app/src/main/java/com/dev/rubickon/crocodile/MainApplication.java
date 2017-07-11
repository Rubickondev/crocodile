package com.dev.rubickon.crocodile;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;


import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;

/**
 * Created by DNS1 on 10.07.2017.
 */

public class MainApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = this;

//        setupRealm();

    }


//    private void setupRealm() {
//        Realm.init(this);
//        RealmConfiguration configuration = new RealmConfiguration.Builder()
//                .rxFactory(new RealmObservableFactory())
//                .schemaVersion(1)
//                .deleteRealmIfMigrationNeeded()
//                .build();
//        Realm.setDefaultConfiguration(configuration);
//    }


    @NonNull
    public static Context getContext() {
        return sContext;
    }


}
