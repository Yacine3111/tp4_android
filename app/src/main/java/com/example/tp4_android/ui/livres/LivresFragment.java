package com.example.tp4_android.ui.livres;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tp4_android.apiClasses.PotterAPIService;
import com.example.tp4_android.apiClasses.PotterClient;
import com.example.tp4_android.databinding.FragmentLivresBinding;
import com.example.tp4_android.modele.Livre;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LivresFragment extends Fragment {

    private FragmentLivresBinding binding;

    private PotterAPIService potterAPIService;

    private LivresAdapter livresAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLivresBinding.inflate(inflater, container, false);

        potterAPIService = PotterClient.getClient().create(PotterAPIService.class);

        Call<List<Livre>> call = potterAPIService.chercherLivres();



        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Livre>> call, Response<List<Livre>> response) {
                if (response.isSuccessful()) {
                    List<Livre> livres = response.body();
                    livresAdapter = new LivresAdapter(getContext(),livres);
                    binding.listViewLivre.setAdapter(livresAdapter);
                } else {
                    Toast.makeText(getContext(), "Un problème est survenu. " +
                            "Impossible de charger les livre", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Livre>> call, Throwable throwable) {
                Log.e("ERREUR", " "+ throwable.getMessage(), throwable);
            }
        });

        //livresAdapter.notifyDataSetChanged();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}