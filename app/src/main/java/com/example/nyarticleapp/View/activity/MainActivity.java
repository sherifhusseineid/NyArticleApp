package com.example.nyarticleapp.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import com.example.nyarticleapp.MyApplication;
import com.example.nyarticleapp.R;
import com.example.nyarticleapp.View.fragment.ArticleListFragment;
import com.example.nyarticleapp.databinding.ActivityMainBinding;
import com.example.nyarticleapp.di.component.ApplicationComponent;
import com.example.nyarticleapp.di.component.DaggerMainActivityComponent;
import com.example.nyarticleapp.di.component.MainActivityComponent;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
  @Inject
  ArticleListFragment listFragment;
  FragmentTransaction transaction;
  ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initDaggerComponent();
    binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
    binding.setLifecycleOwner(this);
    replaceArticleListFragment();
  }

  private void initDaggerComponent() {
    ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
    MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
        .applicationComponent(applicationComponent)
        .build();
    mainActivityComponent.injectMainActivity(this);
  }

  private void replaceArticleListFragment() {
    listFragment = new ArticleListFragment();
    transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.fragmentContainer,listFragment);
    transaction.addToBackStack("tag");
    transaction.commit();
  }
}
