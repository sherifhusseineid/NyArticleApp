package com.example.nyarticleapp.helper;

import androidx.room.TypeConverter;
import com.example.nyarticleapp.model.response.MediaList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MediaListConverter {
  @TypeConverter
  public static ArrayList<MediaList> stringToSection(String json) {
    Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<MediaList>>() {}.getType();
    ArrayList<MediaList> mediaLists = gson.fromJson(json, type);
    return mediaLists;
  }

  @TypeConverter
  public static String sectionsToString(ArrayList<MediaList> list) {
    Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<MediaList>>() {}.getType();
    String json = gson.toJson(list, type);
    return json;
  }
}
