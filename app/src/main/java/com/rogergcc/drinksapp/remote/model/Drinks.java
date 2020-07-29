package com.rogergcc.drinksapp.remote.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Drinks {
    @SerializedName("dateModified")
    private String datemodified;
    @SerializedName("strCreativeCommonsConfirmed")
    private String strcreativecommonsconfirmed;
    @SerializedName("strMeasure4")
    private String strmeasure4;
    @SerializedName("strMeasure3")
    private String strmeasure3;
    @SerializedName("strMeasure2")
    private String strmeasure2;
    @SerializedName("strMeasure1")
    private String strmeasure1;
    @SerializedName("strIngredient5")
    private String stringredient5;
    @SerializedName("strIngredient4")
    private String stringredient4;
    @SerializedName("strIngredient3")
    private String stringredient3;
    @SerializedName("strIngredient2")
    private String stringredient2;
    @SerializedName("strIngredient1")
    private String stringredient1;
    @SerializedName("strDrinkThumb")
    private String strdrinkthumb;
    @SerializedName("strInstructionsDE")
    private String strinstructionsde;
    @SerializedName("strInstructions")
    private String strinstructions;
    @SerializedName("strGlass")
    private String strglass;
    @SerializedName("strAlcoholic")
    private String stralcoholic;
    @SerializedName("strIBA")
    private String striba;
    @SerializedName("strCategory")
    private String strcategory;
    @SerializedName("strTags")
    private String strtags;
    @SerializedName("strDrink")
    private String strdrink;
    @SerializedName("idDrink")
    private String iddrink;
    @SerializedName("strIngredient6")
    @Expose
    private String stringredient6;
    @SerializedName("strIngredient7")
    @Expose
    private String stringredient7;
    @SerializedName("strIngredient8")
    @Expose
    private String stringredient8;
    @Nullable
    @SerializedName("strIngredient9")
    @Expose
    private String stringredient9;
    @SerializedName("strIngredient10")
    @Expose
    private String stringredient10;
    @SerializedName("strIngredient11")
    @Expose
    private String stringredient11;
    @SerializedName("strIngredient12")
    @Expose
    private String stringredient12;
    @SerializedName("strIngredient13")
    @Expose
    private String stringredient13;
    @SerializedName("strIngredient14")
    @Expose
    private String stringredient14;
    @SerializedName("strIngredient15")
    @Expose
    private String stringredient15;

    private List<Drinks> drinkIngredients;

    public String getStringredient6() {
        return (stringredient6 == null) ? "" : stringredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.stringredient6 = strIngredient6;
    }

    public String getStringredient7() {
        return (stringredient7 == null) ? "" : stringredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.stringredient7 = strIngredient7;
    }

    public String getStringredient8() {
        return (stringredient8 == null) ? "" : stringredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.stringredient8 = strIngredient8;
    }

    @Nullable
    public String getStringredient9() {
        return (stringredient9 == null) ? "" : stringredient9;
    }

    public void setStrIngredient9(@Nullable String strIngredient9) {
        this.stringredient9 = strIngredient9;
    }

    public String getStringredient10() {
        return (stringredient10 == null) ? "" : stringredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.stringredient10 = strIngredient10;
    }

    public String getStringredient11() {
        return (stringredient11 == null) ? "" : stringredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.stringredient11 = strIngredient11;
    }

    public String getStringredient12() {
        return (stringredient12 == null) ? "" : stringredient12;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.stringredient12 = strIngredient12;
    }

    public String getStringredient13() {
        return (stringredient13 == null) ? "" : stringredient13;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.stringredient13 = strIngredient13;
    }

    public String getStringredient14() {
        return (stringredient14 == null) ? "" : stringredient14;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.stringredient14 = strIngredient14;
    }

    public String getStringredient15() {
        return (stringredient15 == null) ? "" : stringredient15;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.stringredient15 = strIngredient15;
    }

    public String getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(String datemodified) {
        this.datemodified = datemodified;
    }

    public String getStrcreativecommonsconfirmed() {
        return strcreativecommonsconfirmed;
    }

    public void setStrcreativecommonsconfirmed(String strcreativecommonsconfirmed) {
        this.strcreativecommonsconfirmed = strcreativecommonsconfirmed;
    }

    public String getStrmeasure4() {
        return (strmeasure4==null)?"":strmeasure4;
    }

    public void setStrmeasure4(String strmeasure4) {
        this.strmeasure4 = strmeasure4;
    }

    public String getStrmeasure3() {
        return (strmeasure3==null)?"":strmeasure3;
    }

    public void setStrmeasure3(String strmeasure3) {
        this.strmeasure3 = strmeasure3;
    }

    public String getStrmeasure2() {
        return (strmeasure2==null)?"":strmeasure2;
    }

    public void setStrmeasure2(String strmeasure2) {
        this.strmeasure2 = strmeasure2;
    }

    public String getStrmeasure1() {
        return (strmeasure1==null)?"":strmeasure1;
    }

    public void setStrmeasure1(String strmeasure1) {
        this.strmeasure1 = strmeasure1;
    }

    public String getStringredient5() {
        return (stringredient5==null)?"":stringredient5;
    }

    public void setStringredient5(String stringredient5) {
        this.stringredient5 = stringredient5;
    }

    public String getStringredient4() {
        return (stringredient4==null)?"":stringredient4;
    }

    public void setStringredient4(String stringredient4) {
        this.stringredient4 = stringredient4;
    }

    public String getStringredient3() {
        return (stringredient3==null)?"":stringredient3;
    }

    public void setStringredient3(String stringredient3) {
        this.stringredient3 = stringredient3;
    }

    public String getStringredient2() {
        return (stringredient2==null)?"":stringredient2;
    }

    public void setStringredient2(String stringredient2) {
        this.stringredient2 = stringredient2;
    }

    public String getStringredient1() {
        return (stringredient1==null)?"":stringredient1;
    }

    public void setStringredient1(String stringredient1) {
        this.stringredient1 = stringredient1;
    }

    public String getStrdrinkthumb() {
        return strdrinkthumb;
    }

    public void setStrdrinkthumb(String strdrinkthumb) {
        this.strdrinkthumb = strdrinkthumb;
    }

    public String getStrinstructionsde() {
        return strinstructionsde;
    }

    public void setStrinstructionsde(String strinstructionsde) {
        this.strinstructionsde = strinstructionsde;
    }

    public String getStrinstructions() {
        return strinstructions;
    }

    public void setStrinstructions(String strinstructions) {
        this.strinstructions = strinstructions;
    }

    public String getStrglass() {
        return strglass;
    }

    public void setStrglass(String strglass) {
        this.strglass = strglass;
    }

    public String getStralcoholic() {
        return stralcoholic;
    }

    public void setStralcoholic(String stralcoholic) {
        this.stralcoholic = stralcoholic;
    }

    public String getStriba() {
        return striba;
    }

    public void setStriba(String striba) {
        this.striba = striba;
    }

    public String getStrcategory() {
        return strcategory;
    }

    public void setStrcategory(String strcategory) {
        this.strcategory = strcategory;
    }

    public String getStrtags() {
        return strtags;
    }

    public void setStrtags(String strtags) {
        this.strtags = strtags;
    }

    public String getStrdrink() {
        return strdrink;
    }

    public void setStrdrink(String strdrink) {
        this.strdrink = strdrink;
    }

    public String getIddrink() {
        return iddrink;
    }

    public void setIddrink(String iddrink) {
        this.iddrink = iddrink;
    }



    public void setDrinkIngredients(List<Drinks> drinkIngredients) {
        this.drinkIngredients = drinkIngredients;
    }
}
