package com.example.nyarticleapp.di.component;

import com.example.nyarticleapp.View.activity.MainActivity;
import com.example.nyarticleapp.di.Module.MainActivityModule;
import com.example.nyarticleapp.di.Module.ViewModelModule;
import com.example.nyarticleapp.di.Scope.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(modules = { ViewModelModule.class, MainActivityModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
  void injectMainActivity(MainActivity mainActivity);
}
