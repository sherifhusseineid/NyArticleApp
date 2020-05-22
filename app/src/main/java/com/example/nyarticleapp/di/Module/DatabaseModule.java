package com.example.nyarticleapp.di.Module;

import android.content.Context;
import androidx.room.Room;
import com.example.nyarticleapp.db.dao.ArticleDao;
import com.example.nyarticleapp.db.database.ArticleDatabase;
import com.example.nyarticleapp.di.Qualifier.ApplicationContext;
import com.example.nyarticleapp.di.Qualifier.DatabaseInfo;
import com.example.nyarticleapp.di.Scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
  @ApplicationContext
  private final Context mContext;

  @DatabaseInfo
  private final String mDBName = "article.db";

  public DatabaseModule(@ApplicationContext Context context) {
    mContext = context;
  }

  @Provides
  @ApplicationScope
  ArticleDatabase provideDatabase() {
    return Room.databaseBuilder(
        mContext,
        ArticleDatabase.class,
        mDBName
    ).fallbackToDestructiveMigration().build();
  }

  @Provides
  @DatabaseInfo
  @ApplicationScope
  String provideDatabaseName() {
    return mDBName;
  }


  @Provides
  @ApplicationScope
  ArticleDao providePersonDao(ArticleDatabase db) {
    return db.articleDao();
  }


}
