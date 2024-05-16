package items;

public abstract class item {
    private int itemPrice;
    private String name;

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
}
