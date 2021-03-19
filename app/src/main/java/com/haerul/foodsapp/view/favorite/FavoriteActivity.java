/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/10/19 1:25 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.favorite;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.widget.TextView;

import com.haerul.foodsapp.R;
import com.haerul.foodsapp.adapter.RecyclerViewMealFavorite;
import com.haerul.foodsapp.database.FavoriteRepository;
import com.haerul.foodsapp.view.detail.DetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.haerul.foodsapp.view.home.HomeActivity.EXTRA_DETAIL;

public class FavoriteActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    
    FavoriteRepository repository;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        repository = new FavoriteRepository(getApplication());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setClipToPadding(false);
        
    }
    
    void getFavoriteList() {
        repository = new FavoriteRepository(getApplication());
        RecyclerViewMealFavorite adapter = new RecyclerViewMealFavorite(this, repository.select(), repository);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((view, position) -> {
            TextView strMealName = view.findViewById(R.id.mealName);
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(EXTRA_DETAIL, strMealName.getText().toString());
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFavoriteList();
    }
}
