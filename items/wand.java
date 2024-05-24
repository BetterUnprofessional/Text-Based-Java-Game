package items;

public class wand extends equipables {
    private int quality;
    private int wandIncrease;
    

    public wand(){
        quality = (int)((Math.random() * 6) +1);
        wandIncrease = 2*quality;
        setPrice(10);
        setName("Wand");
        setType("Intelligence");
        setIsAttackingItem(true);
        
    }
    public int getStatIncrease(){
        return wandIncrease;
    }
    public void onEquip(){
    }
    
    public void onUnequip(){
    }
    public String getAttackString() {
        return "cast a spell on";
    }
}
