package com.example.nyarticleapp.di.Module;

import android.app.Activity;
import android.content.Context;
import com.example.nyarticleapp.di.Qualifier.ActivityContext;
import com.example.nyarticleapp.di.Scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
  public Context context;
  private Activity mainActivity;

  public MainActivityContextModule(Activity mainActivity) {
    this.mainActivity = mainActivity;
    context = mainActivity;
  }
  @Provides
  @ActivityScope
  public Activity providesMainActivity() {
    return mainActivity;
  }

  @Provides
  @ActivityScope
  @ActivityContext
  public Context provideContext() {
    return context;
  }
}
