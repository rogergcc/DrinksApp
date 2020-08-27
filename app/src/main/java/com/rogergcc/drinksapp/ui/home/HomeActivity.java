package com.rogergcc.drinksapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.rogergcc.drinksapp.R;
import com.rogergcc.drinksapp.adapter.RecyclerViewHomeAdapter;
import com.rogergcc.drinksapp.adapter.ViewPagerHeaderDrinksAdapter;
import com.rogergcc.drinksapp.common.Utils;
import com.rogergcc.drinksapp.databinding.ActivityHomeBinding;
import com.rogergcc.drinksapp.remote.model.Categories;
import com.rogergcc.drinksapp.remote.model.Drinks;
import com.rogergcc.drinksapp.ui.category.CategoryActivity;
import com.rogergcc.drinksapp.ui.detail.DetailActivity;

import java.io.Serializable;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeDrinkView{

    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_POSITION = "position";
    public static final String EXTRA_DETAIL = "detail";

    HomePresenter presenter;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        presenter = new HomePresenter(this);
        presenter.getDrinks();
        presenter.getCategories();

    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.shimmerCategory).setVisibility(View.GONE);
    }

    @Override
    public void setDrinks(List<Drinks> drinks) {
        ViewPagerHeaderDrinksAdapter headerAdapter = new ViewPagerHeaderDrinksAdapter(drinks, this);
        binding.viewPagerHeader.setAdapter(headerAdapter);
        binding.viewPagerHeader.setPadding(20, 0, 150, 0);
        binding.viewPagerHeader.setPadding(50, 0, 150, 0);
        headerAdapter.notifyDataSetChanged();

//        ViewPager.PageTransformer pageTransformer = (page, position) -> {
////            page.setTranslationX(-pageTranslationX * position);
//
//            // Next line scales the item's height. You can remove it if you don't want this effect
//            page.setScaleY(1 - (0.25f * abs(position)));
//            // If you want a fading effect uncomment the next line:
//            // page.alpha = 0.25f + (1 - abs(position))
//        };
//        binding.viewPagerHeader.setPageTransformer(false,pageTransformer);

        headerAdapter.setOnItemClickListener((v, position) -> {
            //TODO #8.1 make an intent to DetailActivity (get the name of the meal from the edit text view, then send the name of the meal to DetailActivity)
            TextView mealName = v.findViewById(R.id.mealName);
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(EXTRA_DETAIL,mealName.getText().toString());
            startActivity(intent);
        });
    }

    @Override
    public void setCategory(List<Categories.Category> category) {
        RecyclerViewHomeAdapter homeAdapter = new RecyclerViewHomeAdapter(category, this);
        binding.recyclerCategory.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false);
        binding.recyclerCategory.setLayoutManager(layoutManager);
        binding.recyclerCategory.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();

        homeAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(this, CategoryActivity.class);
            intent.putExtra(EXTRA_CATEGORY, (Serializable) category);
            intent.putExtra(EXTRA_POSITION, position);
            startActivity(intent);
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Title", message);
    }
}