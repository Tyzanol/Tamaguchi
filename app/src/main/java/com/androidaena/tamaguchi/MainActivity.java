package com.androidaena.tamaguchi;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbHunger;
    private ProgressBar pbThirst;
    private ProgressBar pbEnergy;
    private ProgressBar pbBored;
    private ProgressBar pbHappy;
    private Creature creature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creature = new Creature("boris", this);
        pbHunger = (ProgressBar) findViewById(R.id.progressHungry);
        pbThirst = (ProgressBar) findViewById(R.id.progressThirsty);
        pbEnergy = (ProgressBar) findViewById(R.id.progressEnergy);
        pbBored = (ProgressBar) findViewById(R.id.progressBored);
        pbHappy = (ProgressBar) findViewById(R.id.progressHappy);
        TextView tvName = (TextView) findViewById(R.id.textName);
        TextView tvAge = (TextView) findViewById(R.id.textAge);
        
        final ImageButton buttonBed = findViewById(R.id.buttonBed);
        buttonBed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Creature.errorCode error;
                if((error = creature.sleep()) != Creature.errorCode.allGood){
                    toastError(creature.getName(), error);
                }
                setPgBars();
            }
        });

        final ImageButton buttonFeed = findViewById(R.id.buttonFeed);
        buttonFeed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Creature.errorCode error;
                if((error = creature.eat()) != Creature.errorCode.allGood){
                    toastError(creature.getName(), error);
                }
                setPgBars();
            }
        });

        final ImageButton buttonBottle = findViewById(R.id.buttonBottle);
        buttonBottle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Creature.errorCode error;
                if((error = creature.drink()) != Creature.errorCode.allGood){
                    toastError(creature.getName(), error);
                }
                setPgBars();
            }
        });

        final ImageButton buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Creature.errorCode error;
                if((error = creature.play()) != Creature.errorCode.allGood){
                    toastError(creature.getName(), error);
                }
                setPgBars();
            }
        });

        tvName.setText(creature.getName());
        tvAge.setText(String.valueOf(creature.getStats().getAge()));
        setPgBars();
    }

    private void setPgBars(){
        pbHunger.setProgress(creature.getStats().getHunger());
        pbThirst.setProgress(creature.getStats().getThirst());
        pbEnergy.setProgress(creature.getStats().getEnergy());
        pbBored.setProgress(creature.getStats().getBored());
        pbHappy.setProgress(creature.getStats().getHappy());
    }

    private void toastError(String name, Creature.errorCode error) {
        switch (error){
            case noEnergy:{
                Toast.makeText(this, name + " is too tired", Toast.LENGTH_SHORT).show();
                break;
            }
            case hungry:{
                Toast.makeText(this, name + " is too hungry", Toast.LENGTH_SHORT).show();
                break;
            }
            case thirsty:{
                Toast.makeText(this, name + " is too thristy", Toast.LENGTH_SHORT).show();
                break;
            }
            case notBored:{
                Toast.makeText(this, name + " is not bored", Toast.LENGTH_SHORT).show();
                break;
            }
            case notHungry:{
                Toast.makeText(this, name + " is not hungry", Toast.LENGTH_SHORT).show();
                break;
            }
            case notThirsty:{
                Toast.makeText(this, name + " is not thirsty", Toast.LENGTH_SHORT).show();
                break;
            }
            case notTired:{
                Toast.makeText(this, name + " is not tired", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
