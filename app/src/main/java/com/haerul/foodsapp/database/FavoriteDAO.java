/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/10/19 12:55 AM                                             -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.haerul.foodsapp.model.MealFavorite;

import java.util.List;

@Dao
public interface FavoriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MealFavorite meal);
    
    @Query("SELECT * FROM favorite")
    List<MealFavorite> select();

    @Query("DELETE FROM favorite WHERE strMeal = :name")
    void delete(String name);
    
    @Query("SELECT * FROM favorite WHERE strMeal = :name")
    boolean isFavorite(String name);
}
