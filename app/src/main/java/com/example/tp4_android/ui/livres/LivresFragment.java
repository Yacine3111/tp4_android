package com.example.tp4_android.ui.livres;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.example.tp4_android.MainActivity;
import com.example.tp4_android.R;
import com.example.tp4_android.apiClasses.APIUtilitaire;
import com.example.tp4_android.apiClasses.PotterAPIService;
import com.example.tp4_android.apiClasses.PotterClient;
import com.example.tp4_android.databinding.ActivityMainBinding;
import com.example.tp4_android.databinding.FragmentLivresBinding;
import com.example.tp4_android.modele.Livre;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LivresFragment extends Fragment {

    private FragmentLivresBinding binding;

    private PotterAPIService potterAPIService;

    private LivresAdapter livresAdapter;

    private List<Livre> livres;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLivresBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onResume(){

        super.onResume();

        livres = new ArrayList<>();
        livresAdapter = new LivresAdapter(getContext(),livres);
        potterAPIService = PotterClient.getClient().create(PotterAPIService.class);

        Call<List<Livre>> call = potterAPIService.chercherLivres();
        APIUtilitaire.appelAPI(call,livresAdapter,binding.listViewLivres,getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}