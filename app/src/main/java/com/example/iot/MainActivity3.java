package com.example.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    Bundle datos;
    String datosobt,key1,es,nom,var,ti,off,on,key,key12;
    DatabaseReference root;
    Button btn1,btn2,btn3,btn4,bt10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        root= FirebaseDatabase.getInstance().getReference();
        datos=getIntent().getExtras();
        datosobt=datos.getString("ID");
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity3.this,MainActivity4.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();
            }
        });
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent pasar=new Intent(MainActivity3.this,MainActivity5.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();*/
            }
        });
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity3.this,MainActivity5.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();
            }
        });
        btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity3.this,MainActivity6.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();
            }
        });
        bt10=findViewById(R.id.bt10);
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity3.this,MainActivity2.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();
            }
        });



    }
}