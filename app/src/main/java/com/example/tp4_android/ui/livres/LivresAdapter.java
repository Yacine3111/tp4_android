package com.example.tp4_android.ui.livres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tp4_android.R;
import com.example.tp4_android.databinding.LivreLayoutBinding;
import com.example.tp4_android.modele.Livre;

import java.util.List;

public class LivresAdapter extends ArrayAdapter<Livre> {
    public LivresAdapter(Context context, List<Livre> livres){
        super(context,0,livres);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        LivreLayoutBinding binding;

        if(convertView==null){
            binding = LivreLayoutBinding.inflate(LayoutInflater.from(getContext()),parent,false);
            convertView = binding.getRoot();
        }else {
            binding = LivreLayoutBinding.bind(convertView);
        }

        Livre livre = getItem(position);
        String cheminCouverture = livre.cheminCouverture;
        ImageView imageView = binding.livreCouverture;

        binding.textViewTitre.setText(livre.titre);
        binding.textViewDate.setText(livre.dateDeSortie);
        binding.texViewDescription.setText(livre.description);

        if(cheminCouverture!=null){
            Glide.with(getContext())
                    .load(cheminCouverture)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_livre_remplacant_24dp)
                    .error(R.drawable.ic_livre_erreur_24dp)
                    .into(imageView);
        }else{
            binding.livreCouverture.setImageResource(R.drawable.ic_livre_erreur_24dp);
        }
        return convertView;
    }
}
