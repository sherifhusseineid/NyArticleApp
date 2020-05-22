package com.example.nyarticleapp.helper;

import com.example.nyarticleapp.db.entity.Article;
import com.example.nyarticleapp.model.response.ArticleResponse;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
  @GET("viewed/{time-period}.json") Single<ArticleResponse> getArticleList(@Path("time-period") int timePeriod,@Query("api-key") String apiKey);
}
