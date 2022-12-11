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

public class MainActivity4 extends AppCompatActivity {
    Bundle datos;
    String datosobt,nom,usu,var,ti,off,on,key,key12;
    DatabaseReference root;
    ListView listView1,listView;
    ArrayList<dispositivos> listasArrayList;
    Button bt10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        root= FirebaseDatabase.getInstance().getReference();
        listView1=findViewById(R.id.dis);
        listasArrayList = new ArrayList<>();
        datos=getIntent().getExtras();
        datosobt=datos.getString("ID");
        bt10=findViewById(R.id.bt10);
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity4.this,MainActivity3.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();
            }
        });
        dispos();
    }

    private void dispos() {
        root.child("dispositivos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("dispositivos").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            dispositivos id=snapshot.getValue(dispositivos.class);
                            nom=id.getNombre();
                            usu=id.getId_usuario();
                            if(datosobt.equals(usu)){
                                listasArrayList.add(id);
                                ListaLV2 adapter1 = new ListaLV2(MainActivity4.this, listasArrayList);
                                listView1.setAdapter(adapter1);
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