package com.dev.rubickon.crocodile.screen.phrase;

import com.dev.rubickon.crocodile.model.Phrase;
import com.dev.rubickon.crocodile.repository.RepositoryProvider;
import com.dev.rubickon.crocodile.screen.common.CommonListView;

/**
 * Created by DNS1 on 10.07.2017.
 */

public class PhrasePresenter {

    private final CommonListView<Phrase> mView;


    public PhrasePresenter(CommonListView<Phrase> mView) {
        this.mView = mView;
    }


    public void init(String level) {
        RepositoryProvider.providePhraseRepository()
                .phrases(level)
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .subscribe(mView::showItems, mView::showError);
    }

}
