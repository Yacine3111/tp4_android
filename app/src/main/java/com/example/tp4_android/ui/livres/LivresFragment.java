package com.example.tp4_android.ui.livres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.tp4_android.databinding.FragmentLivresBinding;

public class LivresFragment extends Fragment {

    private FragmentLivresBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LivresViewModel livresViewModel =
                new ViewModelProvider(this).get(LivresViewModel.class);

        binding = FragmentLivresBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}