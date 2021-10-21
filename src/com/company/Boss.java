package com.company;

public class Boss {
    private int health;
    private int damage;
    private String typeOfProtection;
    public Boss(int health,int damage,String typeOfProtection){
        System.out.println(this);
        this.health = health;
        this.damage =damage;
        this.typeOfProtection = typeOfProtection;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getTypeOfProtection() {
        return typeOfProtection;
    }

    public void setTypeOfProtection(String typeOfProtection) {
        this.typeOfProtection = typeOfProtection;
    }
}
