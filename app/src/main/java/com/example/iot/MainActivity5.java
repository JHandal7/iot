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

public class MainActivity5 extends AppCompatActivity {
    Bundle datos;
    String datosobt,nom,usu,var,ti,off,on,key,key12;
    DatabaseReference root;
    ListView listView1,listView;
    ArrayList<estancias> listasArrayList;
    Button bt10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        root= FirebaseDatabase.getInstance().getReference();
        listView1=findViewById(R.id.estan);
        listasArrayList = new ArrayList<>();
        datos=getIntent().getExtras();
        datosobt=datos.getString("ID");
        bt10=findViewById(R.id.bt10);
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity5.this,MainActivity3.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();
            }
        });
        estan();
    }

    private void estan() {
        root.child("estancias").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("estancias").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            estancias id=snapshot.getValue(estancias.class);
                            nom=id.getNombre();
                            usu=id.getId_usuario();
                            if(datosobt.equals(usu)&&!nom.equals("...")){
                                Log.e("nombre", "onDataChange: "+nom);
                                listasArrayList.add(id);
                                ListaLV3 adapter1 = new ListaLV3(MainActivity5.this, listasArrayList);
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