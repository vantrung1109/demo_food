package com.example.appfood.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.appfood.MVVMApplication;
import com.example.appfood.ViewModelProviderFactory;
import com.example.appfood.data.Repository;
import com.example.appfood.di.scope.ActivityScope;
import com.example.appfood.ui.base.BaseActivity;
import com.example.appfood.ui.main.MainActivity;
import com.example.appfood.ui.main.MainViewModel;
import com.example.appfood.ui.test.TestViewModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }
    @Named("access_token")
    @Provides
    @ActivityScope
    String provideToken(Repository repository){
        return repository.getToken();
    }

    @Provides
    @ActivityScope
    MainViewModel provideMainViewModel(Repository repository, Context application) {
        Supplier<MainViewModel> supplier = () -> new MainViewModel(repository, (MVVMApplication)application);
        ViewModelProviderFactory<MainViewModel> factory = new ViewModelProviderFactory<>(MainViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
    }

    @Provides
    @ActivityScope
    TestViewModel provideTestViewModel(Repository repository, Context application) {
        Supplier<TestViewModel> supplier = () -> new TestViewModel(repository, (MVVMApplication)application);
        ViewModelProviderFactory<TestViewModel> factory = new ViewModelProviderFactory<>(TestViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(TestViewModel.class);
    }
}
