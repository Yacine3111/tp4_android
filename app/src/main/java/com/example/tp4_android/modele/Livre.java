package com.example.tp4_android.modele;

import com.google.gson.annotations.SerializedName;

public class Livre {
    @SerializedName("title")
    public String titre;

    @SerializedName("releaseDate")
    public String dateDeSortie;

    public String description;

    @SerializedName("cover")
    public String cheminCouverture;



}
