/* Mini projet Java : PARKING INTELLIGNET 2020/2021 
EL HAOUCHI Otmane - EL ASRI AYOUB - AIT OMAR OUMAIMA */

#include<LiquidCrystal_I2C.h>
#include <Servo.h>
#include <Wire.h>

#define LIGHTSENSOR A8
#define POTENTIOMETER A9
#define PLACE1     A1
#define PLACE2     A2
#define PLACE3     A3
#define PLACE4     A4
#define PLACE5     A5
#define PLACE6     A6
#define LEFT      A10
#define RIGHT     A11
#define BARRIERE_LEFT      38
#define BARRIERE_RIGHT     39
#define buzzer     53

char inputs   [20];
char oldInputs[20];
int A;
int P1=0;
int P2=0;
int P3=0;
int P4=0;
int P5=0;
int P6=0;
int Left=0;
int Right=0;

int pos_in;
int pos_out;

Servo LeftMotor; 
Servo RightMotor;
LiquidCrystal_I2C lcd(0x27, 16, 2);

void setup() {
  pinMode(BARRIERE_LEFT , OUTPUT);
  pinMode(BARRIERE_RIGHT , OUTPUT);
  pinMode(buzzer , OUTPUT); 
  LeftMotor.attach(3);
  RightMotor.attach(2);
  Serial.begin(115200);
  lcd.init(); 
  lcd.backlight();
  lcd.setCursor(1, 0);     
  lcd.print("Welcome to our");
  lcd.setCursor(1, 1);      
  lcd.print("Smart  Parking");
}

void getInputs(int Left,int Right,int P6,int P5,int P4,int P3,int P2,int P1){   
    int maper = map(analogRead(A9),0,1024,0,100);
    sprintf(inputs, "SS:%d%d%d%d%d%d%d%d:%02d",
        P1,P2,P3,P4,P5,P6,Left,Right,maper);
}

int place(int K)
{
  int pot = analogRead(A9);
  int sensor = analogRead(K);
  int maper = map(pot,0,1024,0,100);
  if(sensor<pot)
        return 1;
  else  
        return 0;
}

void loop() {
  int NmbrePlaces=0;
  
  P1 = place(PLACE1);
  if(P1==1)
    NmbrePlaces = NmbrePlaces + 1;
    
  P2 = place(PLACE2);
  if(P2==1)
    NmbrePlaces = NmbrePlaces + 1;  
    
  P3 = place(PLACE3);
  if(P3==1)
    NmbrePlaces = NmbrePlaces + 1; 
     
  P4 = place(PLACE4);
  if(P4==1)
    NmbrePlaces = NmbrePlaces + 1;  
    
  P5 = place(PLACE5);
  if(P5==1)
    NmbrePlaces = NmbrePlaces + 1;  
    
  P6 = place(PLACE6);
  if(P6==1)
    NmbrePlaces = NmbrePlaces + 1; 
    
  Left = place(LEFT);
  Right = place(RIGHT);
  if(Right==1 ||Left==1)
  {
  lcd.init();
  lcd.backlight();
  lcd.setCursor(0,0);
  lcd.print("Vacante:");
  lcd.setCursor(10,0);
  lcd.print("Occupée:");
  lcd.setCursor(0,1);
  lcd.print(6-NmbrePlaces);  
   lcd.setCursor(10,1);
  lcd.print(NmbrePlaces);  
  }
  getInputs(P1,P2,P3,P4,P5,P6,Left,Right);
  
  if( strcmp(inputs, oldInputs) != 0){
        strcpy(oldInputs, inputs);
        Serial.println(inputs);
  }
  delay(10);

  if(Left==1&& NmbrePlaces <6)
  {    tone(53,440);
    delay(500);
    noTone(53);
    delay(500);
    tone(53,440);
    delay(500);
    noTone(53);
    delay(500);
  for(pos_in = 90; pos_in > 0; pos_in--)
    {
      LeftMotor.write(pos_in);
      delay(15);
    }
    delay(1000);  
  for(pos_in = 0; pos_in <= 90; pos_in++)
    {
      LeftMotor.write(pos_in);
      delay(15);
    }
  }

  if(Right==1)
  {

  for(pos_in = 90; pos_in >= 0; pos_in--)
    {
      RightMotor.write(pos_in);
      delay(15);
    }
    delay(1000);  
  for(pos_in = 0; pos_in <= 90; pos_in++)
    {
      RightMotor.write(pos_in);
      delay(15);
    }
  }  
  lcd.init(); 
  lcd.backlight();
  lcd.setCursor(1, 0);     
  lcd.print("Welcome to our");
  lcd.setCursor(1, 1);      
  lcd.print("Smart  Parking"); 
}
