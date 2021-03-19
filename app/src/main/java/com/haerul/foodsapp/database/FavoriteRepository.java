/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/11/19 4:26 PM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.database;

import android.app.Application;

import com.haerul.foodsapp.model.MealFavorite;

import java.util.List;

public class FavoriteRepository {

    private FavoriteDAO favoriteDAO;
    
    public FavoriteRepository(Application application) {
        FavoriteDB database = FavoriteDB.getDatabase(application);
        favoriteDAO = database.favoriteDAO();
    }
    
    public void insert(MealFavorite meal) {
        favoriteDAO.insert(meal);
    }
    
    public void delete(String name) {
        favoriteDAO.delete(name);
    }
    
    public List<MealFavorite> select() {
        return favoriteDAO.select();
    }
    
    public boolean isFavorite(String name) {
        return favoriteDAO.isFavorite(name);
    }
}
