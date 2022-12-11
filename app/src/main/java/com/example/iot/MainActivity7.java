package com.example.iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity7 extends AppCompatActivity {
    Bundle datos;
    String datosobt,key1,es,nom,var,ti,off,on,key,key12;
    DatabaseReference root;
    ListView listView1,listView;
    ArrayList<datos> listasArrayList;
    ArrayList<widget2> listasArrayList1;
    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        root= FirebaseDatabase.getInstance().getReference();
        listView1=findViewById(R.id.li3);
        listasArrayList = new ArrayList<>();

        listView=findViewById(R.id.li2);
        listasArrayList1 = new ArrayList<>();
        datos=getIntent().getExtras();
        datosobt=datos.getString("ID");
        key1=datos.getString("msj");
        Log.e("keysd", ""+ key1);
        bt1=findViewById(R.id.bt10);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity7.this,MainActivity2.class);
                pasar.putExtra("ID",datosobt);
                startActivity(pasar);
                finish();
            }
        });
        listas();


    }

    private void listas() {
        root.child("widgets").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("widgets").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            widget3 id=snapshot.getValue(widget3.class);

                            if(id.getId_usuario().equals(datosobt)){
                                Log.e("entro", "entro: " );
                                root.child("cambio").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                        for (DataSnapshot snapshot2:snapshot.getChildren()){
                                            root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                                    cambio1 id1=snapshot.getValue(cambio1.class);

                                                    if(snapshot1.getKey().equals(id1.getId_widgets())){
                                                        datos id3=snapshot2.getValue(datos.class);

                                                        listasArrayList.add(id3);
                                                        ListaLV5 datos = new ListaLV5(MainActivity7.this, listasArrayList);
                                                        listView1.setAdapter(datos);

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