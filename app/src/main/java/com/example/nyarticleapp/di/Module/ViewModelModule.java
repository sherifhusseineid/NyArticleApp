package com.example.nyarticleapp.di.Module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.nyarticleapp.ViewModel.ArticleListViewModel;
import com.example.nyarticleapp.ViewModel.ViewModelFactory;
import com.example.nyarticleapp.di.Scope.ViewModelKey;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
  @Binds
  abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

  @Binds
  @IntoMap
  @ViewModelKey(ArticleListViewModel.class)
  abstract ViewModel articleViewModel(ArticleListViewModel articleViewModel);
}
