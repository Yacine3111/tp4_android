package com.example.tp4_android.apiClasses;

import com.example.tp4_android.modele.Livre;
import com.example.tp4_android.modele.Personnages;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PotterAPIService {

    @GET("fr/books")
    Call<List<Livre>> chercherLivres();

    @GET("fr/characters")
    Call<List<Personnages>> chercherPersonnages
            (
                    @Query("search")
                    String personnageChercher
            );
}
