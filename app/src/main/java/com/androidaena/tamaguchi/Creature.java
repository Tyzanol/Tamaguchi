package com.androidaena.tamaguchi;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by I336151 on 17/09/2018.
 */

public class Creature {
    private String name;
    private Stats stats;
    private ImageView image;
    private Context context;

    public Creature(String i_name, Context i_context){
        name = i_name;
        stats = new Stats();
//        image = new ImageView(context);
        context = i_context;
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
            return errorCode.allGood;
        }
        return errorCode.notTired;
    }

    public errorCode eat(){
        if(stats.getHunger() < 10){
            stats.setHunger(stats.getHunger() + 1);
        }
        else{
            return errorCode.notHungry;
        }
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
        return errorCode.allGood;
    }

}
