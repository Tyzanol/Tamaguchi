package com.androidaena.tamaguchi;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by I336151 on 17/09/2018.
 */

public class Creature {
    private String name;
    private Stats stats;
    private ImageView image;
    private Context context;
    private int playGif;
    private int sleepGif;
    private int drinkGif;
    private int eatGif;
    private int lookGif;
    private GifImageView gifView;

    public Creature(String i_name, GifImageView i_gifView, Context i_context){
        name = i_name;
        stats = new Stats();
        gifView = i_gifView;
        context = i_context;

        sleepGif = R.drawable.sleep;
        playGif = R.drawable.play;
        drinkGif = R.drawable.drink;
        eatGif = R.drawable.eating;
        lookGif = R.drawable.look_around;

    }

    public enum errorCode{
        allGood,
        tired,
        notTired,
        hungry,
        notHungry,
        notBored,
        noEnergy,
        thirsty,
        notThirsty,
        unhappy
    }

    public String getName() {
        return name;
    }

    public Stats getStats(){
        return stats;
    }

    public errorCode sleep(){
        if(stats.getEnergy() < 10){
            stats.setEnergy(stats.getEnergy() + 1);
            if(stats.getHunger() > 0){
                stats.setHunger(stats.getHunger() - 1);
            }
            if(stats.getThirst() > 0){
                stats.setThirst(stats.getThirst() - 1);
            }
            playGif(sleepGif, 5000);
            return errorCode.allGood;
        }
        return errorCode.notTired;
    }

    private void playGif(int gif, final int i) {
        gifView.setImageResource(gif);
        Thread t = new Thread(){
            @Override
            public void run(){
                GifDrawable gd = (GifDrawable) gifView.getDrawable();
                gd.start();
                try {
                    sleep(i);
                    gd.pause();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public errorCode eat(){
        if(stats.getHunger() < 10){
            stats.setHunger(stats.getHunger() + 1);
        }
        else{
            return errorCode.notHungry;
        }
        playGif(eatGif, 5000);
        return errorCode.allGood;
    }

    public errorCode play(){
        if(stats.getBored() < 10){
            if(stats.getEnergy() == 0) {
                return errorCode.noEnergy;
            }
            if(stats.getHunger() == 0){
                return errorCode.hungry;
            }
            if(stats.getThirst() == 0){
                return errorCode.thirsty;
            }
            stats.setBored(stats.getBored() + 1);
            if(stats.getHappy() < 10){
                stats.setHappy(stats.getHappy() + 1);
            }
        }
        else{
            return errorCode.notBored;
        }
        playGif(playGif, 5000);
        return errorCode.allGood;
    }

    public errorCode drink(){
        if(stats.getThirst() < 10){
            if(stats.getEnergy() > 0) {
                stats.setThirst(stats.getThirst() + 1);
            }
            else{
                return errorCode.noEnergy;
            }
        }
        else{
            return errorCode.notThirsty;
        }
        playGif(drinkGif, 15000);
        return errorCode.allGood;
    }
}
