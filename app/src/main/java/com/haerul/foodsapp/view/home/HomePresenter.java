/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.home;

import com.haerul.foodsapp.Utils;
import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter {

    private HomeView view;

    // TODO 15 Create the constructor (View)

    void getMeals() {
        // TODO 16 do loading before making a request to the server

        // TODO 17 with the line you have made a request
        Call<Meals> mealsCall = Utils.getApi().getMeal();

        // TODO 19 waiting for Callback
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                // TODO 20 Close loading when you have received a response from the server

                // TODO 21 Non-empty results check & Non-empty results check
                if (response.isSuccessful() && response.body() != null) {
                    /*
                     * TODO 22 Receive the result
                     * input the results obtained into the setMeals() behavior
                     * and enter response.body() to the parameter
                     */


                }
                else {
                    // TODO 23 Show an error message if the conditions are not met

                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */

                // TODO 24 Close loading
                // TODO 25 Show an error message
            }
        });
    }


    void getCategories() {
        // TODO 26 do loading before making a request to the server

        // TODO 27 create Call<Categories> categoriesCall = ...
        Call<Categories> categoriesCall = null;

        // TODO 28 waiting for enqueue Callback
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                // TODO 29 Non-empty results check & Non-empty results check
                if (response.isSuccessful() && response.body() != null) {
                    /*
                     * TODO 30 Receive the result
                     * input the results obtained into the setMeals() behavior
                     * and enter response.body() to the parameter
                     */


                }
                else {
                    // TODO 31 Show an error message if the conditions are not met

                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */

                // TODO 32 Close loading
                // TODO 33 Show an error message
            }
        });
    }
}
