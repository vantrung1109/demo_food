package com.example.appfood.data;

import com.example.appfood.data.prefs.PreferencesService;
import com.example.appfood.data.remote.ApiService;


public interface Repository {
    String getToken();
    void setToken(String token);
    ApiService getApiService();
    PreferencesService getSharedPreferences();
}
