package com.example.nyarticleapp.db.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.example.nyarticleapp.db.dao.ArticleDao;
import com.example.nyarticleapp.db.entity.Article;
import com.example.nyarticleapp.helper.DateConverter;
import com.example.nyarticleapp.helper.MediaListConverter;

@Database(entities = {Article.class}, version = 1, exportSchema = false)
@TypeConverters({MediaListConverter.class, DateConverter.class })
public abstract class ArticleDatabase extends RoomDatabase {
  public abstract ArticleDao articleDao();
}
