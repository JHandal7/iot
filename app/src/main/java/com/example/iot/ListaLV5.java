package com.example.iot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaLV5 extends ArrayAdapter<datos> {
    public ListaLV5(@NonNull Context context, ArrayList<datos> dataModalArrayList){
        super(context,0,dataModalArrayList);
    }
    @SuppressLint("IntentReset")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView=convertView;
        if (listitemView==null){
            listitemView= LayoutInflater.from(getContext()).inflate(R.layout.estado,parent,false);
        }
        datos dataModal=getItem(position);
        TextView tv1=listitemView.findViewById(R.id.titulo);
        TextView tv2=listitemView.findViewById(R.id.mensaje);


        tv1.setText("ID widget: "+dataModal.getId_widgets());

        tv2.setText("Mensaje: "+dataModal.getMensaje());

        return listitemView;

    }


}

