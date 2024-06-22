package com.example.appfood;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfood.di.component.AppComponent;
import com.example.appfood.di.component.DaggerAppComponent;

import lombok.Getter;
import lombok.Setter;

public class MVVMApplication  extends Application {
    @Getter
    @Setter
    private AppCompatActivity currentActivity;

    @Setter
    @Getter
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
        appComponent.inject(this);
    }
}
