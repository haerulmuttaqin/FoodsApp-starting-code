/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/10/19 12:27 AM                                             -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.haerul.foodsapp.model.MealFavorite;

@Database(entities = {MealFavorite.class}, version = 1, exportSchema = false)
public abstract class FavoriteDB extends RoomDatabase {
    public abstract FavoriteDAO favoriteDAO();

    private static FavoriteDB INSTANCE;

    public static FavoriteDB getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (FavoriteDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, FavoriteDB.class, "favorite.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    
}
