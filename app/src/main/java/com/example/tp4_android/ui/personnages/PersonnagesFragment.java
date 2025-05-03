package com.example.tp4_android.ui.personnages;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tp4_android.apiClasses.APIUtilitaire;
import com.example.tp4_android.apiClasses.PotterAPIService;
import com.example.tp4_android.apiClasses.PotterClient;
import com.example.tp4_android.databinding.FragmentPersonnagesBinding;
import com.example.tp4_android.modele.Livre;
import com.example.tp4_android.modele.Personnages;
import com.example.tp4_android.ui.livres.LivresAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonnagesFragment extends Fragment {

    private FragmentPersonnagesBinding binding;

    private PotterAPIService potterAPIService;

    private PersonnagesAdapter personnagesAdapter;

    private Call<List<Personnages>> call;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPersonnagesBinding.inflate(inflater, container, false);

        potterAPIService = PotterClient.getClient().create(PotterAPIService.class);

        call = potterAPIService.chercherPersonnages(binding.barreRecherche.getText().toString());

        List<Personnages> personnages = new ArrayList<>();
        personnagesAdapter =new PersonnagesAdapter(getContext(), personnages);

        personnagesAdapter.notifyDataSetChanged();

        binding.barreRecherche.setOnEditorActionListener((v,actionId,e)->{
            if(actionId == EditorInfo.IME_ACTION_DONE ||
                    actionId == EditorInfo.IME_ACTION_SEARCH  ||
                    e.getKeyCode()== KeyEvent.KEYCODE_ENTER){

                Call<List<Personnages>> callRecherche = potterAPIService.chercherPersonnages(binding.barreRecherche.getText().toString());
                APIUtilitaire.appelAPI(callRecherche,personnagesAdapter,binding.listViewPersonnages,getActivity());
            }
            return true;
        });
        return binding.getRoot();
    }

    public void onResume(){
        super.onResume();
        APIUtilitaire.appelAPI(call,personnagesAdapter,binding.listViewPersonnages,getActivity());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}