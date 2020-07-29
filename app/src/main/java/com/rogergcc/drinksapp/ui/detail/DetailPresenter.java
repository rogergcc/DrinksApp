/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/7/19 7:07 PM                                               -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.ui.detail;

import android.util.Log;

import com.rogergcc.drinksapp.common.Utils;
import com.rogergcc.drinksapp.remote.api.FoodClient;
import com.rogergcc.drinksapp.remote.model.DrinkResponse;
import com.rogergcc.drinksapp.remote.model.Drinks;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getDrinkById(String mealName) {
        Log.e(TAG, "onResponse: "+mealName);
        //TODO #5 Call the void show loading before starting to make a request to the server
        view.showLoading();
        //TODO #6 Make a request to the server (Don't forget to hide loading when the response is received)
        Utils.getDrinkApi().getDrinkByName(mealName)
                .enqueue(new Callback<DrinkResponse>() {
                    @Override
                    public void onResponse(Call<DrinkResponse> call, Response<DrinkResponse> response) {
                        view.hideLoading();
                        if (response.isSuccessful() && response.body() !=null){

                            view.setDrink(response.body().getDrinks().get(0));
                            List<Drinks> drinkIngredientsLis = new ArrayList<>();

                            Drinks ingredients1 = new Drinks();
                            Drinks ingredients2 = new Drinks();
                            Drinks ingredients3 = new Drinks();
                            Drinks ingredients4 = new Drinks();
                            Drinks ingredients5 = new Drinks();
                            Drinks ingredients6 = new Drinks();
                            Drinks ingredients7 = new Drinks();
                            Drinks ingredients8 = new Drinks();
                            Drinks ingredients9 = new Drinks();
                            Drinks ingredients10 = new Drinks();


                            ingredients1.setStrdrink(response.body().getDrinks().get(0).getStringredient1());
                            ingredients1.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient1()+"-Medium.png");



                            ingredients2.setStrdrink(response.body().getDrinks().get(0).getStringredient2());
                            ingredients2.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient2()+"-Medium.png");



                            ingredients3.setStrdrink(response.body().getDrinks().get(0).getStringredient3());
                            ingredients3.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient3()+"-Medium.png");


                            ingredients4.setStrdrink(response.body().getDrinks().get(0).getStringredient4());
                            ingredients4.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient4()+"-Medium.png");


                            ingredients5.setStrdrink(response.body().getDrinks().get(0).getStringredient5());
                            ingredients5.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient5()+"-Medium.png");


                            ingredients6.setStrdrink(response.body().getDrinks().get(0).getStringredient6());
                            ingredients6.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient6()+"-Medium.png");


                            ingredients7.setStrdrink(response.body().getDrinks().get(0).getStringredient7());
                            ingredients7.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient7()+"-Medium.png");


                            ingredients8.setStrdrink(response.body().getDrinks().get(0).getStringredient8());
                            ingredients8.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient8()+"-Medium.png");


                            ingredients9.setStrdrink(response.body().getDrinks().get(0).getStringredient9());
                            ingredients9.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient9()+"-Medium.png");


                            ingredients10.setStrdrink(response.body().getDrinks().get(0).getStringredient10());
                            ingredients10.setStrdrinkthumb(FoodClient.BASE_DRINKS_INGREDIENT_IMAGE_URL+response.body().getDrinks().get(0).getStringredient10()+"-Medium.png");


                            if (!ingredients1.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients1);
                            if (!ingredients2.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients2);
                            if (!ingredients3.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients3);
                            if (!ingredients4.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients4);
                            if (!ingredients5.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients5);
                            if (!ingredients6.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients6);
                            if (!ingredients7.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients7);
                            if (!ingredients8.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients8);
                            if (!ingredients9.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients9);
                            if (!ingredients10.getStrdrink().equals(""))
                                drinkIngredientsLis.add(ingredients10);

                            view.setIngredientes(drinkIngredientsLis);
                        }else {
                            view.onErrorLoading(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<DrinkResponse> call, Throwable t) {
                        view.hideLoading();
                        view.onErrorLoading(t.getLocalizedMessage());
                    }
                });
        //TODO #7 Set response (meal)

    }
}
