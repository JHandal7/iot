package com.example.iot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button bt1;
    String usu,con1,usu1,con2,key;
    ProgressDialog progressDialog;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        bt1=findViewById(R.id.bt1);
        db= FirebaseDatabase.getInstance().getReference();
        //entro senor?si
        bt1.setOnClickListener(v -> {
            usu=et1.getText().toString().trim();
            con1=et2.getText().toString().trim();
            if (TextUtils.isEmpty(usu)) {
                et1.setError("Se requiere Usuario.");
                return;
            }

            if (TextUtils.isEmpty(con1)) {
                et2.setError("Se requiere Contraseña.");
                return;
            }
            ingreso(usu,con1);
            //progressDialog=new ProgressDialog(MainActivity.this);
            //progressDialog.show();
            //progressDialog.setContentView(R.layout.progress);
            //progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            Log.e("entro", "onDataChange:" + usu);
            //trate de ingresar a la aplicacion senor?? ingreso? disculpe esta ahi?si
            //senor desconecto su celular? puede volver a conectarlo? sigue igual





        });


    }

    private void ingreso(String usu, String con1) {
        Log.e("entro1", "onDataChange:" + usu);
        db.child("usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    db.child("usuarios").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            autentificacion usu2 = snapshot1.getValue(autentificacion.class);
                            usu1=usu2.getUsuario();
                            autentificacion con = snapshot1.getValue(autentificacion.class);
                            con2=con.getClave();
                            //sigue pasando lo mismo?senor?



                            if(usu1!=(null)&&con2!=(null)){
                                if(usu1.equals(usu)&&con2.equals(con1)){
                                    Intent pasar=new Intent(MainActivity.this,MainActivity2.class);
                                    key=snapshot1.getKey();
                                    pasar.putExtra("ID",key);
                                    startActivity(pasar);
                                    finish();
                                    //progressDialog.dismiss();

                                }
                                else{
                                    et1.setText("");
                                    et2.setText("");
                                    //progressDialog.dismiss();
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