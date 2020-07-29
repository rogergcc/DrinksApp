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
import com.rogergcc.drinksapp.databinding.ItemRecyclerCategoryBinding;
import com.rogergcc.drinksapp.remote.model.Categories;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerViewHomeAdapter extends RecyclerView.Adapter<RecyclerViewHomeAdapter.RecyclerViewHolder> {

    private static ClickListener clickListener;
    private List<Categories.Category> categories;
    private Context context;

    public RecyclerViewHomeAdapter(List<Categories.Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHomeAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category,
//                viewGroup, false);

        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        ItemRecyclerCategoryBinding itemRecyclerCategoryBinding = ItemRecyclerCategoryBinding.inflate(layoutInflater,viewGroup,false);
        return new RecyclerViewHolder(itemRecyclerCategoryBinding);

//        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHomeAdapter.RecyclerViewHolder viewHolder, int i) {

        String strCategoryThum = categories.get(i).getStrCategoryThumb();
        Picasso.get().load(strCategoryThum).placeholder(R.drawable.ic_circle).into(viewHolder.itemRecyclerCategoryBinding.categoryThumb);

        String strCategoryName = categories.get(i).getStrCategory();
        viewHolder.itemRecyclerCategoryBinding.categoryName.setText(strCategoryName);
    }


    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewHomeAdapter.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //        @BindView(R.id.categoryThumb)
//        ImageView categoryThumb;
//        @BindView(R.id.categoryName)
//        TextView categoryName;
        ItemRecyclerCategoryBinding itemRecyclerCategoryBinding;

        //        RecyclerViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            itemView.setOnClickListener(this);
//        }
        public RecyclerViewHolder(@NonNull ItemRecyclerCategoryBinding itemRecyclerCategoryBinding) {
            super(itemRecyclerCategoryBinding.getRoot());
            this.itemRecyclerCategoryBinding = itemRecyclerCategoryBinding;
            //this.itemRecyclerMealBinding.
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }
}
