package world;
import player.player;

public class shopitems {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // precondition: all shops are 4 items
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static String[] shopItems = {"Fish", "Butter Knife", "Generic Sword", "Ivory Tusk", "Backpack", "Eyes in a Jar"};
    public static int[] itemPrice = {5, 1, 25, 30, 10, 3};
    
    private static int[] holdingArr = new int[4];

    public shopitems(){
    }

    public static void printShopItems(){
        holdingArr = returnShopItemsID();
        int index = 1;
        for(int e:holdingArr){
            
            System.out.print(index + ": " + shopItems[e]);
            System.out.println("   | costs " + itemPrice[e] + " gold");
            index++;
        }

    }

    public static int[] returnShopItemsID(){
        int[] randomItemNum = new int[4];
        for(int i = 0; i < randomItemNum.length; i++){
            randomItemNum[i] = (int)(Math.random() * shopItems.length);
        }
        return randomItemNum;
    }

    public static int getItemPrice(int IDNum){
        return itemPrice[IDNum];
    }

    public static void printShop(player player){
        System.out.println("You have " + player.BankBalance + " shmeckles!");

        System.out.println("Heres whats in the shop!");
        printShopItems();

    }
    public static void buyItem(int shopItemNum){
        int itemID = holdingArr[shopItemNum - 1];
        player.playerItemIDs.add(itemID); 
        player.BankBalance -= itemPrice[itemID];
    }
    public static int[] getShopItemIDArray(){
        return holdingArr;
    }
}
