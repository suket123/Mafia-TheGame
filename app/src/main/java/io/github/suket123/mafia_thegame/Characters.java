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
import android.widget.Toast;

public class Characters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    EditText numOfMafia;
    EditText numOfPolice;
    EditText numOfDoc;
    EditText numOfCitizen;

    public final static String MESSAGE_KEY = "myMessageKey"; // name of the key

    public void charactersPageClick(View view){

        numOfMafia = (EditText)findViewById(R.id.numOfMafia);
        numOfPolice = (EditText)findViewById(R.id.numOfPolice);
        numOfDoc = (EditText)findViewById(R.id.numOfDoc);
        numOfCitizen = (EditText)findViewById(R.id.numOfCitizen);

        String mafiaText = numOfMafia.getText().toString();
        String policeText = numOfMafia.getText().toString();
        String doctorText = numOfMafia.getText().toString();
        String citizenText = numOfMafia.getText().toString();
        if ((mafiaText.matches("")) || (policeText.matches("")) || (doctorText.matches("")) || (citizenText.matches(""))) {
            Toast.makeText(this, "You did not enter all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        float numberOfCitizen = Float.parseFloat(numOfCitizen.getText().toString());
        float numberOfMafia = Float.parseFloat(numOfMafia.getText().toString());
        float numberOfDoctor = Float.parseFloat(numOfDoc.getText().toString());
        float numberOfPolice = Float.parseFloat(numOfPolice.getText().toString());

        if (!(numberOfMafia > 0) && !(numberOfCitizen>0) && !(numberOfDoctor>0) && !(numberOfPolice>0)){
            Intent newActivity = new Intent(this,Characters.class);
            startActivity(newActivity);
        }

        int total = (int)(numberOfCitizen* 1+numberOfMafia*100 + numberOfPolice*10 + numberOfDoctor*1000);

        String sendData = Integer.toString(total);

        Intent newActivity = new Intent(this,TapToSeeCard.class);
        newActivity.putExtra(MESSAGE_KEY,sendData);
        startActivity(newActivity);
    }
}
