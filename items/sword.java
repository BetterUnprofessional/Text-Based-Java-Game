package items;


public class sword extends equipables {
    private int quality;
    private int swordIncrease;
    

    public sword(){
        setIsAttackingItem(true);
        quality = (int)((Math.random() * 6) +1);
        swordIncrease = 2*quality;
        setPrice(30);
        setName("Sword");
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
        return "slice";
    }
}