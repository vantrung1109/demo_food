package com.example.appfood.data.prefs;

import android.content.SharedPreferences;

public interface PreferencesService {
    public static final String KEY_BEARER_TOKEN="KEY_BEARER_TOKEN";

    String getToken();
    void setToken(String token);
}
