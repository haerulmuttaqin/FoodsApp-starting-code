/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/10/19 1:22 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haerul.foodsapp.R;
import com.haerul.foodsapp.database.FavoriteRepository;
import com.haerul.foodsapp.model.MealFavorite;
import com.haerul.foodsapp.model.Meals;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewMealByCategory extends RecyclerView.Adapter<RecyclerViewMealByCategory.RecyclerViewHolder> {

    private List<Meals.Meal> meals;
    private Context context;
    private static ClickListener clickListener;
    private FavoriteRepository repository;

    public RecyclerViewMealByCategory(Context context, List<Meals.Meal> meals, FavoriteRepository repository) {
        this.meals = meals;
        this.context = context;
        this.repository = repository;
    }

    @NonNull
    @Override
    public RecyclerViewMealByCategory.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_meal,
                viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMealByCategory.RecyclerViewHolder viewHolder, int i) {

        String strMealThumb = meals.get(i).getStrMealThumb();
        Picasso.get().load(strMealThumb).placeholder(R.drawable.shadow_bottom_to_top).into(viewHolder.mealThumb);

        String strMealName = meals.get(i).getStrMeal();
        viewHolder.mealName.setText(strMealName);

        if (isFavorite(strMealName)) {
            viewHolder.love.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
        } else {
            viewHolder.love.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_border));
        }

        viewHolder.love.setOnClickListener(v -> {
            addOrRemoveToFavorite(meals.get(i));
            if (isFavorite(strMealName)) {
                viewHolder.love.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
            } else {
                viewHolder.love.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_border));
            }
        });
    }


    @Override
    public int getItemCount() {
        return meals.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.mealThumb)
        ImageView mealThumb;
        @BindView(R.id.mealName)
        TextView mealName;
        @BindView(R.id.love) 
        ImageView love;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewMealByCategory.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }

    private void addOrRemoveToFavorite(Meals.Meal meal) {
        if (isFavorite(meal.getStrMeal())) {
            repository.delete(meal.getStrMeal());
        } else {
            MealFavorite mealFavorite = new MealFavorite();
            mealFavorite.idMeal = meal.getIdMeal();
            mealFavorite.strMeal = meal.getStrMeal();
            mealFavorite.strMealThumb = meal.getStrMealThumb();
            repository.insert(mealFavorite);
        }
    }

    private boolean isFavorite(String strMealName) {
        return repository.isFavorite(strMealName);
    }
}
