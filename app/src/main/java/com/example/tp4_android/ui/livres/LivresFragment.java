package com.example.tp4_android.ui.livres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tp4_android.apiClasses.APIUtilitaire;
import com.example.tp4_android.apiClasses.PotterAPIService;
import com.example.tp4_android.apiClasses.PotterClient;

import com.example.tp4_android.databinding.FragmentLivresBinding;
import com.example.tp4_android.modele.Livre;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class LivresFragment extends Fragment {

    private FragmentLivresBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLivresBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onResume(){
        super.onResume();

        List<Livre> livres = new ArrayList<>();
        LivresAdapter livresAdapter = new LivresAdapter(getContext(), livres);
        PotterAPIService potterAPIService = PotterClient.getClient().create(PotterAPIService.class);

        Call<List<Livre>> call = potterAPIService.chercherLivres();
        APIUtilitaire.appelAPI(call, livresAdapter,binding.listViewLivres,getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}