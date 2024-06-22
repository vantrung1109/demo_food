package com.example.appfood.di.module;

import android.content.Context;


import androidx.lifecycle.ViewModelProvider;

import com.example.appfood.data.Repository;
import com.example.appfood.di.scope.FragmentScope;
import com.example.appfood.ui.base.BaseFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private BaseFragment<?, ?> fragment;
    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }
    @Named("access_token")
    @Provides
    @FragmentScope
    String provideToken(Repository repository){
        return repository.getToken();
    }


}
