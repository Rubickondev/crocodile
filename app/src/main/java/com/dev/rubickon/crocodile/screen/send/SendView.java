package com.dev.rubickon.crocodile.screen.send;

import okhttp3.ResponseBody;

/**
 * Created by DNS1 on 13.07.2017.
 */

public interface SendView {

    void handleResponse(ResponseBody response);

    void handleError(Throwable error);


}
