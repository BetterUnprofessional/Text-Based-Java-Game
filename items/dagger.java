package items;
import playerFiles.player;

public class dagger extends equipables{
    int quality;
    int damageToAdd;
    int agilityToAdd;
    public dagger(){
        setIsAttackingItem(true);
        quality = (int)((Math.random() * 6) +1);
        setQuality(quality);
        damageToAdd = (int)(quality * 1.3);
        agilityToAdd = quality * 2;
        setPrice(15);
        setName("Dagger");
        setType("Strength");
    }
    public int getStatIncrease(){
        return damageToAdd;
    }
    public void onEquip(){
        player.addAgility(agilityToAdd);

    }
    public void onUnequip(){
        player.addAgility(agilityToAdd * -1);
    }
    public String getAttackString() {
        return "stab";
    }
}