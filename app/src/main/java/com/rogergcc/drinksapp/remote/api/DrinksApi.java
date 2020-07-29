/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.remote.api;



import com.rogergcc.drinksapp.remote.model.Categories;
import com.rogergcc.drinksapp.remote.model.DrinkResponse;
import com.rogergcc.drinksapp.remote.model.Drinks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DrinksApi {
    //https://www.themealdb.com/api/json/v2/1/latest.php
    @GET("popular.php")
    Call<DrinkResponse> getDrinks();

    //https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list

    @GET("list.php?c=list")
    Call<Categories> getCategories();

    //example https://themealdb.com/api/json/v2/1/filter.php?c=Beef
    @GET("filter.php") 
    Call<Drinks> getMealByCategory(@Query("c") String category);

    //TODO #3 Call the search.php with query string the meal name @GET("search.php)

    @GET("search.php")
    Call<DrinkResponse> getDrinkByName(@Query("s") String mealName);
}
