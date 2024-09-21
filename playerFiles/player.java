package playerFiles;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

import items.*;
import monsters.*;
import util.*;

public class player {
    //Overall inventory
    public static ArrayList<item> inventory = new ArrayList<item>();
    //Consumables
    public static ArrayList<item> consumableInv = new ArrayList<item>();
    //equipped and unequipped inventory
    public static ArrayList<item> equipableItems = new ArrayList<item>(); 
    public static ArrayList<item> equipedItems = new ArrayList<item>();

    public static String name;
    public static int BankBalance = 100;
    private static String race;
    public static int strength;
    public static int agility;
    public static int intelligence;
    public static int armour = 0;
    public static double luck = Math.random() * 4;
    public static int playerLevel;
    private static int maxHealth;
    public static int health;
    private static int xpToLevelUp = 100;
    private static int xp;
    public static boolean isBuff = false;
    public static String buffType;
    public static int buffLength;
    public static int currentBuffDuration;

    int totalMaxStartingSkills = 10;


    //Constructor
    public player(String pName, String pRace){
        name = pName;
        race = pRace;
        playerLevel = 10;
        xp = 0;
    }
    public static void update(){
        if(isBuff == true){
            updateBuffs();
        }
    }
    //Allocating Skill Points
    public void allocateSkillPoints(int pStrength, int pAgility, int pIntelligence){
        strength = pStrength;
        agility = pAgility;
        intelligence = pIntelligence;
    }
    public void allocateSkillPoints(){
        strength = (int)(Math.random() * totalMaxStartingSkills);
        maxHealth = (int)((double)(strength + 1) * luck * 2.0) +1;
        health = maxHealth;
        intelligence = (int)(Math.random() * (totalMaxStartingSkills - strength));
        agility = (totalMaxStartingSkills - (strength + agility));

    }
    
    //Print your stats
    public static void printStats(){
        System.out.println("Health: "+ health +"/"+maxHealth + "\nStrength: " + strength + "\nAgility: " + agility + "\nIntelligence: " + intelligence);
    }


