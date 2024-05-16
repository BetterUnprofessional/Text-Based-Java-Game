package items;

public abstract class item {
    private int itemPrice;
    private String name;
    private boolean isConsumable;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
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
}
