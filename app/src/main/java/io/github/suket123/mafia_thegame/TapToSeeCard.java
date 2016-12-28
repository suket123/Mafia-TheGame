package io.github.suket123.mafia_thegame;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;
import java.util.Random;

public class TapToSeeCard extends AppCompatActivity {

    public final static String MESSAGE_KEY = "myMessageKey";
    public static int dataReceived;
    public static int number = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_to_see_card);

        if (number == -1) {
            Intent intent = getIntent();
            String message = intent.getStringExtra(MESSAGE_KEY);
            dataReceived = Integer.parseInt(message);
            number = dataReceived;
        }
    }

    public void myClick(View view){

        if (number == -1){
            number = dataReceived;
        }

        //int randomNum =  ((int)(Math.random()) % 3);
        Random rand = new Random();
        int randomNum = (rand.nextInt(4) * number * 17)%4;

        if (number == 0){
            number = -1;
            Intent newActivity = new Intent(this,MainActivity.class);
            startActivity(newActivity);
        }else if (randomNum == 0){

            if (number % 10 == 0){ // police mafia or citizen
                if ((number / 10)%10 == 0){ // show mafia or citizen
                    if((number/100)%10 == 0) { // show citizen
                        number = number - 1000;
                        Intent newActivity = new Intent(this,Doctor.class);
                        startActivity(newActivity);
                    }else{ // show mafia
                        number = number - 100;
                        Intent newActivity = new Intent(this,Mafia.class);
                        startActivity(newActivity);
                    }
                } else { // show police
                    number = number - 10;
                    Intent newActivity = new Intent(this,Police.class);
                    startActivity(newActivity);
                }
            }else{
                number = number - 1;
                Intent newActivity = new Intent(this,Citizen.class);
                startActivity(newActivity);
            }
        }else if (randomNum == 1){
            if (((number / 10)%10) == 0){
                if ((number % 10) == 0){ // show mafia or citizen
                    if ((number/100)%10 == 0){ // show citizen
                        number = number - 1000;
                        Intent newActivity = new Intent(this,Doctor.class);
                        startActivity(newActivity);
                    }else{// show mafia
                        number = number - 100;
                        Intent newActivity = new Intent(this,Mafia.class);
                        startActivity(newActivity);
                    }
                }else{ // show doctor
                    number = number - 1;
                    Intent newActivity = new Intent(this,Citizen.class);
                    startActivity(newActivity);
                }
            }else{ // show police
                number = number - 10;
                Intent newActivity = new Intent(this,Police.class);
                startActivity(newActivity);
            }
        }else if (randomNum == 2){
            if (((number / 100) % 10) == 0){
                if (number % 10 == 0){ // show police or citizen
                    if ((number/10)%10 == 0){ // citizen
                        number = number - 1000;
                        Intent newActivity = new Intent(this,Doctor.class);
                        startActivity(newActivity);
                    }else{ // police
                        number = number - 10;
                        Intent newActivity = new Intent(this,Police.class);
                        startActivity(newActivity);
                    }
                }else{ // show doctor
                    number = number - 1;
                    Intent newActivity = new Intent(this,Citizen.class);
                    startActivity(newActivity);
                }
            }else {// show mafia
                number = number - 100;
                Intent newActivity = new Intent(this,Mafia.class);
                startActivity(newActivity);
            }
        }else if (randomNum == 3){
            if (number/1000 == 0){
                if (number % 10 == 0){
                    if ((number/10)%10 == 0){
                        number = number - 100;
                        Intent newActivity = new Intent(this,Mafia.class);
                        startActivity(newActivity);
                    }else{
                        number = number - 10;
                        Intent newActivity = new Intent(this,Police.class);
                        startActivity(newActivity);
                    }
                }else{
                    number = number - 1;
                    Intent newActivity = new Intent(this,Citizen.class);
                    startActivity(newActivity);
                }
            }else{
                number = number - 1000;
                Intent newActivity = new Intent(this,Doctor.class);
                startActivity(newActivity);
            }
        }

    }
}
