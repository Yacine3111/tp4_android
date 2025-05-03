package com.example.tp4_android.ui.personnages;

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
import com.example.tp4_android.databinding.PersonnageLayoutBinding;
import com.example.tp4_android.modele.Personnages;

import java.util.List;

public class PersonnagesAdapter extends ArrayAdapter<Personnages> {
    public PersonnagesAdapter(Context context, List<Personnages> livres){
        super(context,0,livres);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        PersonnageLayoutBinding binding;

        if(convertView==null){
            binding = PersonnageLayoutBinding.inflate(LayoutInflater.from(getContext()),parent,false);
            convertView = binding.getRoot();
        }else {
            binding = PersonnageLayoutBinding.bind(convertView);
        }

        Personnages personnage = getItem(position);
        String cheminImage = personnage.cheminImage;
        ImageView imageView = binding.personnageImage;

        binding.textViewNom.setText(personnage.nom);
        binding.textViewMaison.setText(String.format("%s%s", getContext().getString(R.string.texte_maison),
                personnage.maison));

        binding.textViewInterpreterPar.setText(String.format("%s%s", getContext().getString(R.string.texte_interpreteur),
                personnage.interpreteur));

        if(cheminImage!=null){
            Glide.with(getContext())
                    .load(cheminImage)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_livre_remplacant_24dp)
                    .error(R.drawable.ic_livre_erreur_24dp)
                    .circleCrop()
                    .into(imageView);
        }else{
            binding.personnageImage.setImageResource(R.drawable.ic_livre_erreur_24dp);
        }
        return convertView;
    }
}
