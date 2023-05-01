package com.example.helppl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.helppl.databinding.ActivityCentreBinding;



import java.util.ArrayList;

public class CentreActivity extends AppCompatActivity {

    ActivityCentreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCentreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.chrs_flandre,R.drawable.indispo,R.drawable.sans_titre,R.drawable.groupe_sos,R.drawable.indispo,R.drawable.indispo,R.drawable.association_aurore,R.drawable.casvp,R.drawable.coallia,R.drawable.indispo};
        String[] name = {"CHRS Flandre","Accueil de jour femmes","Le Fleuron", "GROUPE SOS Solidarités - CHRS Buzenval","Centre Municipal d'Aide Sociale","Foyer d'Hébergement du Centre Scientifique de l'Académie Polonaise des Sciences","Association Aurore","Permanence sociale d'accueil Gauthey (CASVP)","Coallia Hébergement","SOS Habitat et Soins"};
        String[] info = {"En savoir plus","En savoir plus","En savoir plus","En savoir plus","En savoir plus","En savoir plus","En savoir plus","En savoir plus","En savoir plus","En savoir plus"};
        String[] adresse = {"4 Pass. de Flandre, 75019 Paris","3 rue de Lesdiguières 75004 paris","Port Javel bas, 75015 Paris","94 Rue de Buzenval, 75020 Paris","15 Rue Baudricourt, 75013 Paris","15 Rue Lamandé, 75017 Paris","77 Rue du Château des Rentiers, 75013 Paris","5 Bd Diderot, 75012 Paris","122 Rue Falguière, 75015 Paris","11 Rue du Delta, 75009 Paris"};
        String[] horaire = {"24h/24 sauf le samedi et dimanche","10h-19h tout les jours","Pas d'infos","Pas d'infos","Pas d'infos","09h-18h tout les jours sauf le samedi","Pas d'infos","08-17h tout les jours sauf le samedi et dimanche","Pas d'infos","Pas d'infos"};
        String[] num = {"01 42 09 56 03","01 45 58 35 35","Pas d'infos"," 01 53 27 36 70","01 45 83 32 60","01 53 06 69 00"," 01 45 83 52 72","01 44 67 16 07","01 45 67 15 17","01 40 16 45 02"};

        ArrayList<InfoCentre> centreArrayList = new ArrayList<>();

        for(int i = 0; i < imageId.length;i++){

            InfoCentre infoCentre = new InfoCentre(name[i],info[i],adresse[i],horaire[i],num[i],imageId[i]);
            centreArrayList.add(infoCentre);
        }

        ListAdaptater listAdaptater = new ListAdaptater(CentreActivity.this,centreArrayList);
        binding.listview.setAdapter(listAdaptater);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(CentreActivity.this,Info.class);
                i.putExtra("name",name[position]);
                i.putExtra("adresse",adresse[position]);
                i.putExtra("horaire",horaire[position]);
                i.putExtra("tel",num[position]);
                i.putExtra("img",imageId[position]);
                startActivity(i);

            }
        });
    }
}
