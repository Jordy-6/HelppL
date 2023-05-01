package com.example.helppl;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helppl.databinding.ActivityCentreBinding;
import com.example.helppl.databinding.InfoBinding;

public class Info extends AppCompatActivity {

    @NonNull InfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = InfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");
            String adresse = intent.getStringExtra("adresse");
            String horaire = intent.getStringExtra("horaire");
            String tel = intent.getStringExtra("tel");
            int img = intent.getIntExtra("img",R.drawable.sans_titre);

            binding.nameProfile.setText(name);
            binding.adresse.setText(adresse);
            binding.countryProfile.setText(horaire);
            binding.phoneProfile.setText(tel);
            binding.profileImage.setImageResource(img);
        }

    }
}
