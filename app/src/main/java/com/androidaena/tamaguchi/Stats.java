package com.androidaena.tamaguchi;

import android.graphics.Color;

/**
 * Created by I336151 on 17/09/2018.
 */

class Stats {
    private int age;
    private int color;
    private int hunger;
    private int thirst;
    private int bored;
    private int energy;
    private int happy;

    public Stats(){
        age = 1;
        color = Color.BLACK;
        hunger = 5;
        thirst = 5;
        bored = 5;
        energy = 5;
        happy = 5;
    }

    public int getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public int getHappy() {
        return happy;
    }

    public int getBored() {
        return bored;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getEnergy() {
        return energy;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public void setBored(int bored) {
        this.bored = bored;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
