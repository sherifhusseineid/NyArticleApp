package com.example.nyarticleapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.nyarticleapp.db.entity.Article;
import com.example.nyarticleapp.model.repository.ArticleRepository;
import dagger.Module;
import java.util.List;
import javax.inject.Inject;

@Module
public class ArticleListViewModel extends ViewModel {
  public ArticleRepository articleRepository;
  private LiveData<List<Article>> responseLiveData;

  @Inject
  public ArticleListViewModel(ArticleRepository articleRepository){
    this.articleRepository = articleRepository;
  }

  public LiveData<List<Article>> getArticleList(){
    responseLiveData = articleRepository.getArticle();
    return responseLiveData;
  }
}
