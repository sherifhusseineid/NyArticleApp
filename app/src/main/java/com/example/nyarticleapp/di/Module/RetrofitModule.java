package com.example.nyarticleapp.di.Module;

import com.example.nyarticleapp.di.Scope.ApplicationScope;
import com.example.nyarticleapp.helper.ApiInterface;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.nyarticleapp.helper.StaticValue.baseUrl;

@Module
public class RetrofitModule {
  @Provides
  @ApplicationScope
  ApiInterface getApiInterface(Retrofit retroFit) {
    return retroFit.create(ApiInterface.class);
  }

  @Provides
  @ApplicationScope
  Retrofit getRetrofit(OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build();
  }


  @Provides
  @ApplicationScope
  OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
    return new OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build();
  }

  @Provides
  @ApplicationScope
  HttpLoggingInterceptor getHttpLoggingInterceptor() {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return httpLoggingInterceptor;
  }
}
