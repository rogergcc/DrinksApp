/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.ui.home;



import androidx.annotation.NonNull;

import com.rogergcc.drinksapp.common.Utils;
import com.rogergcc.drinksapp.remote.model.Categories;
import com.rogergcc.drinksapp.remote.model.DrinkResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter {

    private HomeDrinkView view;

    public HomePresenter(HomeDrinkView view) {
        this.view = view;
    }

    void getDrinks() {

        view.showLoading();

        Call<DrinkResponse> mealsCall = Utils.getDrinkApi().getDrinks();
        mealsCall.enqueue(new Callback<DrinkResponse>() {
            @Override
            public void onResponse(@NonNull Call<DrinkResponse> call, @NonNull Response<DrinkResponse> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {

                    view.setDrinks(response.body().getDrinks());

                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<DrinkResponse> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }


    void getCategories() {

        view.showLoading();

        Call<Categories> categoriesCall = Utils.getApi().getCategories();
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call,
                                   @NonNull Response<Categories> response) {

                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {

                    view.setCategory(response.body().getCategories());

                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
