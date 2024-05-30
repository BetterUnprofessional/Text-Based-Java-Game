package world;
import util.*;
import items.*;
import java.util.Scanner;
import playerFiles.*;
import monsters.*;
public class rooms {


    public static void getRandomRoom(){
    int roomNum = 0;
    switch (roomNum){
        case 0:
        System.out.println("You walk into a room and theres a chest sitting on the floor");
        System.out.println("Would you like to open it?");
        Scanner input = new Scanner(System.in);
        String userResp = input.nextLine();
        if(response.respondYes(userResp)){
            //int i = TrekkerMath.randomInt(0, 5);
            int i = TrekkerMath.randomInt(4,0);
            switch (i){
                case 0:
                    System.out.println("You open the chest and get an item!");
                    item a = shopitems.getRandomItem();
                    System.out.println("You obtain " + a);
                    player.inventory.add(a);
                    if(a.isConsumable()){
                        player.consumableInv.add(a);
                    }
                    else{
                        player.equipableItems.add(a);
                    } 
                    world.stageNum++;
                break;
                case 1:
                    System.out.println("You start to open the chest but a tongue wraps around your hand, its a mimic!");
                    mimic m = new mimic();
                    world.monsterMenu(m);
                    int extraMoney = (int)(TrekkerMath.randomInt(100,0) * player.luck);
                    System.out.println("From the mimic's corpse you manage to scavange an extra " + extraMoney + " shmeckles!");
                    player.BankBalance += extraMoney;
                    world.stageNum++;
                break;
                case 2:
                    System.out.println("You open the chest and there is money inside!");
                    extraMoney = (int)(TrekkerMath.randomInt(300,0) * player.luck);
                    player.BankBalance += extraMoney;
                    System.out.println("You gain " + extraMoney + " shmeckles!");
                    world.stageNum++;
                break;
                case 3:
                    System.out.println("The chest is locked");
                    System.out.println("You try and try but cant open it");
                    world.stageNum++;
                break;
                case 4:
                    System.out.println("You trip and fall on your way over to the chest and break your foot");
                    int damage = TrekkerMath.randomInt(0, player.health / 4);
                    System.out.println("You take " + damage + " damage from falling");
                    world.stageNum++;
                break; 
            }
        }














        }
    }
}