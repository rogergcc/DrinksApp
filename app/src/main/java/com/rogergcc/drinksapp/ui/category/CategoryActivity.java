package com.rogergcc.drinksapp.ui.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rogergcc.drinksapp.R;
import com.rogergcc.drinksapp.adapter.ViewPagerCategoryAdapter;
import com.rogergcc.drinksapp.databinding.ActivityCategoryBinding;
import com.rogergcc.drinksapp.databinding.ActivityMainBinding;
import com.rogergcc.drinksapp.remote.model.Categories;
import com.rogergcc.drinksapp.ui.home.HomeActivity;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    ActivityCategoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_category);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    private void initActionBar() {

    }

    private void initIntent() {
        Intent intent = getIntent();
        List<Categories.Category> categories =
                (List<Categories.Category>) intent.getSerializableExtra(HomeActivity.EXTRA_CATEGORY);
        int position = intent.getIntExtra(HomeActivity.EXTRA_POSITION, 0);

        ViewPagerCategoryAdapter adapter = new ViewPagerCategoryAdapter(
                getSupportFragmentManager(),
                categories);
        binding.viewPager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.viewPager.setCurrentItem(position, true);
        adapter.notifyDataSetChanged();

    }
}