package com.dev.rubickon.crocodile.repository;

import com.dev.rubickon.crocodile.api.ApiFactory;
import com.dev.rubickon.crocodile.model.Phrase;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by DNS1 on 10.07.2017.
 */

public class DefaultPhraseRepository implements PhraseRepository{



    @Override
    public Observable<List<Phrase>> phrases(int level) {
        return ApiFactory.getPhraseService()
                .getPhrases(level)
                .compose(RxUtils.async());
    }
}