    //Health Getter
    public static int getMaxHealth(){
        return maxHealth;
    }
    public static int getHealth(){
        return health;
    }
    public static void addHealth(int x){
        if(health + x < maxHealth)
            {health += x;}
        else{health = maxHealth;}
    }
    //Strength Getter
    public static int getStrength(){
        return strength;
    }
    public static void setStrength(int x){
        strength = x;
    }
    //Armour increase
    public static void addArmour(int x){
        armour += x;
    }
    //Agility increase
    public static void addAgility(int x){
        agility += x;
    }
    //Bank Balance
    public int getBankBalance(){
        return BankBalance;
    }
    public static String getName(){
        return name;
    }
    public static void addItemToPlayer(item i){
        inventory.add(i);
        if(i.isConsumable()){
            consumableInv.add(i);
        }
        else{
            equipableItems.add(i);
        }
    }
    public static void updateBuffs(){
        if(name.equals("debug")){
            System.out.println(buffType);
            System.out.println(buffLength);
            System.out.println(currentBuffDuration);
            System.out.println(isBuff);
        }
        currentBuffDuration++;
        if(currentBuffDuration >= buffLength){
            deapplyBuff(buffType);
            buffType = null;
            buffLength = 0;
            currentBuffDuration = 0;
            isBuff = false;
        }
    }
    public static void deapplyBuff(String bType){
        isBuff = false;
        switch(bType){
            case "Strength":
            strength -= 2;
            break;
            case "Intelligence":
            intelligence -=2;
            break;
            case "Agility":
            agility -=2;
            break;
            case "Armour":
            armour -=2;
            break;
        }
    }
    public static void applyBuff(String bType, int bLength){
        buffLength = bLength;
        
        buffType = bType;
        currentBuffDuration = 0;
        if(isBuff == false){
            switch(bType){
                case "Strength":
                strength += 2;
                break;
                case "Intelligence":
                intelligence +=2;
                break;
                case "Agility":
                agility +=2;
                break;
                case "Armour":
                armour +=2;
                break;
            }
            isBuff = true;
        }
        else{
            System.out.println("Your prayers have failed, another god favors you already!");
        }
    }
    //Long ass function for asking and allocating skill points
    public void playerPointAllocation(){
        Scanner userInput = new Scanner(System.in);
        response R = new response();
        int stpts = 0;
        int aglpts = 0;
        int intpts = 0;
        //boolean firstRunthrough;




        int totalpts = 0; //points spent
        while(totalpts < 10){
            
            System.out.println("How many points would you like to allocate to strength?");
            System.out.println("You have " + (10-totalpts) + " left to spend");
                
            int temp = userInput.nextInt();
            if(temp <= (10-totalpts)){
                stpts += temp;
                totalpts += temp;
                System.out.println("You allocate " + stpts + " to strength!");
            }
            else{
                System.out.println("You silly goose you don't have " + temp + " points to spend you only have " + (10 - totalpts));
            }

            System.out.println("How many points would you like to allocate to agility?");
            System.out.println("You have " + (10-totalpts) + " left to spend");
            temp = userInput.nextInt();
            if(temp <= (10 - totalpts)){
                aglpts += temp;
                totalpts += temp;
                System.out.println("You allocate " + aglpts + " to agility!");
            }
            else{
                System.out.println("You silly goose you don't have " + temp + " points to spend you only have " + (10 - totalpts));
            }
            System.out.println("How many points would you like to allocate to intelligence?");
            System.out.println("You have " + (10-totalpts) + " left to spend");
            temp = userInput.nextInt();
            if(temp <= (10 - totalpts)){
                intpts += temp;
                totalpts += temp;
                System.out.println("You allocate " + intpts + " to intelligence!");
            }
            else{
                System.out.println("You silly goose you don't have " + temp + " points to spend you only have " + (10 - totalpts));
            }

            if(totalpts < 10){
                int r = 0;
                //System.out.println("\n You have " + (10-totalpts) + " left to spend. \nWould you like to go back and add points to the attributes?");
                String userResponse = userInput.nextLine();
                while(r == 0){
                    System.out.println("\nYou have " + (10-totalpts) + " left to spend. \nWould you like to go back and add points to the attributes?");
                    userResponse = userInput.nextLine();
                    if(response.respondYes(userResponse)){
                        r = 1;
                        break;
                        

                    }
                    else if(R.respondNo(userResponse)){
                        r = 2;
                        break;
                    }
                    
                }
            if(r == 2){
                break;
            }
            }

        }
        
        this.allocateSkillPoints(stpts, aglpts, intpts);
 
    }

    public static int getPlayerLevel(){
        return playerLevel;
    }
    public static void gainXP(int exp){
        xp += exp;
        if(xp > xpToLevelUp){
            playerLevel++;
            levelPrompt();
        }
    }

    //adding items to inventory through adding item id
    /* 
    public boolean addItemToPlayer(int itemID){
        
        if(!playerItemIDs.contains(itemID)){
            playerItemIDs.add(itemID);
            return true;
        }
        return false;
    }

    */
    public static void printPlayerItems(){
        int printingNum = 1;
        for(item e : inventory){
            System.out.print(printingNum + ": " + e);
            if(e.getQuality() != null){
                System.out.println(" - " + e.getQuality());
            }
            else{
                System.out.println();
            }
            printingNum++;
        }
        

    }
    ///////////////////////////////////////////////////
    // Fighting things
    ///////////////////////////////////////////////////
    public static String getPlayerAttackString(){
        for (item item : equipedItems) {
            if(item.attackingItem()){
                if(!item.getAttackString().equals(""))
                return item.getAttackString();
            }
        }
        return "slap";
    }

    public static void fightMonster(monster m){
        
        

        
        //did the player miss


        //Did the player Crit? or Did the player Miss?
        

        if(m.getSpeed() > agility){
            int damageDoneToMonster = damageDone(m);
            health -= damageTaken(m);
            m.subtractHealth(damageDoneToMonster);
            System.out.println("You " + getPlayerAttackString()+ " " + m.getName() + " for "+ damageDoneToMonster);
                
        }
        else{
            int damageDoneToMonster = damageDone(m);
            m.subtractHealth(damageDoneToMonster);
            System.out.println("You " + getPlayerAttackString()+ " " + m.getName() + " for "+ damageDoneToMonster);
            if(m.getHealth() > 0) {
                health -= damageTaken(m);
            }
        }
        if(m.getHealth() > 0)
            {System.out.println(m.getName() + " has " + m.getHealth() + " health left");}
        System.out.println("You have " + health + " health left");
        System.out.println();
        
    }

