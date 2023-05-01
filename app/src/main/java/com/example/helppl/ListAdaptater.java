package com.example.helppl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdaptater extends ArrayAdapter<InfoCentre> {

    public ListAdaptater(Context context, ArrayList<InfoCentre> infoCentreArrayList){
        super(context,R.layout.list_item,infoCentreArrayList);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        InfoCentre centre = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView =  convertView.findViewById(R.id.imgCentre);
        TextView nom = convertView.findViewById(R.id.centreName);
        TextView info = convertView.findViewById(R.id.info);


        imageView.setImageResource(centre.imageId);
        nom.setText(centre.nom);
        info.setText(centre.info);

        return convertView;
    }
}
