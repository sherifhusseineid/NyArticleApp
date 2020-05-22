package com.example.nyarticleapp.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.nyarticleapp.db.entity.Article;
import java.util.List;

@Dao
public interface ArticleDao {
  // Select all from Article table
  @Query("SELECT * FROM Article")
  LiveData<List<Article>> getAllArticles();

  // Select one article from articles table by id
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void saveArticles(List<Article> ArticleList);

}
