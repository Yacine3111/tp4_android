package com.example.tp4_android.modele;

import com.google.gson.annotations.SerializedName;

public class Personnages {

    @SerializedName("fullName")
    public String nom;

    @SerializedName("nickname")
    public String surnom;

    @SerializedName("hogwartsHouse")
    public String maison;

    @SerializedName("interpretedBy")
    public String interpreteur;

    @SerializedName("children")
    public String [] enfants;

    @SerializedName("image")
    public String cheminImage;

    @SerializedName("birthdate")
    public String dateNaissance;

    public int index;
}
