package com.example.appfood.data;



import com.example.appfood.data.prefs.PreferencesService;
import com.example.appfood.data.remote.ApiService;

import javax.inject.Inject;

public class AppRepository implements Repository {

    private final ApiService mApiService;
    private final PreferencesService mPreferencesHelper;

    @Inject
    public AppRepository(ApiService apiService, PreferencesService mPreferencesHelper) {
        this.mApiService = apiService;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    @Override
    public String getToken() {
        return mPreferencesHelper.getToken();
    }

    @Override
    public void setToken(String token) {
        mPreferencesHelper.setToken(token);
    }
    @Override
    public PreferencesService getSharedPreferences(){
        return mPreferencesHelper;
    }

    @Override
    public ApiService getApiService(){
        return mApiService;
    }



}
