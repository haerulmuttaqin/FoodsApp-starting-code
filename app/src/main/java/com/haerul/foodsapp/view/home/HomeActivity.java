/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.haerul.foodsapp.R;
import com.haerul.foodsapp.Utils;
import com.haerul.foodsapp.adapter.RecyclerViewHomeAdapter;
import com.haerul.foodsapp.adapter.ViewPagerHeaderAdapter;
import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

// TODO 31 implement the HomeView interface at the end
public class HomeActivity extends AppCompatActivity {

    /*
     * TODO 32 Add @BindView Annotation (1)
     *
     * 1. viewPagerHeader
     * 2. recyclerCategory
     *
     */

    /*
     *  TODO 33 Create variable for presenter;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*
         *  TODO 34 bind the ButterKnife (2)
         */

        /*
         *  TODO 35 Declare the presenter
         *  new HomePresenter(this)
         */
    }

    // TODO 36 Overriding the interface

}
