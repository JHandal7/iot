package com.example.iot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListaLV4 extends ArrayAdapter<variable> {
    public ListaLV4(@NonNull Context context, ArrayList<variable> dataModalArrayList){
        super(context,0,dataModalArrayList);
    }

    @SuppressLint("IntentReset")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView=convertView;
        if (listitemView==null){
            listitemView= LayoutInflater.from(getContext()).inflate(R.layout.lista_main4,parent,false);
        }
        variable dataModal=getItem(position);
        TextView tv1=listitemView.findViewById(R.id.tv1);
        TextView tv2=listitemView.findViewById(R.id.tv2);
        TextView tv3=listitemView.findViewById(R.id.tv3);
        TextView tv4=listitemView.findViewById(R.id.tv4);

        tv1.setText("ID usuario: "+dataModal.getId_usuario());
        tv2.setText("Nombre: "+dataModal.getNombre());
        tv3.setText("Dispositivo: "+dataModal.getDispositivo());
        tv4.setText("Unidad de medida: "+dataModal.getUnidad_med());


        return listitemView;

    }

}

