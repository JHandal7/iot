package com.example.iot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListaLV1 extends ArrayAdapter<widget2> {
    public ListaLV1(@NonNull Context context, ArrayList<widget2> dataModalArrayList){
        super(context,0,dataModalArrayList);
    }

    @SuppressLint("IntentReset")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView=convertView;
        if (listitemView==null){
            listitemView= LayoutInflater.from(getContext()).inflate(R.layout.lista_main1,parent,false);
        }
        widget2 dataModal=getItem(position);
        TextView tv1=listitemView.findViewById(R.id.tv1);
        TextView tv2=listitemView.findViewById(R.id.tv2);
        TextView tv3=listitemView.findViewById(R.id.tv3);
        TextView tv4=listitemView.findViewById(R.id.tv4);
        SeekBar sw=listitemView.findViewById(R.id.seekBar);
        tv1.setText(dataModal.getEstancia());
        tv2.setText(dataModal.getNombre());
        tv3.setText(dataModal.getVariable());
        tv4.setText("0");
        sw.setProgress(0);
        sw.setMax(Integer.parseInt(dataModal.getMax()));
        sw.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv4.setText("");
                tv4.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return listitemView;

    }

}

