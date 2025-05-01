package com.example.tp4_android.modele;

import com.google.gson.annotations.SerializedName;

public class Personnages {

    @SerializedName("fullName")
    public String nom;
    @SerializedName("hogwartsHouse")
    public String maison;

    @SerializedName("interpretedBy")
    public String interpreteur;

    @SerializedName("image")
    public String cheminImage;
}
