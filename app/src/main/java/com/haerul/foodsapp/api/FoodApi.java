/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.api;

import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("latest.php")
    Call<Meals> getMeal();

    // TODO 12 also make the Call like getMeals() method for category

    /*
     * @GET (" url ") -->
     *     this is the request annotation with REQUEST METHOD [GET]
     *
     * Call <Object> methodName(); -->
     *     we will make the getCategoris () method with the Call <Category> || method meaning
     *     that the result of the request [GET] will be accommodated into Object (Category)
     *
     */
}
