package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class Main {

    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static String[] heroesAttackTypes = {"Physical",
            "Magical", "Kinetic", "Golem", "Lucky", "Berserk", "Thor", "Medic"};
    public static int[] heroesHealth = {290, 280, 250, 350, 270, 170, 215, 260};
    public static int[] heroesDamages = {20, 25, 15, 5, 10, 21, 24, 0};
    public static int roundNumber = 0;

    public static void golem() {
        bossDamage = bossDamage / 5;
    }

    public static void chooseDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackTypes.length);
        bossDefenceType = heroesAttackTypes[randomIndex];
        System.out.println("Boss chose: " + bossDefenceType);
    }

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
            Boss Boss = new Boss(700,51,"Shield");
            System.out.println("Boss health:" + Boss.getHealth() + " Boss damage:" + Boss.getDamage()
                    + " Boss type of protection is" + Boss.getTypeOfProtection());
        }
    }

    public static void round() {
        roundNumber++;
        chooseDefence();
        golem();
        bossHits();
        heroesHit();
        medicHealing();
        luckyy();
        berserkDeferences();
        thorr();
        printStatistics();
        thorComeBack();
    }

    public static void thorr() {
        Random random = new Random();
        boolean thorHit = random.nextBoolean();
        if (thorHit == true) {
            bossDamage = 0;
        }
    }

    public static void thorComeBack() {
        bossDamage = 50;
    }

    public static void berserkDeferences() {
        Random random = new Random();
        int berserkRond = random.nextInt(25) + 1;
        heroesHealth[5] = heroesHealth[5] + berserkRond;
        heroesDamages[5] = heroesHealth[5] + berserkRond;

    }

    public static void medicHealing() {
        Random random = new Random();
        int randomHealth = random.nextInt(150) + 1;
        int randomHeroes = random.nextInt(6);

        if (heroesHealth[3] > 0) {
            if (heroesHealth[randomHeroes] < 100 && heroesHealth[randomHeroes] > 0) {
                heroesHealth[randomHeroes] = heroesHealth[randomHeroes] + randomHealth;
            }
            System.out.println("?????????? ??????????????: " + heroesAttackTypes[randomHeroes]);

        }


    }

    public static void luckyy() {
        Random random = new Random();
        boolean randomLucky = random.nextBoolean();
        if (randomLucky == true) {
            heroesHealth[4] = heroesHealth[4] + bossDamage;
            System.out.println("I don't get damage");
        } else {
            heroesHealth[4] = heroesHealth[4];
        }
    }


    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;

    }

    public static void printStatistics() {
        System.out.println("________ ROUND " + roundNumber);
        System.out.println("Boss health: " + bossHealth +
                " [" + bossDamage + "]");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackTypes[i] +
                    " health: " + heroesHealth[i] +
                    " [" + heroesDamages[i] + "]");
        }
        System.out.println("________________");
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamages.length; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossDefenceType == heroesAttackTypes[i]) {
                    Random random = new Random();
                    int coeff = random.nextInt(9) + 2;
                    if (bossHealth - heroesDamages[i] * coeff < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamages[i] * coeff;
                    }
                    System.out.println("Critical damage: "
                            + heroesDamages[i] * coeff);
                } else {
                    if (bossHealth - heroesDamages[i] < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamages[i];
                    }
                }
            }
        }
    }
}

