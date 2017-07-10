package com.dev.rubickon.crocodile.api;

import com.dev.rubickon.crocodile.model.Phrase;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DNS1 on 10.07.2017.
 */

public interface PhraseService {


    @GET("selectPhrases/{level}")
    Observable<List<Phrase>> getPhrases(@Path("level") int level);


}
