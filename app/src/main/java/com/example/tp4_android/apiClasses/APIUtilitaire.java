package com.example.tp4_android.apiClasses;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tp4_android.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIUtilitaire {
    public static <T> void appelAPI(Call<List<T>> call, ArrayAdapter<T> adapter, ListView listView, Activity activity){
        afficherChargementEtErreur(true, false, activity,"");
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<T>> call, @NonNull Response<List<T>> response){
                afficherChargementEtErreur(false, false, activity,"");
                if (response.isSuccessful()) {
                    traiterReponseReussie(response, adapter, listView, activity);
                } else {
                    afficherChargementEtErreur(false, true, activity," "+response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<T>> call, @NonNull Throwable throwable) {
                afficherChargementEtErreur(false, true, activity," "+throwable.getMessage());
            }
        });
    }

    private static <T> void traiterReponseReussie(Response<List<T>> response, ArrayAdapter<T> adapter, ListView listView, Activity activity) {
        adapter.clear();
        adapter.addAll(response.body());
        listView.setAdapter(adapter);

        if (adapter.isEmpty()) {
            EditText barreRecherche = activity.findViewById(R.id.barre_recherche);
            afficherChargementEtErreur(false, true, activity,"\""+barreRecherche.getText().toString()+"\"");
        }
    }
    private static void afficherChargementEtErreur(boolean enChargement, boolean afficherErreur, Activity activity, String message){
        ProgressBar progressBar = activity.findViewById(R.id.progress_bar);
        TextView textViewErreur = activity.findViewById(R.id.text_view_erreur);

        progressBar.setVisibility(enChargement ? ProgressBar.VISIBLE : ProgressBar.GONE);

        if (afficherErreur) {
            textViewErreur.setVisibility(TextView.VISIBLE);
            textViewErreur.setText(String.format("%s %s", activity.getString(R.string.message_erreur), message));
        } else {
            textViewErreur.setVisibility(TextView.GONE);
        }
    }
}
