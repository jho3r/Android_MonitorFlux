 #include <SoftwareSerial.h>
 SoftwareSerial mySerial(10,11);
 char numero_cell[]="3142812968";
 String numero = "3142812968";
 String valor;

 int trama=0;
 char incoming_char;
 String p="";
 char num;
 String clave = "";

void setup() {
  pinMode(6, INPUT);
  pinMode(5, INPUT);
  pinMode(4, INPUT);
  pinMode(9, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(7, OUTPUT);
  Serial.begin(9600);
  mySerial.begin(9600);
  Serial.println("Iniciando");

  //Para realizar una llamada...
  //**********************************************************************************************************
  //mySerial.println("ATD+573142812968;"); //Para realizar una llamada no olvidar el ;
  //mySerial.println("ATH"); //Para colgar llamada
  //********************************************************************************************************

 mySerial.println("AT+CMGF=1"); //Configuramos modo texto
 delay(1000);
 //mySerial.println("AT+CMGR=?"); //Código para recibir mensajes
 mySerial.println("AT+CNMI=1,2,0,0,0"); //Código para ver mensajes en hyperterminal
  
  //Código para enviar mensajes...
  //*******************************************************************************************************
  mySerial.write("AT+CMGF=1\r\n");
  delay(1000);
  mySerial.print("AT+CMGS=\""+numero+"\"\r\n"); //Esta linea SI funciona
  //mySerial.write("AT+CMGS=\"+57" + numero + "\"\r\n");
  delay(1000);
  mySerial.print("Luis");
  delay(1000);
  mySerial.write((char)26);
  delay(1000);
  //*******************************************************************************************************
  }

void loop(){
//  if(mySerial.available())
//  {
//    valor = mySerial.readString(); 
//    Serial.println(valor);
//  }

//**********************************************CÓDIGO PARA IDENTIFICAR EL NÚMERO*****************************
//if (mySerial.available()>0){
//    incoming_char=mySerial.read(); //Lectura de datos del puerto serial.
//    if((trama == 0) && (incoming_char == 'C')){
//      trama = 1;
//      p="";
//      clave="";
//    }
//    if((trama == 1) && (incoming_char == 'M')){
//      trama = 2;
//    }
//    if((trama == 2) && (incoming_char == 'T')){
//      trama = 3;
//    }
//    if((trama == 3) && (incoming_char == ':')){
//      trama = 4;
//    }
//    if((trama == 4) && (incoming_char == ' ')){
//      trama = 5;
//    }
//    if((trama == 5) && (incoming_char == '"')){
//      trama=6;
//      for(int i=0;i<10;i++){
//        num = mySerial.read(); //Captura del número remitente. ej: 3982832027
//        if (num == '"') break;
//        else 
//        p += num;
//      }
//      delay(1000);
//         Serial.print("Numero telefonico: ");
//      Serial.println(p);  // imprimo en el puerto serial el número telefónico.
//      Serial.println(p);
//    }
//}
   
//********************************************************************************************************

//
//  if(valor.indexOf("ON")>=0)
//  {
//    digitalWrite(9,HIGH);
//    digitalWrite(7,HIGH);
//    digitalWrite(8,LOW);
//    delay(1000);
//  }
//  if(valor.indexOf("OFF")>=0)
//  {
//    digitalWrite(9,LOW);
//    digitalWrite(7,LOW);
//    digitalWrite(8,HIGH);
//    delay(1000);
//  }

  
//  if(mySerial.available())
//    Serial.write(mySerial.read());
//    if(Serial.available())
//      mySerial.write(Serial.read());

//  if(digitalRead(6)==HIGH)
//  {
//      mySerial.write("AT+CMGF=1\r\n");
//      delay(1000);
//      mySerial.write("AT+CMGS=\"3142812968\"\r\n");
//      delay(1000);
//      mySerial.print("SIM800L ---");
//      delay(1000);
//      mySerial.write((char)26);
//      delay(1000);
//   }

}
