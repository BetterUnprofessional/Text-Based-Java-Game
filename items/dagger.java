package items;
import playerFiles.player;

public class dagger extends equipables{
    int quality;
    int damageToAdd;
    int agilityToAdd;
    public dagger(){
        quality = (int)((Math.random() * 6) +1);
        damageToAdd = (int)(quality * 1.3);
        agilityToAdd = quality * 2;
        setPrice(15);
        setName("Dagger");
    }
    public void onEquip(){
        player.setStrength(player.getStrength() + damageToAdd);
        player.addAgility(agilityToAdd);

    }
    public void onUnequip(){
        player.setStrength(player.getStrength() - damageToAdd);
        player.addAgility(agilityToAdd * -1);
    }
}