package com.example.nyarticleapp.model.repository;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.nyarticleapp.db.Executor;
import com.example.nyarticleapp.db.dao.ArticleDao;
import com.example.nyarticleapp.db.entity.Article;
import com.example.nyarticleapp.helper.ApiInterface;
import com.example.nyarticleapp.model.response.ArticleResponse;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

import static com.example.nyarticleapp.helper.StaticValue.apiKey;
import static com.example.nyarticleapp.helper.StaticValue.timePeriod;

/******************************************************************************
 * Module: ArticleRepository
 *
 * File Name: ArticleRepository.java
 *
 * Description: Source file for ArticleRepository to get list of article
 *
 * Author: Sherif Eid
 ******************************************************************************/

public class ArticleRepository {
  private static final String TAG = "ArticleRepository";
  private ApiInterface apiInterface;
  private ArticleDao articleDao;
  private CompositeDisposable disposable = new CompositeDisposable();

  @Inject
  public ArticleRepository(ApiInterface apiInterface, ArticleDao articleDao) {
    this.apiInterface = apiInterface;
    this.articleDao = articleDao;
  }

  /************************************************************************************
   * Function Name: getArticle
   * Parameters (in): None
   * Return value: liveData-list of article
   * Description: responsible to get list of article*
   **********************************************************************************/

  public LiveData<List<Article>> getArticle() {

    final MutableLiveData<List<Article>> data = new MutableLiveData<>();

    Single<ArticleResponse> articleObservable = apiInterface.getArticleList(timePeriod,apiKey);

    DisposableSingleObserver<ArticleResponse> disposableSingleObserver =
        new DisposableSingleObserver<ArticleResponse>() {
          @Override public void onSuccess(ArticleResponse articleResponse) {
            Executor.IOThread(() -> articleDao.saveArticles(articleResponse.getArticles()));
            data.setValue(articleDao.getAllArticles().getValue());
          }

          @Override public void onError(Throwable e) {
            data.setValue(null);

            Log.w(TAG, "onError: " + e.getLocalizedMessage() + " " + e.getMessage());
          }
        };

    disposable.add(articleObservable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(disposableSingleObserver));

    return articleDao.getAllArticles();
  }
}
