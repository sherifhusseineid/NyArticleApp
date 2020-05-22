package com.example.nyarticleapp.di.Module;

import android.content.Context;
import com.example.nyarticleapp.di.Qualifier.ApplicationContext;
import com.example.nyarticleapp.di.Scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
  private Context context;

  public ContextModule(Context context) {
    this.context = context;
  }

  @Provides
  @ApplicationScope
  @ApplicationContext
  public Context provideContext() {
    return context;
  }
}