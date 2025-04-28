package com.example.tp4_android.apiClasses;

import com.example.tp4_android.modele.Livre;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PotterAPIService {

    @GET("/fr/books")
    Call<List<Livre>> chercherLivres();

    @GET("https://potterapi-fedeperin.vercel.app/fr/characters")
    Call<ReponsePersonnages> chercherPersonnages
            (
                    @Query("search")
                    String personnageChercher
            );

}
