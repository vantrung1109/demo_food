package com.example.appfood.di.component;

import com.example.appfood.di.module.FragmentModule;
import com.example.appfood.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = {FragmentModule.class}, dependencies = AppComponent.class)
public interface FragmentComponent {

}