package com.example.iot;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity2 extends AppCompatActivity {
    Bundle datos;
    String datosobt,key1,es,nom,var,ti,off,on,key,key12;
    DatabaseReference root;
    ListView listView1,listView;
    ArrayList<widget1> listasArrayList;
    ArrayList<widget2> listasArrayList1;
    Button bt1,bt2;
    NotificationBadge notificationBadge;
    int valor=0;
    private static final String  CHANNEL_ID="simplified_coding";
    private static final String  CHANNEL_NAME="simplified Coding";
    private static final String  CHANNEL_DESC="simplified Coding Notifications";
    @RequiresApi(api = Build.VERSION_CODES.R)

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        root= FirebaseDatabase.getInstance().getReference();
        listView1=findViewById(R.id.li1);
        listasArrayList = new ArrayList<>();

        listView=findViewById(R.id.li2);
        listasArrayList1 = new ArrayList<>();
        datos=getIntent().getExtras();
        datosobt=datos.getString("ID");
        Log.e("datos", "onCreate: "+datosobt );
        bt1=findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(pasar);
                finish();
            }
        });
        bt2=findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar=new Intent(MainActivity2.this,MainActivity3.class);
                key12=datosobt;
                pasar.putExtra("ID",key12);
                startActivity(pasar);
                finish();
            }
        });
        notificationBadge=findViewById(R.id.badge);
        widgets();
        noti();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }



    }

    private void noti() {
        root.child("widgets").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("widgets").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                            widget id=snapshot.getValue(widget.class);
                            nom=id.getId_usuario();
                            if(datosobt.equals(nom)){
                                root.child("cambio").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                                        for (DataSnapshot snapshot2:snapshot.getChildren()){
                                            root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                                                    cambio1 id1=snapshot.getValue(cambio1.class);
                                                    es=id1.getId_widgets();
                                                    if(es.equals(snapshot1.getKey())){
                                                        root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                                                                cambio1 id2=snapshot.getValue(cambio1.class);

                                                                notificationBadge.setNumber(id2.notificacion);
                                                                Log.e("valores", ""+ id2.getMensaje());

                                                                if(id2.getNotificacion()!=0){
                                                                    displayNotifiactions(id2.getTitulo(),id2.getMensaje(),datosobt);
                                                                }


                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                                    }
                                });
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                        }
                    });
                }


            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
    }


    private void widgets() {
        Log.e("si", "widgets: "+datosobt );
        root.child("widgets").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("widgets").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            widget id1 = snapshot1.getValue(widget.class);
                            key1=id1.getId_usuario();
                            ti=id1.getTipo();
                            Log.e("interruptor", "onDataChange: "+ti);
                            Log.e("inte", "onDataChange: "+datosobt);
                            if(key1!=(null)){
                                if(datosobt.equals(key1)&&ti.equals("Interruptor")){
                                    Log.e("inte", "onDataChange: "+ti);
                                    key=snapshot1.getKey();
                                    widget1 dataModal=snapshot1.getValue(widget1.class);
                                    listasArrayList.add(dataModal);
                                    ListaLV adapter1 = new ListaLV(MainActivity2.this, listasArrayList);
                                    listView1.setAdapter(adapter1);
                                }
                                if(datosobt.equals(key1)&&ti.equals("Deslizador")){
                                    key=snapshot1.getKey();
                                    widget2 dataModal1=snapshot1.getValue(widget2.class);
                                    listasArrayList1.add(dataModal1);
                                    ListaLV1 adapter1 = new ListaLV1(MainActivity2.this, listasArrayList1);
                                    listView.setAdapter(adapter1);

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

    public void ClickLista(View view) {
        notificationBadge.clear();
        notificationBadge.getTextView().toString();
        root.child("widgets").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    root.child("widgets").child(snapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                            widget id=snapshot.getValue(widget.class);
                            nom=id.getId_usuario();
                            if(datosobt.equals(nom)){
                                root.child("cambio").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                                        for (DataSnapshot snapshot2:snapshot.getChildren()){
                                            root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                                                    cambio1 id1=snapshot.getValue(cambio1.class);
                                                    es=id1.getId_widgets();
                                                    if(es.equals(snapshot1.getKey())){
                                                        root.child("cambio").child(snapshot2.getKey()).addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                                                                cambio1 id2=snapshot.getValue(cambio1.class);
                                                                Log.e("notifi", ""+ id2.getNotificacion());
                                                                root.child("cambio").child(snapshot2.getKey()).child("notificacion").setValue(0);
                                                                root.child("cambio").child(snapshot2.getKey()).child("titulo").setValue("vio notificacion");
                                                                Intent pasar=new Intent(MainActivity2.this,MainActivity7.class);
                                                                pasar.putExtra("ID",datosobt);

                                                                startActivity(pasar);
                                                                finish();



                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                                    }
                                });
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                        }
                    });
                }


            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });



    }
    public void displayNotifiactions(String titulo,String mensaje,String key){
        Log.e("mans", ""+mensaje );
        NotificationCompat.Builder mBuider=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.noti)
                .setContentTitle(titulo)
                .setContentText("Informe de los dispositivos")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Intent intent=new Intent(MainActivity2.this,MainActivity2.class);
        intent.putExtra("ID",key);
        PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity2.this,0,intent,PendingIntent.FLAG_IMMUTABLE);
        mBuider.setContentIntent(pendingIntent);
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,mBuider.build());

    }
}