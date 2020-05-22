package com.example.nyarticleapp.View.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nyarticleapp.R;
import com.example.nyarticleapp.View.callback.ClickCallBack;
import com.example.nyarticleapp.databinding.RowArticleLayoutBinding;
import com.example.nyarticleapp.db.entity.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleDataAdapter extends RecyclerView.Adapter<ArticleDataAdapter.ArticleViewHolder> {

  private List<Article> articles;
  private ClickCallBack callBack;

  public ArticleDataAdapter(ClickCallBack callBack) {
    this.callBack = callBack;
  }
  @NonNull @Override
  public ArticleDataAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    RowArticleLayoutBinding rowArticleLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.row_article_layout, parent, false);
    return new ArticleViewHolder(rowArticleLayoutBinding);
  }

  @Override
  public void onBindViewHolder(@NonNull ArticleDataAdapter.ArticleViewHolder holder, int position) {
    Article currentArticle = articles.get(position);
    holder.articleListItemBinding.setArticle(currentArticle);

  }

  @Override public int getItemCount() {
    if (articles != null) {
      return articles.size();
    } else {
      return 0;
    }
  }

  public void setArticleList(List<Article> articles) {
    this.articles = articles;
    notifyDataSetChanged();
  }

  class ArticleViewHolder extends RecyclerView.ViewHolder {
    private RowArticleLayoutBinding articleListItemBinding;

    ArticleViewHolder(@io.reactivex.annotations.NonNull RowArticleLayoutBinding articleListItemBinding) {
      super(articleListItemBinding.getRoot());
      this.articleListItemBinding = articleListItemBinding;
    }
  }
}
