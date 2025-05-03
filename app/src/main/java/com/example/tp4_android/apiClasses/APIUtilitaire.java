package com.example.tp4_android.apiClasses;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tp4_android.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIUtilitaire {
    public static <T> void appelAPI(Call<List<T>> call, ArrayAdapter<T> adapter, ListView listView, Activity activity){
        afficherChargementEtErreur(true, false, activity);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<T>> call, Response<List<T>> response){
                afficherChargementEtErreur(false, false, activity);
                if (response.isSuccessful()) {
                    adapter.clear();
                    adapter.addAll(response.body());
                    listView.setAdapter(adapter);

                    if(adapter.isEmpty()){
                        afficherChargementEtErreur(false, true, activity);
                    }
                } else {
                    afficherChargementEtErreur(false, true, activity);
                }
            }
            @Override
            public void onFailure(Call<List<T>> call, Throwable throwable) {
                afficherChargementEtErreur(false, true, activity);
            }
        });
    }
    private static void afficherChargementEtErreur(boolean enChargement, boolean afficherErreur, Activity activity){
        ProgressBar progressBar = activity.findViewById(R.id.progress_bar);
        TextView textViewErreur = activity.findViewById(R.id.text_view_erreur);

        progressBar.setVisibility(enChargement ? ProgressBar.VISIBLE : ProgressBar.GONE);
        textViewErreur.setVisibility(afficherErreur ? TextView.VISIBLE : TextView.GONE);
    }
}
