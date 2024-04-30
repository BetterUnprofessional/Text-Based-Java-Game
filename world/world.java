package world;


//import java.lang.Math;
import java.util.Scanner;

import monsters.monster;
import monsters.monsterCreater;
import player.player;
import util.response;

public class world {
    private player pinfo;
    
    
    response resp = new response();
    Scanner input = new Scanner(System.in);
    private int AREANUM = 0;
    private int stage = 0;
    private String areas[] = {"Village", "Grassland", "Cave"}; 

    public static int ANum = 0;



    public world(player p1){
        pinfo = p1;
    }
    public String getArea(){
        return areas[AREANUM];
    }
    public int getStage(){
        return stage;
    }





    public void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("You have some options of what to do: \n");

        if(AREANUM == 0){
            System.out.println("Shop \nDungeon \nItems \nQuit \n");
            String Ans = input.nextLine();
            if (response.quit(Ans)){System.exit(0);}

            //OPEN SHOP!!!
            if(resp.Shop(Ans)){

                /////OPEN SHOP NOT SURE WHAT THATLL DO
                //done
                openShop();
            }
            //OPEN DUNGEON
            if(resp.Dungeon(Ans)){

                //DUNGEON OOOOOOOOO

                openDungeon();

            }
            if(resp.Items(Ans)){
                pinfo.printPlayerItems();
            }
            //input.close();
        }
        else{
            openDungeon();
        }


    }
    private void openShop(){
        shopitems.printShop(pinfo);
                System.out.println("Would you like to purchase one of these items?");
                String userInput = input.nextLine();
                
                try{
                    int UserResp = Integer.parseInt(userInput);

                    //int numUserIsBuying = input.nextInt();
                    int[] shopitemsID= shopitems.getShopItemIDArray().clone();
                    if(pinfo.BankBalance >= shopitems.itemPrice[shopitemsID[UserResp - 1]]){
                        //int buyNum = input.nextInt();
                        shopitems.buyItem(UserResp);
                        System.out.println();
                        System.out.println("You successfully bought " + shopitems.shopItems[shopitemsID[UserResp - 1]] + " for " + shopitems.itemPrice[shopitemsID[UserResp - 1]] + " shmeckles.");
                    }
                    else{
                        System.out.println("You dont have enough money to buy that! /n You only have " + pinfo.BankBalance + " shmeckles.");
                        menu();
                    }

                }
                catch(NumberFormatException ex){
                        //do nothing ig
                }

                //yes buy shit
                if(resp.respondYes(userInput)){
                    System.out.println("What Item Would you like to buy?");
                    System.out.println("Number ___");
                    int numUserIsBuying = input.nextInt();
                    int[] shopitemsID= shopitems.getShopItemIDArray().clone();
                    if(pinfo.BankBalance >= shopitems.itemPrice[shopitemsID[numUserIsBuying - 1]]){
                        //int buyNum = input.nextInt();
                        shopitems.buyItem(numUserIsBuying);
                        System.out.println();
                        System.out.println("You successfully bought " + shopitems.shopItems[shopitemsID[numUserIsBuying - 1]] + " for " + shopitems.itemPrice[shopitemsID[numUserIsBuying - 1]] + " shmeckles.");
                    }
                    else{
                        System.out.println("You dont have enough money to buy that! /n You only have " + pinfo.BankBalance + " shmeckles.");
                        menu();
                    }
                    
                }
                //no dont buy shit recurse back to display menu()
                if(resp.respondNo(userInput)){
                    menu();
                }

    }

    private void openDungeon(){
        if(stage % 5 == 0 && AREANUM < areas.length - 1){
            AREANUM++;
            ANum++;
        }
        System.out.println("You arrive in " + areas[AREANUM] + " on stage "  + stage);

        // 1 = item
        // 2 = monster
        // 3 = special interaction


        //create monster
        monster m = monsterCreater.createMonster();
        m.printMonster();
        monsterMenu(m);
        
        

        /*

        Commented Out for testing monster Purposes.


        int toDoGen =(int)(Math.random() * 3) + 1;
        if(toDoGen == 1){

        }
        else if(toDoGen == 2){
            
        }
        else if(toDoGen == 3){

        }

         */
    }

    private void monsterMenu(monster m){
        while(m.getHealth() > 0){
            System.out.println("Would you like to fight " + m.getName() + "?");
            System.out.println();
            String h = input.nextLine(); 
            if(resp.respondYes(h)){
                    pinfo.fightMonster(m);

                
                if(m.getHealth() <= 0){
                    
                    System.out.println("You defeated " + m.getName() + "!");
                }
                else{
                    m.printMonster();
                }
            }
        
        }
    }
}
