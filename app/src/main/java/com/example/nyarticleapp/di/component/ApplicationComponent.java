package com.example.nyarticleapp.di.component;

import android.content.Context;
import com.example.nyarticleapp.MyApplication;
import com.example.nyarticleapp.db.dao.ArticleDao;
import com.example.nyarticleapp.di.Module.ContextModule;
import com.example.nyarticleapp.di.Module.DatabaseModule;
import com.example.nyarticleapp.di.Module.RetrofitModule;
import com.example.nyarticleapp.di.Qualifier.ApplicationContext;
import com.example.nyarticleapp.di.Qualifier.DatabaseInfo;
import com.example.nyarticleapp.di.Scope.ApplicationScope;
import com.example.nyarticleapp.helper.ApiInterface;
import dagger.Component;

/******************************************************************************
 * Module: ApplicationComponent
 *
 * File Name: ApplicationComponent.java
 *
 * Description: Source file for inject Application Component
 *
 * Author: Sherif Eid
 ******************************************************************************/

@ApplicationScope
@Component(modules = { ContextModule.class, DatabaseModule.class, RetrofitModule.class})
public interface ApplicationComponent {
  @ApplicationContext
  Context getContext();

  ApiInterface getApiInterface();

  ArticleDao getArticleDao();

  @DatabaseInfo
  String getDatabaseName();

  void injectApplication(MyApplication myApplication);
}
