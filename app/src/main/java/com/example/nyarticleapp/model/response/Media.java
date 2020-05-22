package com.example.nyarticleapp.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Media {
  @SerializedName("media-metadata")
  List<MediaMetaData> mediaMetaDatas;

  public List<MediaMetaData> getMediaMetaDates() {
    return mediaMetaDatas;
  }
}
