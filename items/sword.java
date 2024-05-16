package items;

import playerFiles.player;

public class sword extends equipables {
    private int quality;
    private int swordIncrease;
    

    public sword(){
        quality = (int)((Math.random() * 6) +1);
        swordIncrease = 2*quality;
        setPrice(30);
        setName("Sword");
        
    }
    
    public void onEquip(){

        player.setStrength(player.strength + swordIncrease);
    }
    
    public void onUnequip(){
        player.setStrength(player.strength - swordIncrease);
    }
}