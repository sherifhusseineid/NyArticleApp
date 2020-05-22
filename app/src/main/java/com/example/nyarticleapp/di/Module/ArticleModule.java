package com.example.nyarticleapp.di.Module;

import com.example.nyarticleapp.db.dao.ArticleDao;
import com.example.nyarticleapp.di.Scope.ActivityScope;
import com.example.nyarticleapp.helper.ApiInterface;
import com.example.nyarticleapp.model.repository.ArticleRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class ArticleModule {
  @Provides
  @ActivityScope ArticleRepository getArticleRepository(ApiInterface apiInterface, ArticleDao articleDao){
    return new ArticleRepository(apiInterface,articleDao);
  }
}
