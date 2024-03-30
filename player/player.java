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
    public int BankBalance = 100;
    public String race;
    public int strength;
    public int agility;
    public int intelligence;
    public double luck = Math.random() * 4;
    public int playerLevel;
    private int health;

    int totalMaxStartingSkills = 10;


    //Constructor
    public player(String pName, String pRace){
        name = pName;
        race = pRace;
        playerLevel = 0;
    }

    //Allocating Skill Points
    public void allocateSkillPoints(int pStrength, int pAgility, int pIntelligence){
        strength = pStrength;
        agility = pAgility;
        intelligence = pIntelligence;
    }
    public void allocateSkillPoints(){
        strength = (int)(Math.random() * totalMaxStartingSkills);
        health = (int)((double)(strength + 1) * luck * 2.0);
        intelligence = (int)(Math.random() * (totalMaxStartingSkills - strength));
        agility = (totalMaxStartingSkills - (strength + agility));

    }
    
    //Print your stats
    public void printStats(){
        System.out.println("Strength: " + strength + "\nAgility: " + agility + "\nIntelligence: " + intelligence);
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
            int dmg = m.subtractHealth(playerDamage);
            
            if(playerMiss == true){
                System.out.println("You miss on your attack but...");
            }
            


            System.out.println("You do " + dmg + " to " + m.getName());
                
        }
        else{
            int dmg = m.subtractHealth(playerDamage);

            if(playerMiss == true){
                System.out.println("You miss on your attack but...");
            }
            
            System.out.println("You do " + dmg + " to " + m.getName());
            if(m.getHealth() > 0) {health -= m.getStrength();}
        }
        
    }
}
