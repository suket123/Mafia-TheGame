package io.github.suket123.mafia_thegame;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void firstPageClick(View view){
        Intent newActivity = new Intent(this,Characters.class);
        startActivity(newActivity);
    }

    public void instructions(View view){
        Intent newActivity = new Intent(this,Instructions.class);
        startActivity(newActivity);
    }
}
