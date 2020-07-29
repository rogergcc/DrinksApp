/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/24/19 5:35 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rogergcc.drinksapp.R;
import com.rogergcc.drinksapp.databinding.ItemRecyclerMealBinding;
import com.rogergcc.drinksapp.remote.model.Meals;
import com.squareup.picasso.Picasso;

import java.util.List;



public class RecyclerViewMealByCategory extends RecyclerView.Adapter<RecyclerViewMealByCategory.RecyclerViewHolder> {

    private List<Meals.Meal> meals;
    private Context context;
    private static ClickListener clickListener;

    public RecyclerViewMealByCategory(Context context, List<Meals.Meal> meals) {
        this.meals = meals;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewMealByCategory.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_meal,
//                viewGroup, false);

        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        ItemRecyclerMealBinding itemRecyclerMealBinding = ItemRecyclerMealBinding.inflate(layoutInflater,viewGroup,false);
        return new RecyclerViewHolder(itemRecyclerMealBinding);

//        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMealByCategory.RecyclerViewHolder viewHolder, int i) {

        String strMealThumb = meals.get(i).getStrMealThumb();
//        Picasso.get().load(strMealThumb).placeholder(R.drawable.shadow_bottom_to_top).into(viewHolder.mealThumb);
        Picasso.get().load(strMealThumb).placeholder(R.drawable.shadow_bottom_to_top).into(viewHolder.itemRecyclerMealBinding.mealThumb);

        String strMealName = meals.get(i).getStrMeal();
//        viewHolder.mealName.setText(strMealName);
        viewHolder.itemRecyclerMealBinding.mealName.setText(strMealName);
    }


    @Override
    public int getItemCount() {
        return meals.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        @BindView(R.id.mealThumb)
//        ImageView mealThumb;
//        @BindView(R.id.mealName)
//        TextView mealName;

//        RecyclerViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            itemView.setOnClickListener(this);
//        }
            ItemRecyclerMealBinding itemRecyclerMealBinding;
            public RecyclerViewHolder(@NonNull ItemRecyclerMealBinding itemRecyclerMealBinding){
                super(itemRecyclerMealBinding.getRoot());
                this.itemRecyclerMealBinding=itemRecyclerMealBinding;
                //this.itemRecyclerMealBinding.
            }

            public void bindView ( String movie){
                itemRecyclerMealBinding.mealName.setText(movie);
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
}
