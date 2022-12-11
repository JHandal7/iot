package com.example.iot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class ListaLV extends ArrayAdapter<widget1> {
    public ListaLV(@NonNull Context context, ArrayList<widget1> dataModalArrayList){
        super(context,0,dataModalArrayList);
    }
    DatabaseReference root;

    String a,b,c,d,e,f,g,h,k,m,n;
    int i=0,j=0,k1=0;

    @SuppressLint("IntentReset")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView=convertView;
        if (listitemView==null){
            listitemView= LayoutInflater.from(getContext()).inflate(R.layout.lista_main,parent,false);
        }
        widget1 dataModal=getItem(position);
        TextView tv1=listitemView.findViewById(R.id.tv1);
        TextView tv2=listitemView.findViewById(R.id.tv2);
        TextView tv3=listitemView.findViewById(R.id.tv3);
        Switch sw=listitemView.findViewById(R.id.switch1);
        root= FirebaseDatabase.getInstance().getReference();
        tv1.setText(dataModal.getEstancia());
        tv2.setText(dataModal.getNombre());
        //tv3.setText(dataModal.getMsj_off());
        sw.setText(dataModal.getVariable());
        Log.e("vari", "getView: "+dataModal.getVariable() );

        valor(dataModal.getVariable(),sw,tv3,dataModal.getMsj_off(),dataModal.getMsj_on());

        sw.setOnClickListener(v -> {
            tv3.setText("");
            if(sw.isChecked()){
                tv3.setText(dataModal.getMsj_on());
                registro(dataModal.getVariable(),1,sw,tv3,dataModal.getMsj_off(),dataModal.getMsj_on());


            }
            else{
                tv3.setText(dataModal.getMsj_off());
                registro(dataModal.getVariable(),0,sw, tv3, dataModal.getMsj_off(), dataModal.getMsj_on());
            }


        });


        return listitemView;

    }

    private void valor(String variable, Switch sw, TextView tv3, String msj_off, String msj_on) {
        Log.e("vboe", "valor: "+variable );
        root.child("variables").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("variables").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            variables id3=snapshot.getValue(variables.class);
                            g= id3.getNombre();
                            if(variable.equals(g)){


                                root.child("cambio").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                        for (DataSnapshot snapshot2:snapshot.getChildren()){
                                            root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                                    h= snapshot1.getKey();
                                                    Log.e("variable", "onDataChange: "+variable+" "+h );
                                                    cambio id4=snapshot.getValue(cambio.class);
                                                    k=id4.getId_variable();
                                                    Log.e("swe123", "onDataChange: "+h+" "+id4.getId_variable()+" "+id4.getVal() );
                                                    if(h.equals(k)){

                                                        m=String.valueOf(id4.getVal());
                                                        if(m.equals("1")){

                                                            sw.setChecked(true);
                                                            tv3.setText(msj_on);
                                                        }
                                                        else{
                                                            Log.e("swe", "onDataChange: "+id4.getId_variable()+" "+id4.getVal() );
                                                            sw.setChecked(false);
                                                            tv3.setText(msj_off);
                                                        }
                                                    }

                                                }

                                                @Override
                                                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                                }
                                            });
                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }


    private void registro(String variable, int msj, Switch sw, TextView tv3, String msj_off, String msj_on) {
        i=0;

        valor(variable, sw,tv3,msj_off,msj_on);
        root.child("variables").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("variables").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            variables id1 = snapshot1.getValue(variables.class);
                            a= id1.getNombre();

                            if(variable.equals(a)){
                                b=snapshot1.getKey();
                                root.child("cambio").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                        for (DataSnapshot snapshot2:snapshot.getChildren()){
                                            root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                                    cambio id2=snapshot.getValue(cambio.class);
                                                    g=id2.getId_variable();
                                                    h= id2.getId_widgets();

                                                    if(g.equals(b)){
                                                        if(i<1) {
                                                            root.child("cambio").child(snapshot2.getKey()).child("val").setValue(msj);
                                                            root.child("cambio").child(snapshot2.getKey()).child("titulo").setValue("no vio notificacion");


                                                            //valor(variable, sw, tv3, msj_off,msj_on);
                                                            i++;
                                                        }

                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                    }
                                });
                                c=id1.getDispositivo();
                                d=id1.getId_variable();
                                //wid(b,msj);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    private void wid(String d,int msj) {
        i=0;
        root.child("widgets").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("widgets").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            widget id1 = snapshot.getValue(widget.class);
                            c=id1.getId_variable();
                            if(d.equals(id1.getId_variable())){
                                Log.e("wid", "onDataChange: "+d );
                                Map<String,Object> cambio=new HashMap<>();
                                root.child("cambio").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot3) {
                                        Log.e("entro1", ""+snapshot3.getValue() );
                                        for (DataSnapshot snapshot2:snapshot3.getChildren()){
                                            Log.e("winum", "onDataChange: "+snapshot2.getKey() );
                                            root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                                    cambio id2 = snapshot.getValue(cambio.class);
                                                    e= id2.getId_widgets();

                                                    Log.e("entroer", ""+snapshot.getValue() );
                                                    if(d.equals(c)){
                                                        if(i<1){

                                                            root.child("cambio").child(snapshot2.getKey()).setValue(msj);
                                                            i++;
                                                        }
                                                    }
                                                }
                                                @Override
                                                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                    }
                                });



                            }

                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

}

