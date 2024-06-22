package com.example.appfood.di.component;

import com.example.appfood.di.module.ActivityModule;
import com.example.appfood.di.scope.ActivityScope;
import com.example.appfood.ui.main.MainActivity;
import com.example.appfood.ui.test.TestActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(TestActivity activity);
}
