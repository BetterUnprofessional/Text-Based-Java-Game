package world;


//import java.lang.Math;
import java.util.Scanner;
import monsters.*;
import player.*;
import util.*;

public class world {
    private player pinfo;
    
    
    response resp = new response();
    Scanner input = new Scanner(System.in);
    private int AREANUM = 0;
    private int stage = 0;
    private String areas[] = {"Village", "Grassland", "Cave", "Hell", "A second Cave?", "A THIRD CAVE??", "Why is there two hells?", "Are you actually still playing???", "Bored Yet?", "How bout now?"}; 

    public static int stageNum = 0;



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
        

        if(stage % 5 == 0){
            System.out.println("You have some options of what to do: \n");
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
        shopitems.printShop();
        System.out.println("Would you like to purchase one of these items?");
        String userInput = input.nextLine();
                
        try{
            int UserResp = Integer.parseInt(userInput);

            //int numUserIsBuying = input.nextInt();
             int[] shopitemsID= shopitems.getShopItemIDArray().clone();
            if(player.BankBalance >= shopitems.itemPrice[shopitemsID[UserResp - 1]]){
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
            input.nextLine();
            int[] shopitemsID= shopitems.getShopItemIDArray().clone();
            if(player.BankBalance >= shopitems.itemPrice[shopitemsID[numUserIsBuying - 1]]){
                //int buyNum = input.nextInt();
                shopitems.buyItem(numUserIsBuying);
                System.out.println();
                System.out.println("You successfully bought " + shopitems.shopItems[shopitemsID[numUserIsBuying - 1]] + " for " + shopitems.itemPrice[shopitemsID[numUserIsBuying - 1]] + " shmeckles.");
            }
            else{
                System.out.println("You dont have enough money to buy that! /n You only have " + player.BankBalance + " shmeckles.");
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
            System.out.println();
            System.out.println("What would you like to do?");
            String h = input.nextLine(); 
            if(response.quit(h)){System.exit(0);}
            if(resp.respondFight(h)){
                    pinfo.fightMonster(m);

                
                if(m.getHealth() <= 0){
                    
                    System.out.println("You defeated " + m.getName() + "!");
                    int coinGain = (int)((pinfo.luck * stageNum) + 4);
                    int xpGain = (int)((pinfo.luck * (stageNum+1))*20);
                    System.out.println("You obtained " + coinGain + " shmeckles and " + xpGain + " XP!");
                    player.BankBalance += coinGain;
                    pinfo.gainXP(xpGain);
                    stage++;
                    stageNum++;
                }
                else{
                    m.printMonster();
                }
            }
            //////////////////////////////////////////
            //Use an item during a fight
            /////////////////////////////////////////
            else if(resp.Items(h)){
                pinfo.printPlayerItems();
                System.out.println("Would you like to use an item?");
                h = input.nextLine();

                try{
                    int number = Integer.parseInt(h);
                    int itemId = player.playerItemIDs.remove(number-1);
                    pinfo.useItem(itemId);


                }
                catch(NumberFormatException ex){
                    //do nothing
                }

                if(resp.respondYes(h)){
                    System.out.println("What is the number of the item you would like to use");
                    int temp = input.nextInt();
                    input.nextLine();
                    int itemId = player.playerItemIDs.remove(temp-1);
                    pinfo.useItem(itemId);
                }
            }
        
        }
    }
}
