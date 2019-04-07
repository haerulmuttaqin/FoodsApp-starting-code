/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/7/19 7:07 PM                                               -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.detail;

import android.support.annotation.NonNull;

import com.haerul.foodsapp.Utils;
import com.haerul.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getMealById(String mealName) {
        
        //TODO #5 Call the void show loading before starting to make a request to the server
        
        //TODO #6 Make a request to the server (Don't forget to hide loading when the response is received)
        
        //TODO #7 Set response (meal)
    }
}
