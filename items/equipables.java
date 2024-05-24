package items;

import playerFiles.player;

public abstract class equipables extends item {
    private boolean equipped = false;
    public equipables(){
        setIsConsumable(false);
    }
    public void Use(){
        if(!equipped){
            player.equipedItems.add(this);
            onEquip();
            System.out.println("You equipped " + this.getName());
            equipped = true;
        }
        else{onUnequip();System.out.println("You unequipped " + this.getName());player.equipedItems.remove(this); equipped = false;}

    }
    
    public void onEquip(){}
    public void onUnequip(){}
}
