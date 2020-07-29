/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/7/19 5:49 PM                                               -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.ui.detail;


import com.rogergcc.drinksapp.remote.model.Drinks;
import com.rogergcc.drinksapp.remote.model.Meals;

import java.util.List;

public interface DetailView {
    //TODO #4 Add void method  for showLoading, hideLoading, setMeal, onErrorLoading;

    //meal
//    void showLoading();
//    void hideLoading();
//    void setMeal(Meals.Meal meal);
//    void onErrorLoading(String message);

    void showLoading();
    void hideLoading();
    void setDrink(Drinks meal);
    void setIngredientes(List<Drinks> drinkIngredientsList);

    void onErrorLoading(String message);
}
