package com.dev.rubickon.crocodile.screen.send;

import com.dev.rubickon.crocodile.repository.RepositoryProvider;

/**
 * Created by DNS1 on 12.07.2017.
 */

public class SendPresenter {

    private final SendView mView;

    public SendPresenter(SendView mView) {
        this.mView = mView;
    }

    public void sendPhrase(String phrase, String level){

        RepositoryProvider.providePhraseRepository()
                .postPhrase(phrase, level)
                .subscribe(mView::handleResponse, mView::handleError);

    }

}
