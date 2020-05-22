package com.example.nyarticleapp.di.Module;

import com.example.nyarticleapp.View.fragment.ArticleListFragment;
import com.example.nyarticleapp.di.Scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
  @Provides
  @ActivityScope
  ArticleListFragment getArticleListFragment(){return  new ArticleListFragment();}
}
