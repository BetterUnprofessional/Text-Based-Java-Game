package items;


public class club extends equipables {
    private int quality;
    private int swordIncrease;
    

    public club(){
        setIsAttackingItem(true);
        quality = (int)((Math.random() * 6) +1);
        setQuality(quality);
        swordIncrease = (int)(1.7*quality);
        setPrice(30);
        setName("Club");
        setType("Strength");
        
    }
    public int getStatIncrease(){
        return swordIncrease;
    }
    public void onEquip(){
    }
    
    public void onUnequip(){
    }
    public String getAttackString() {
        return "bonk";
    }
}