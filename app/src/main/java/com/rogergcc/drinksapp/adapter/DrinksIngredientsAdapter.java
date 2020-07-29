/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rogergcc.drinksapp.R;
import com.rogergcc.drinksapp.databinding.ItemIngredientsBinding;
import com.rogergcc.drinksapp.databinding.ItemIngredientsBinding;
import com.rogergcc.drinksapp.remote.model.Drinks;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinksIngredientsAdapter extends RecyclerView.Adapter<DrinksIngredientsAdapter.RecyclerViewHolder> {

    private List<Drinks> drinkIngredients;
    private Context context;
    private static ClickListener clickListener;

    public DrinksIngredientsAdapter(List<Drinks> meals, Context context) {
        this.drinkIngredients = meals;
        this.context = context;
    }

//    public void setOnItemClickListener(ClickListener clickListener) {
//        DrinksIngredientsAdapter.clickListener = clickListener;
//    }
//
//    @Override
//    public int getCount() {
//        return drinkIngredients.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//        return view.equals(o);
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.item_view_pager_header,
//                container,
//                false
//        );
//
//        ImageView mealThumb = view.findViewById(R.id.mealThumb);
//        TextView mealName = view.findViewById(R.id.mealName);
//
//        String strMealThumb = drinkIngredients.get(position).getStrdrinkthumb();
//        Picasso.get().load(strMealThumb).into(mealThumb);
//
//        String strMealName = drinkIngredients.get(position).getStrdrink();
//        mealName.setText(strMealName);
//
////        view.setOnClickListener(v -> clickListener.onClick(v, position));
//
//        container.addView(view, 0);
//        return view;
//    }

//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((View)object);
//    }
//
//    public interface ClickListener {
//        void onClick(View v, int position);
//    }
//
//    public DrinksIngredientsAdapter(List<Categories.Category> categories, Context context) {
//        this.categories = categories;
//        this.context = context;
//    }

    @NonNull
    @Override
    public DrinksIngredientsAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category,
//                viewGroup, false);

        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        ItemIngredientsBinding itemRecyclerCategoryBinding = ItemIngredientsBinding.inflate(layoutInflater,viewGroup,false);
        return new DrinksIngredientsAdapter.RecyclerViewHolder(itemRecyclerCategoryBinding);

//        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksIngredientsAdapter.RecyclerViewHolder viewHolder, int i) {

        String strCategoryThum = drinkIngredients.get(i).getStrdrinkthumb();
        Picasso.get().load(strCategoryThum).placeholder(R.drawable.ic_circle).into(viewHolder.ingredientesBinding.mealThumb);

        String strCategoryName = drinkIngredients.get(i).getStrdrink();
        viewHolder.ingredientesBinding.mealName.setText(strCategoryName);
    }


    @Override
    public int getItemCount() {
        return drinkIngredients.size();
    }

    public void setOnItemClickListener(DrinksIngredientsAdapter.ClickListener clickListener) {
        DrinksIngredientsAdapter.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //        @BindView(R.id.categoryThumb)
//        ImageView categoryThumb;
//        @BindView(R.id.categoryName)
//        TextView categoryName;
        ItemIngredientsBinding ingredientesBinding;

        //        RecyclerViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            itemView.setOnClickListener(this);
//        }
        public RecyclerViewHolder(@NonNull ItemIngredientsBinding itemRecyclerCategoryBinding) {
            super(itemRecyclerCategoryBinding.getRoot());
            this.ingredientesBinding = itemRecyclerCategoryBinding;
            //this.itemRecyclerMealBinding.
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

}
