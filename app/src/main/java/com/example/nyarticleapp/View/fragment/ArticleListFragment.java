package com.example.nyarticleapp.View.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nyarticleapp.MyApplication;
import com.example.nyarticleapp.R;
import com.example.nyarticleapp.View.activity.MainActivity;
import com.example.nyarticleapp.View.adapter.ArticleDataAdapter;
import com.example.nyarticleapp.View.callback.ClickCallBack;
import com.example.nyarticleapp.ViewModel.ArticleListViewModel;
import com.example.nyarticleapp.ViewModel.ViewModelFactory;
import com.example.nyarticleapp.databinding.FragmentArticleListBinding;
import com.example.nyarticleapp.db.dao.ArticleDao;
import com.example.nyarticleapp.db.entity.Article;
import com.example.nyarticleapp.di.component.ApplicationComponent;
import com.example.nyarticleapp.di.component.DaggerFragmentArticleListComponent;
import com.example.nyarticleapp.di.component.FragmentArticleListComponent;
import com.example.nyarticleapp.model.repository.ArticleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class ArticleListFragment extends Fragment implements ClickCallBack {
  private static final String TAG = "ArticleListFragment";
  @Inject
  ArticleRepository articleRepository;
  @Inject
  ViewModelFactory viewModelFactory;
  @Inject
  ArticleDao articleDao;
  private View view;
  private ArticleListViewModel viewModel;
  private ArticleDataAdapter articleDataAdapter;
  private FragmentArticleListBinding binding;

  public ArticleListFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_list, container, false);
    view = binding.getRoot();
    binding.setLifecycleOwner(this);
    initDaggerComponent();
    initRecycleView();
    initViewModel();
    return view;
  }

  private void initRecycleView() {
    RecyclerView articleListRecyclerView = binding.articleListRecyclerView;
    articleListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    articleListRecyclerView.setHasFixedSize(true);
    articleDataAdapter = new ArticleDataAdapter(this);
    articleListRecyclerView.setAdapter(articleDataAdapter);
  }

  private void initDaggerComponent() {
    ApplicationComponent
        applicationComponent =
        MyApplication.get(Objects.requireNonNull(getActivity())).getApplicationComponent();
    FragmentArticleListComponent fragmentArticleListComponent =
        DaggerFragmentArticleListComponent.builder()
            .applicationComponent(applicationComponent)
            .build();
    fragmentArticleListComponent.injectArticleListFragment(this);
  }

  private void initViewModel() {
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(ArticleListViewModel.class);
    gitListOfArticle();
  }

  private void gitListOfArticle() {
    viewModel.getArticleList().observe(this, article -> {
      binding.loadingLayout.setVisibility(View.GONE);
      if (article != null) {
        if (article.size() > 0) {
          articleDataAdapter.setArticleList(article);
          binding.articleListRecyclerView.setVisibility(View.VISIBLE);
        }
      }
    });
  }
}
