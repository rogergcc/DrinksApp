package com.rogergcc.drinksapp.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.rogergcc.drinksapp.R;
import com.rogergcc.drinksapp.adapter.DrinksIngredientsAdapter;
import com.rogergcc.drinksapp.adapter.RecyclerViewHomeAdapter;
import com.rogergcc.drinksapp.common.Utils;
import com.rogergcc.drinksapp.databinding.ActivityDetailBinding;
import com.rogergcc.drinksapp.remote.model.Drinks;
import com.rogergcc.drinksapp.remote.model.Meals;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.rogergcc.drinksapp.ui.home.HomeActivity.EXTRA_DETAIL;

public class DetailActivity extends AppCompatActivity implements DetailView{

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        setupActionBar();

        Intent intent = getIntent();
        String strMealName = intent.getStringExtra(EXTRA_DETAIL);

        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getDrinkById(strMealName);
    }
    private void setupActionBar() {
        setSupportActionBar(binding.toolbar);
        binding.collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        binding.collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        binding.collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));

        binding.collapsingToolbar.setCollapsedTitleTypeface(ResourcesCompat.getFont(this, R.font.manropemedium));
        binding.collapsingToolbar.setExpandedTitleTypeface(ResourcesCompat.getFont(this, R.font.montserrat_semibold));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        binding.appbar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((binding.collapsingToolbar.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(binding.collapsingToolbar))) {
                if (binding.toolbar.getNavigationIcon() != null)
                    binding.toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (binding.toolbar.getNavigationIcon() != null)
                    binding.toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorWhite),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem favoriteItem = menu.findItem(R.id.favorite);
        Drawable favoriteItemColor = favoriteItem.getIcon();
        setupColorActionBarIcon(favoriteItemColor);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setDrink(Drinks drink) {
        Picasso.get().load(drink.getStrdrinkthumb()).into(binding.mealThumb);
        binding.collapsingToolbar.setTitle(drink.getStrdrink());
        binding.category.setText(drink.getStrcategory());
        binding.country.setText(drink.getStrtags());
        binding.instructions.setText(drink.getStrinstructions());
        setupActionBar();

        //===

        if (!drink.getStringredient1().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient1());
        }
        if (!drink.getStringredient2().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient2());
        }
        if (!drink.getStringredient3().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient3());
        }
        if (!drink.getStringredient4().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient4());
        }
        if (!drink.getStringredient5().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient5());
        }
        if (!drink.getStringredient6().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient6());
        }
        if (!drink.getStringredient7().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient7());
        }
        if (!drink.getStringredient8().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient8());
        }
        if (!drink.getStringredient9().isEmpty()) {//null
            binding.ingredient.append("\n \u2022 " + drink.getStringredient9());
        }
        if (!drink.getStringredient10().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient10());
        }
        if (!drink.getStringredient11().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient11());
        }
        if (!drink.getStringredient12().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient12());
        }
        if (!drink.getStringredient13().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient13());
        }
        if (!drink.getStringredient14().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient14());
        }
        if (!drink.getStringredient15().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + drink.getStringredient15());
        }

//        if (drink.getStringredient16() != null && !drink.getStringredient16().isEmpty()) {
//            binding.ingredient.append("\n \u2022 " + drink.getStringredient16());
//        }
//        if (drink.getStringredient17() != null && !drink.getStringredient17().isEmpty()) {
//            binding.ingredient.append("\n \u2022 " + drink.getStringredient17());
//        }
//        if (drink.getStringredient18() != null && !drink.getStringredient18().isEmpty()) {
//            binding.ingredient.append("\n \u2022 " + drink.getStringredient18());
//        }
//        if (drink.getStringredient19() != null && !drink.getStringredient19().isEmpty()) {
//            binding.ingredient.append("\n \u2022 " + drink.getStringredient19());
//        }
//        if (drink.getStringredient20() != null && !drink.getStringredient20().isEmpty()) {
//            binding.ingredient.append("\n \u2022 " + drink.getStringredient20());
//        }

        // if is null gives error
        if (!drink.getStrmeasure1().isEmpty() && !Character.isWhitespace(drink.getStrmeasure1().charAt(0))) {
            binding.measure.append("\n : " + drink.getStrmeasure1());
        }
        if (!drink.getStrmeasure2().isEmpty() && !Character.isWhitespace(drink.getStrmeasure2().charAt(0))) {
            binding.measure.append("\n : " + drink.getStrmeasure2());
        }
        if (!drink.getStrmeasure3().isEmpty() && !Character.isWhitespace(drink.getStrmeasure3().charAt(0))) {
            binding.measure.append("\n : " + drink.getStrmeasure3());
        }
        if (!drink.getStrmeasure4().isEmpty() && !Character.isWhitespace(drink.getStrmeasure4().charAt(0))) {
            binding.measure.append("\n : " + drink.getStrmeasure4());
        }



        binding.youtube.setOnClickListener(v -> {
//            Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
//            intentYoutube.setData(Uri.parse(drink.getStryoutube()));
//            startActivity(intentYoutube);
        });

        binding.source.setOnClickListener(v -> {
//            Intent intentSource = new Intent(Intent.ACTION_VIEW);
//            intentSource.setData(Uri.parse(drink.getStrSource()));
//            startActivity(intentSource);
        });

    }

    @Override
    public void setIngredientes(List<Drinks> drinkIngredientsList) {
        DrinksIngredientsAdapter drinksIngredientsAdapter = new DrinksIngredientsAdapter(drinkIngredientsList, this);
        binding.recyclerIngredients.setAdapter(drinksIngredientsAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        binding.recyclerIngredients.setLayoutManager(linearLayoutManager);
//        binding.recyclerIngredients.setNestedScrollingEnabled(true);
        drinksIngredientsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Error", message);
    }
}