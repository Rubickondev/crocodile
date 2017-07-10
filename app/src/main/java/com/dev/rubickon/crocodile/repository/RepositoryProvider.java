package com.dev.rubickon.crocodile.repository;

import android.support.annotation.NonNull;

/**
 * Created by DNS1 on 10.07.2017.
 */

public final class RepositoryProvider {


    private static PhraseRepository sPhraseRepository;

    private RepositoryProvider() {
    }

    @NonNull
    public static PhraseRepository providePhraseRepository() {
        if (sPhraseRepository == null) {
            sPhraseRepository = new DefaultPhraseRepository();
        }
        return sPhraseRepository;
    }

}
