package items;
import playerFiles.*;

public class helmet extends equipables{
    int armourAdd;
    int quality;
    public helmet(){
        quality = (int)((Math.random() * 6) +1);
        armourAdd = (int)(quality * 1.3);
        setPrice(20);
        setName("helmet");

    }
    public void onEquip(){
        
        player.addArmour(armourAdd);
    }
    public void onUnequip(){
        player.addArmour(armourAdd*-1);
    }
}