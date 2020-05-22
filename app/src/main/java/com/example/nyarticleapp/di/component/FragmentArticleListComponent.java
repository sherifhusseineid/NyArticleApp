package com.example.nyarticleapp.di.component;

import com.example.nyarticleapp.View.fragment.ArticleListFragment;
import com.example.nyarticleapp.di.Module.ArticleModule;
import com.example.nyarticleapp.di.Module.ViewModelModule;
import com.example.nyarticleapp.di.Scope.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(modules = { ViewModelModule.class, ArticleModule.class}, dependencies = ApplicationComponent.class)
public interface FragmentArticleListComponent {
  void injectArticleListFragment(ArticleListFragment listFragment);
}
