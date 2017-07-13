package com.dev.rubickon.crocodile.repository;

import com.dev.rubickon.crocodile.model.Phrase;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by DNS1 on 10.07.2017.
 */

public interface PhraseRepository {

    Observable<List<Phrase>> phrases(String level);

    Observable<ResponseBody> postPhrase(String phrase, String level);

}
