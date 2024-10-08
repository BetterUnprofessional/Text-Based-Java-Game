package items;

public abstract class item {
    private int itemPrice;
    private String name;
    private boolean isConsumable;
    private String type;
    private boolean isAttackingItem;

    public void setName(String name){
        this.name = name;
    }
    public String getItemName(){
        return name;
    }
    public int getPrice(){
        return itemPrice;
    }
    public void setPrice(int x){
        itemPrice = x;
    }
    public String toString() {

        return name;
    }
    public boolean isConsumable(){
        return isConsumable;
    }
    public void setIsConsumable(boolean x){
        isConsumable = x;
    }
    public void Use(){
        
    }
    public void setType(String x){
        type =x;
    }
    public String getType(){return type;}
    public int getStatIncrease(){return 0;}
    public void setIsAttackingItem(boolean x){
        isAttackingItem = x;
    }
    public boolean attackingItem(){
        return isAttackingItem;
    }
    public String getAttackString(){
        return "";
    }
    public String getQuality(){
        return null;
    }
}
