package items;
import playerFiles.*;

public class chestplate extends equipables{
    int armourAdd;
    int quality;
    public chestplate(){
        quality = (int)((Math.random() * 6) +1);
        setQuality(quality);
        armourAdd = quality * 2;
        setPrice(45);
        setName("Chestplate");

    }
    public void onEquip(){
        
        player.addArmour(armourAdd);
    }
    public void onUnequip(){
        player.addArmour(armourAdd*-1);
    }
}