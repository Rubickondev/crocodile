package com.dev.rubickon.crocodile.repository;

import com.dev.rubickon.crocodile.api.ApiFactory;
import com.dev.rubickon.crocodile.model.Phrase;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by DNS1 on 10.07.2017.
 */

public class DefaultPhraseRepository implements PhraseRepository{



    @Override
    public Observable<List<Phrase>> phrases(String level) {
        return ApiFactory.getPhraseService()
                .getPhrases(level)
                .compose(RxUtils.async());
    }


    @Override
    public Observable<ResponseBody> postPhrase(String phrase, String level) {
        return ApiFactory.getPhraseService()
                .postPhrase(phrase, level)
                .compose(RxUtils.async());
    }

}
