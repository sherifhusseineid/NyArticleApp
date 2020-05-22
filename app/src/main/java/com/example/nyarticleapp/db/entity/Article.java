package com.example.nyarticleapp.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.nyarticleapp.model.response.MediaList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(tableName = "Article")
public class Article implements Parcelable {
  @PrimaryKey
  @SerializedName("id")
  @Expose
  private long id;

  @SerializedName("url")
  @Expose
  private String url;

  @SerializedName("title")
  @Expose
  private String title;

  @SerializedName("abstract")
  @Expose
  private String abstractText;

  @SerializedName("byline")
  @Expose
  private String byLine;

  @SerializedName("published_date")
  @Expose
  private Date publishedDate;

  @SerializedName("media")
  @Expose
  private ArrayList<MediaList> media;

  protected Article(Parcel in) {
    id = in.readLong();
    url = in.readString();
    title = in.readString();
    abstractText = in.readString();
    byLine = in.readString();
  }

  public Article(){}

  public static final Creator<Article> CREATOR = new Creator<Article>() {
    @Override
    public Article createFromParcel(Parcel in) {
      return new Article(in);
    }

    @Override
    public Article[] newArray(int size) {
      return new Article[size];
    }
  };

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAbstractText() {
    return abstractText;
  }

  public void setAbstractText(String abstractText) {
    this.abstractText = abstractText;
  }

  public String getByLine() {
    return byLine;
  }

  public void setByLine(String byLine) {
    this.byLine = byLine;
  }

  public Date getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(Date publishedDate) {
    this.publishedDate = publishedDate;
  }

  public ArrayList<MediaList> getMedia() {
    return media;
  }

  public void setMedia(ArrayList<MediaList> media) {
    this.media = media;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(id);
    dest.writeString(url);
    dest.writeString(title);
    dest.writeString(abstractText);
    dest.writeString(byLine);
  }
}
