package com.example.appfood.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.appfood.constant.Constants;
import com.example.appfood.di.qualifier.PreferenceInfo;
import com.google.gson.Gson;
import com.google.gson.internal.Primitives;

import javax.inject.Inject;

public class AppPreferencesService implements PreferencesService {

    private final SharedPreferences mPrefs;
    private final Gson gson;

    @Inject
    public AppPreferencesService(Context context, @PreferenceInfo String prefFileName, Gson gson) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
        this.gson = gson;
    }

    @Override
    public String getToken() {
        return mPrefs.getString(KEY_BEARER_TOKEN, Constants.VALUE_BEARER_TOKEN_DEFAULT);
    }

    @Override
    public void setToken(String token) {
        mPrefs.edit().putString(KEY_BEARER_TOKEN, token).apply();
    }

}
