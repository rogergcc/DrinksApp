/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.rogergcc.drinksapp.common;

import android.app.AlertDialog;
import android.content.Context;

import com.rogergcc.drinksapp.remote.api.DrinksApi;
import com.rogergcc.drinksapp.remote.api.FoodApi;
import com.rogergcc.drinksapp.remote.api.FoodClient;


public class Utils {

    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static DrinksApi getDrinkApi() {
        return FoodClient.getDrinkClient().create(DrinksApi.class);
    }
    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }


}
