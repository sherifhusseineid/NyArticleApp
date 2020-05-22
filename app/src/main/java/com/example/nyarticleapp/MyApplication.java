package com.example.nyarticleapp;

import android.app.Activity;
import android.app.Application;
import com.example.nyarticleapp.di.Module.ContextModule;
import com.example.nyarticleapp.di.Module.DatabaseModule;
import com.example.nyarticleapp.di.component.ApplicationComponent;
import com.example.nyarticleapp.di.component.DaggerApplicationComponent;

/**
 * Created by SherifEid on 21/05/2020.
 */

public class MyApplication extends Application {

  private static MyApplication instance;

  ApplicationComponent applicationComponent;

  @Override
  public void onCreate(){
    super.onCreate();
    instance = this;
    //DaggerApplicationComponent
    applicationComponent = DaggerApplicationComponent.builder()
        .contextModule(new ContextModule(this))
        .databaseModule(new DatabaseModule(this)).build();
    applicationComponent.injectApplication(this);


  }

  public static MyApplication get(Activity activity){
    return (MyApplication) activity.getApplication();
  }
  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  public static synchronized MyApplication getInstance() {
    return instance;
  }
}