    private static void levelPrompt(){
        if(xp > xpToLevelUp){
            System.out.println("Which stat would you like to level up?");
            System.out.println("Your options are, strength, agility, intelligence, or health");
            Scanner input = new Scanner(System.in);
            String temp = input.nextLine();
            try {
                int num = Integer.parseInt(temp) - 1;
                if(num == 1){temp = "strength";}
                else if(num == 2){temp = "agility";}
                else if(num == 3){temp = "intelligence";}
                else if(num == 4){temp = "health";}
                else{temp = "health";}
            } catch (NumberFormatException ex) {}
            if(temp.equals("strength")){
                strength += 1;
            }
            else if(temp.equals("agility")){
                agility += 1;
            }
            else if(temp.equals("intelligence")){
                intelligence += 1;
            }
            else {
                maxHealth += 10;
                health += (int)(((double)health/maxHealth)*10);
                temp = "health";
            }
            xp -= xpToLevelUp;
            xpToLevelUp *= 1.375;
            System.out.println("You level up " + temp);
            System.out.println("Your stats are now ");
            printStats();
            levelPrompt();
        }
    }


    private static int damageTaken(monster m){
        int monsterDamage;
        boolean monsterMiss;
        double monsterMultiplyer = 1;
        //Did monster miss
        if(TrekkerMath.randomInt(100, (agility * 2) - m.getSpeed()*2) > 90){
            monsterMiss = true;
        }
        else{
            monsterMiss = false;
        }
        if(monsterMiss == true){
            monsterMultiplyer = 0;
            System.out.println("The monster missed and you take 0 damage!");
            return 0;
        }

        monsterDamage = (int)(m.getStrength() * monsterMultiplyer);
        if(monsterDamage < armour){
            System.out.println("The " + m.getName() + " tries to " + m.attackString() + " but your strong armour repels their attack");
            return 0;
        }
        if(monsterDamage >= health){
            death(m, monsterDamage);
        }
        System.out.println(m.getName() + " " + m.attackString() + " for " + (m.getStrength()*monsterMultiplyer - armour));
        m.attackEffects(monsterDamage - armour);
        return monsterDamage - armour;
    }

    public static int damageDone(monster m){
        int baseDamageS = strength;
        int baseDamageI = intelligence;
        String attackType;
        double multiplyer;
        boolean playerMiss = false;
        int retDamage;

        if(TrekkerMath.randomInt(100, (intelligence * 3)) > 40){
            multiplyer = TrekkerMath.randomDouble(2, 0);
            if(multiplyer < .5){
                playerMiss = true;
            }
            else{
                playerMiss = false;
            }
        }
        else {
            multiplyer = 1;
        }
        if(playerMiss == true){
            if(multiplyer != 0){
                System.out.println("You swing and only graze the monster but it still does damage.");
            }
            if(multiplyer == 0){
                System.out.println("You completely miss on your attack hitting nothing but air.");
            }
        }
        boolean hasIntWeapon = false;
        for (item e : equipedItems) {
            if(e.attackingItem()){
                attackType = e.getType();
                if(attackType.equals("Strength")){
                    baseDamageS += e.getStatIncrease();
                }
                else if(attackType.equals("Intelligence")){
                    baseDamageI += e.getStatIncrease();
                    hasIntWeapon = true;
                }
            }
        }
        if(hasIntWeapon){
            if(baseDamageI > baseDamageS){ retDamage = baseDamageI;}
            else retDamage = baseDamageS;
        }
        else{
            retDamage = baseDamageS;
        }
        retDamage *= multiplyer;
        if (retDamage == 0){retDamage =1;}
        return retDamage;
    }

    public static void death(monster m, int monsterDamage){
        health = 0;
        System.out.println("You have been killed by " + m.getName() + " after it " + m.attackString() + " for " + monsterDamage);
        System.out.println("Here are your final stats");
        printPlayerItems();
        printStats();
        System.exit(0);
    }
}
