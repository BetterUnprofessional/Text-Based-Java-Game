package player;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

import monsters.monster;
import util.TrekkerMath;
import util.response;
import world.shopitems;

public class player {
    public static ArrayList<Integer> playerItemIDs = new ArrayList<Integer>();
    public String name;
    public static int BankBalance = 100;
    public String race;
    public int strength;
    public int agility;
    public int intelligence;
    public double luck = Math.random() * 4;
    public static int playerLevel;
    private int maxHealth;
    private int health;
    private int xpToLevelUp = 100;
    private int xp;


    int totalMaxStartingSkills = 10;


    //Constructor
    public player(String pName, String pRace){
        name = pName;
        race = pRace;
        playerLevel = 0;
        xp = 0;
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
    public void printStats(){
        System.out.println("Health: "+ health +"/"+maxHealth + "\nStrength: " + strength + "\nAgility: " + agility + "\nIntelligence: " + intelligence);
    }


    //Health Getter
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getHealth(){
        return health;
    }
    //Bank Balance
    public int getBankBalance(){
        return BankBalance;
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
                int response = 0;
                //System.out.println("\n You have " + (10-totalpts) + " left to spend. \nWould you like to go back and add points to the attributes?");
                String userResponse = userInput.nextLine();
                while(response == 0){
                    System.out.println("\nYou have " + (10-totalpts) + " left to spend. \nWould you like to go back and add points to the attributes?");
                    userResponse = userInput.nextLine();
                    if(R.respondYes(userResponse)){
                        response = 1;
                        break;
                        

                    }
                    else if(R.respondNo(userResponse)){
                        response = 2;
                        break;
                    }
                    
                }
            if(response == 2){
                break;
            }
            }

        }
        
        this.allocateSkillPoints(stpts, aglpts, intpts);
 
    }

    public static int getPlayerLevel(){
        return playerLevel;
    }
    public void gainXP(int exp){
        xp += exp;
        if(xp > xpToLevelUp){
            playerLevel++;
            levelPrompt();
            xp -= xpToLevelUp;
            xpToLevelUp *= 1.375;
        }
    }

    //adding items to inventory through adding item id
    public boolean addItemToPlayer(int itemID){
        
        if(!playerItemIDs.contains(itemID)){
            playerItemIDs.add(itemID);
            return true;
        }
        return false;
    }


    public void printPlayerItems(){
        int printingNum = 1;
        for(int e : playerItemIDs){
            System.out.println(printingNum + ": " + shopitems.shopItems[e]);
            printingNum++;
        }
        

    }

    public void fightMonster(monster m){
        boolean monsterMiss;
        boolean playerMiss = true;
        double monsterMultiplyer = 1;
        double multiplyer;
        int playerDamage;
        

        //Did the monster Miss
        if(TrekkerMath.randomInt(100, agility * 5) > 50){
            monsterMiss = false;
        }
        else{
            monsterMiss = true;
            multiplyer = 0;
        }

        //Did the player Crit?
        if(monsterMiss == false && TrekkerMath.randomInt(100, agility * 3) > 40){
            multiplyer = TrekkerMath.randomDouble(3, 0);
            if(multiplyer < 1){
                playerMiss = true;
            }
            else{
                playerMiss = false;
            }
        }
        else {
            multiplyer = 1;
        }

        playerDamage = (int)(multiplyer * (double)strength) + 1;

        if(monsterMiss = true){
            monsterMultiplyer = 0;
        }
        if(m.getSpeed() > agility){
            health -= m.getStrength() * monsterMultiplyer;
            System.out.println(m.getName() + " " + m.attackString() + " for " + m.getStrength());
            int dmg = m.subtractHealth(playerDamage);
            
            if(playerMiss == true){
                if(dmg != 0){
                    System.out.println("You miss on your attack but...");
                }
                if(dmg == 0){
                    System.out.println("You completely miss on your attack hitting nothing but air.");
                }
            }
            


            System.out.println("You do " + dmg + " to " + m.getName());
                
        }
        else{
            int dmg = m.subtractHealth(playerDamage);

            if(playerMiss == true){
                if(dmg != 0){
                    System.out.println("You miss on your attack but...");
                }
                if(dmg == 0){
                    System.out.println("You completely miss on your attack hitting nothing but air.");
                }
            }
            
            System.out.println("You do " + dmg + " to " + m.getName());
            if(m.getHealth() > 0) {
                health -= m.getStrength();
                System.out.println(m.getName() + " " + m.attackString() + " for " + m.getStrength());
            }
        }
        if(m.getHealth() != 0)
            {System.out.println(m.getName() + " has " + m.getHealth() + " health left");}
        System.out.println("You have " + health + " left");
        System.out.println();
        
    }
    public void useItem(int itemNum){
        //Fish
        if(itemNum == 0){
            int healthgain;
            if(maxHealth/5 + health < maxHealth){
                healthgain = maxHealth / 5;
            }
            else{
                healthgain = maxHealth - health;
            }
            System.out.println("You consume a fish and gain " + healthgain + " health");
            health+= healthgain;
            System.out.println("You now have " + health + " health.");
            
        }
        if(itemNum == 6){
            int healthgain;
            if(maxHealth/5 + health < maxHealth){
                healthgain = maxHealth / 2;
            }
            else{
                healthgain = maxHealth - health;
            }
            System.out.println("You consume a fish and gain " + healthgain + " health");
            health+= healthgain;
            System.out.println("You now have " + health + " health.");
            
        }
    }
    private void levelPrompt(){
        System.out.println("Which stat would you like to level up?");
        System.out.println("Your options are, strength, agility, intelligence, or health");
        Scanner input = new Scanner(System.in);
        String temp = input.nextLine();
        try {
            int num = Integer.parseInt(temp) - 1;
            if(num == 1){temp = "strength";}
            if(num == 2){temp = "agility";}
            if(num == 3){temp = "intelligence";}
            if(num == 4){temp = "health";}
        } catch (NumberFormatException ex) {}
        if(temp.equals("strength")){
            strength += 1;
        }
        if(temp.equals("agility")){
            agility += 1;
        }
        if(temp.equals("intelligence")){
            intelligence += 1;
        }
        if(temp.equals("health")){
            maxHealth += 10;
            health += (int)(((double)health/maxHealth)*10);
        }
        System.out.println("You level up " + temp);
        System.out.println("Your stats are now ");
        printStats();
    }
}
