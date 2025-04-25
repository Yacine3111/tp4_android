package com.example.tp4_android.ui.personnages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.tp4_android.databinding.FragmentPersonnagesBinding;

public class PersonnagesFragment extends Fragment {

    private FragmentPersonnagesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PersonnagesViewModel personnagesViewModel =
                new ViewModelProvider(this).get(PersonnagesViewModel.class);

        binding = FragmentPersonnagesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}