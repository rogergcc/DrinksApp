/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.ui.home;


import com.rogergcc.drinksapp.remote.model.Categories;
import com.rogergcc.drinksapp.remote.model.Drinks;

import java.util.List;

public interface HomeDrinkView {
    void showLoading();
    void hideLoading();
    void setDrinks(List<Drinks> drinks);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
