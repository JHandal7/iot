//............................................................................
//..Es obligatorio seguir el orden indicado en la inclusion de las librerias..
//............................................................................
//............................   ESP 8266   ..................................
#include "FirebaseESP8266.h"
#include <ESP8266WiFi.h>
//............................    ESP 32    ..................................
//#include <WiFi.h>
//#include <FirebaseESP32.h>

#define WIFI_SSID "Flia Choque"
#define WIFI_PASSWORD "Mcp..2oo0ammv"


// Credenciales Proyecto Firebase
#define FIREBASE_HOST "iotproyect-2fe4c-default-rtdb.firebaseio.com" //Sin http:// o https:// 
#define FIREBASE_AUTH "Jqazkcyr0kyAixPXDrLYsLdCJXUoa2PsnJTL5lOZ"
#define LED 4
#define LED1 5
String path = "/cantidad";
String path1="";
//Define un objeto de Firebase
FirebaseData firebaseData;
int cantidad=0;
int stado=0;
int stado1=0;
void printResult(FirebaseData &data);
void CausaError(void);
void InforSetLuzSensor(void);
void InforGetLuzSensor(void);

void setup()
{
  Serial.begin(115200);
  delay(500);
  pinMode(LED,OUTPUT);
  pinMode(LED1,OUTPUT);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Conectando a ....");
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Conectado con la IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);

  //Establezca el tiempo de espera de lectura de la base de datos en 1 minuto (máximo 15 minutos)
  //Firebase.setReadTimeout(firebaseData, 1000);
  
  //Tamaño y  tiempo de espera de escritura, tiny (1s), small (10s), medium (30s) and large (60s).
  //tiny, small, medium, large and unlimited.
  //Firebase.setwriteSizeLimit(firebaseData, "tiny");
  
  
  
 
}

void loop()
{
  Serial.println("------------------------------------");
  Serial.println("  LEER  EL  ESTADO  DE  LAS  LUCES  ");
  if (Firebase.getInt(firebaseData, path )){
    InforGetLuzSensor(); 
    cantidad=firebaseData.intData();
    if(cantidad!=0){
      for(int i=1;i<=cantidad;i++){
          path1="/cambio/wi"+String(i);
          if(path1.equals("/cambio/wi1")){
                if (Firebase.getInt(firebaseData, path1+"/val" )){
                    InforGetLuzSensor(); 
                    stado=firebaseData.intData();
                    if(stado==1){
                      digitalWrite(LED,HIGH);
                      if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 1 Prendido")){InforSetLuzSensor();}
                      if(Firebase.setInt(firebaseData,path1+"/notificacion",1)){InforSetLuzSensor();}
                      if(Firebase.setString(firebaseData,path1+"/titulo","Notificacion")){InforSetLuzSensor();}
                      }
                    else{
                      digitalWrite(LED,LOW);
                      if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 1 Apagado")){InforSetLuzSensor();}
                      if(Firebase.setInt(firebaseData,path1+"/notificacion",0)){InforSetLuzSensor();}
                      if(Firebase.setString(firebaseData,path1+"/titulo","Notificacion")){InforSetLuzSensor();}
                    }
                }
              }
              if(path1.equals("/cambio/wi3")){
                if (Firebase.getInt(firebaseData, path1+"/val" )){
                    InforGetLuzSensor(); 
                    stado1=firebaseData.intData();
                    if(Firebase.getString(firebaseData,path1+"/titulo")){
                        String estado="";
                        InforSetLuzSensor();
                        estado=firebaseData.stringData();
                        if(stado1==1 && estado.equals("no vio notificacion")){
                           //digitalWrite(LED1,HIGH);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Prendido")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",1)){InforSetLuzSensor();}
                        }
                        if(stado1==1 && estado.equals("vio notificacion")){
                           //digitalWrite(LED1,HIGH);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Prendido")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",0)){InforSetLuzSensor();}
                           
                        }
                        if(stado1==0 && estado.equals("no vio notificacion")){
                           //digitalWrite(LED1,LOW);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Apagado")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",1)){InforSetLuzSensor();}
                        }
                        if(stado1==0 && estado.equals("vio notificacion")){
                           //digitalWrite(LED1,LOW);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Apagado")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",0)){InforSetLuzSensor();}
                        }
                        
                       }
                    }
               }


               if(path1.equals("/cambio/wi6")){
                if (Firebase.getInt(firebaseData, path1+"/val" )){
                    InforGetLuzSensor(); 
                    stado1=firebaseData.intData();
                    if(Firebase.getString(firebaseData,path1+"/titulo")){
                        String estado="";
                        InforSetLuzSensor();
                        estado=firebaseData.stringData();
                        if(stado1==1 && estado.equals("no vio notificacion")){
                           digitalWrite(LED1,HIGH);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Prendido")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",1)){InforSetLuzSensor();}
                        }
                        if(stado1==1 && estado.equals("vio notificacion")){
                           digitalWrite(LED1,HIGH);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Prendido")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",0)){InforSetLuzSensor();}
                           
                        }
                        if(stado1==0 && estado.equals("no vio notificacion")){
                           digitalWrite(LED1,LOW);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Apagado")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",1)){InforSetLuzSensor();}
                        }
                        if(stado1==0 && estado.equals("vio notificacion")){
                           digitalWrite(LED1,LOW);
                           if(Firebase.setString(firebaseData,path1+"/mensaje","Dispositivo 2 Apagado")){InforSetLuzSensor();}
                           if(Firebase.setInt(firebaseData,path1+"/notificacion",0)){InforSetLuzSensor();}
                        }
                        
                       }
                    }
               }
                    
          }
     }
  }
  else{CausaError(); }
  delay(1000);
}

void InforGetLuzSensor(void)
{
  Serial.println("Aprobado");
  Serial.println("Ruta: " + firebaseData.dataPath());
  Serial.println("Tipo: " + firebaseData.dataType());
  Serial.println("ETag: " + firebaseData.ETag());
  Serial.print("Valor: ");
  printResult(firebaseData);
  Serial.println("------------------------------------");
  Serial.println(); 
}
void InforSetLuzSensor(void)
{
  Serial.println("Aprobado");
  Serial.println("Ruta: " + firebaseData.dataPath());
  Serial.println("Tipo: " + firebaseData.dataType());
  Serial.println("ETag: " + firebaseData.ETag());
  Serial.print("Valor: ");
  printResult(firebaseData);
  Serial.println("------------------------------------");
  Serial.println(); 
}


void CausaError(void)
{
  Serial.println("ERROR");
  Serial.println("RAZON: " + firebaseData.errorReason());
  Serial.println("------------------------------------");
  Serial.println();
}

void printResult(FirebaseData &data)
{
    if (data.dataType() == "int")
        Serial.println(data.intData());
    else if (data.dataType() == "float")
        Serial.println(data.floatData(), 5);
    else if (data.dataType() == "double")
        printf("%.9lf\n", data.doubleData());
    else if (data.dataType() == "boolean")
        Serial.println(data.boolData() == 1 ? "true" : "false");
    else if (data.dataType() == "string")
        Serial.println(data.stringData());
    
    
}
