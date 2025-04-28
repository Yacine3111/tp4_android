package com.example.tp4_android.modele;

import com.google.gson.annotations.SerializedName;

public class Livre {
    @SerializedName("number")
    public int nombre;

    @SerializedName("title")
    public String titre;

    @SerializedName("originalTitle")
    public String titreOriginal;

    @SerializedName("releaseDate")
    public String dateDeSortie;

    public String description;

    public int pages;

    @SerializedName("cover")
    public String cheminCouverture;

    public int index;


}
