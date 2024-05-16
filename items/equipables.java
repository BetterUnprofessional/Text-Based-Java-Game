package items;

public abstract class equipables extends item {
    private boolean equipped = false;
    public equipables(){
        setIsConsumable(false);
    }
    public void Use(){
        if(!equipped){
            onEquip();
            System.out.println("You equipped " + this.getName());
        }
        else{onUnequip();System.out.println("You unequipped " + this.getName());}

    }
    public void onEquip(){}
    public void onUnequip(){}
}
