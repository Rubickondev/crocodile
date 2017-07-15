package com.dev.rubickon.crocodile.screen.settings;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;

import com.dev.rubickon.crocodile.R;
import com.dev.rubickon.crocodile.utils.CustomTypefaceSpan;

/**
 * Created by DNS1 on 14.07.2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        addPreferencesFromResource(R.xml.app_pref);

        ListPreference listPreference = (ListPreference) getPreferenceManager().findPreference("pref_time");
        EditTextPreference editTextPreference = (EditTextPreference) getPreferenceManager().findPreference("et_pref_time");
        /**change negative button text*/
        listPreference.setNegativeButtonText(getResources().getString(R.string.btn_cancel));
        editTextPreference.setNegativeButtonText(getResources().getString(R.string.btn_cancel));
        /**change font*/
        setFont(listPreference);
        setFont(editTextPreference);
        /**set visibility for editTextPreference in create*/
        if (listPreference.getValue().equals("-1")) {
            editTextPreference.setVisible(true);
        } else {
            editTextPreference.setVisible(false);
        }
        /**dynamically dependency editTextPreference from listPreference */
        Preference.OnPreferenceChangeListener listener =
                (preference, newValue) -> {
                    if (newValue.equals("-1")) {
                        editTextPreference.setVisible(true);
                        return true;
                    } else {
                        editTextPreference.setVisible(false);
                        return true;
                    }
                };
        listPreference.setOnPreferenceChangeListener(listener);
    }


    private void setFont(DialogPreference preference) {
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.font_default));
        setFontTitle(preference, font);
        setFontSummary(preference, font);
        setFontMessage(preference, font);
    }

    private void setFontTitle(DialogPreference preference, Typeface font) {
        if (preference.getTitle() != null) {
            SpannableStringBuilder s = new SpannableStringBuilder(preference.getTitle());
            s.setSpan(new CustomTypefaceSpan(font), 0, s.length(),
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            preference.setTitle(s);
        }
    }

    private void setFontSummary(DialogPreference preference, Typeface font) {
        if (preference.getSummary() != null) {
            SpannableStringBuilder s = new SpannableStringBuilder(preference.getSummary());
            s.setSpan(new CustomTypefaceSpan(font), 0, s.length(),
                    Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            preference.setSummary(s);
        }
    }

    private void setFontMessage(DialogPreference preference, Typeface font) {

        if (preference.getDialogMessage() != null) {
            SpannableStringBuilder s = new SpannableStringBuilder(preference.getDialogMessage());
            s.setSpan(new CustomTypefaceSpan(font), 0, s.length(),
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            preference.setDialogMessage(s);
        }
    }

}
