package world;
import util.*;
import items.*;
import java.util.Scanner;
import playerFiles.*;
import monsters.*;
public class rooms {


    public static void getRandomRoom(){
    int roomNum = TrekkerMath.randomInt(2, 0);
    Scanner input = new Scanner(System.in);
    switch (roomNum){
        case 0:
        System.out.println("You walk into a room and theres a chest sitting on the floor");
        System.out.println("Would you like to open it?");
        
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
                    int damage = TrekkerMath.randomInt(player.health / 4, 0);
                    System.out.println("You take " + damage + " damage from falling");
                    world.stageNum++;
                break; 
            }
        
        }
        break;
        //Pray to an idol
        case 1:
            System.out.println("You walk into a large empty cobblestoned room with a idol");
            String buffType = "";
            int i = TrekkerMath.randomInt(3, 0);
            switch(i){
                case 0:
                buffType = "Strength";
                System.out.println("The statue seems to depict a hulking bear");
                break;
                case 1:
                buffType = "Intelligence";
                System.out.println("The statue seems to depict a large owl with dark Jade eyes");
                break;
                case 2:
                buffType = "Agility";
                System.out.println("The statue seems to depict a gazelle that is mid jump");
                break;
                case 3:
                buffType = "Armour";
                System.out.println("The statue seems to depict an armadillo that is curled up into a little ball");
                break;
            }
            System.out.println("Would you like to pray to the idol?");
            userResp = input.nextLine();
            if(response.respondYes(userResp)){
                player.applyBuff(buffType, 5);
                System.out.println("You feel blessed! The animal has improved you!");
            }
        world.stageNum++;
        break;
        case 2:
        //healing fountain?
        System.out.println("You walk into a room with a fountain in the center. The room is too dark to see what color the water is");

        System.out.println("Take a drink?");
        userResp = input.nextLine();
        if(response.respondYes(userResp)){
            i = TrekkerMath.randomInt(roomNum, 0);
            switch(i){
                case 0:
                System.out.println("The water was crystal clear! You feel your wounds healing! Must've been a magic fountian!");
                player.addHealth(player.getMaxHealth() - player.getHealth());
                break;
                case 1:
                System.out.println("The water tasted slightly metallic. You ignore the strange taste and continue drinking.");
                player.addHealth(player.getMaxHealth() / 10);
                System.out.println("Do you decide to reach into the water to see what lies beneath the surface?");
                userResp = input.nextLine();
                if(response.respondYes(userResp)){
                    i = TrekkerMath.randomInt(1, 0);
                    switch(i){
                        case 0:
                        System.out.println("You reach in and find coins!");
                        int coinage = TrekkerMath.randomInt(world.stageNum + 20, 0);
                        System.out.println("You gain " + coinage + " shmeckles!");
                        break;
                        case 1:
                        System.out.println("You reach in and find a sword lying under the surface of the water!");
                        player.addItemToPlayer(new sword());
                        break;
                        case 2:
                        System.out.println("A goblin grabs your arm! In your haste to recover he takes off three of your fingers!");
                        player.health -= 10;
                        goblin g = new goblin();
                        world.monsterMenu(g);
                        break;
                    }
                }
                break;
                case 2:
                System.out.println("The water tastes like garbage! You turn around and immediately vomit!");
                int h = player.health /= 4;
                System.out.println("You manage to keep your intestines inside of you. You have " + h + " health left.");
                break;
            }
        }
        world.stageNum++;
        break;
            











        }
    }
}