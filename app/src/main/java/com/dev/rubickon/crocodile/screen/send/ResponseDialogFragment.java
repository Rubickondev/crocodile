package com.dev.rubickon.crocodile.screen.send;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResponseDialogFragment extends DialogFragment {



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle mArgs = getArguments();
        String value = mArgs.getString(Constants.DIALOG_KEY);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(value)
                .setPositiveButton(getResources().getString(R.string.btn_success_response), (dialog, id) -> {
                    dialog.cancel();
                });
        return builder.create();
    }


}
