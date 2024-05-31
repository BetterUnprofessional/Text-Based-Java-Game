package items;

import playerFiles.player;

public abstract class equipables extends item {
    private boolean equipped = false;
    private String qualityString;
    //private int quality;
    public equipables(){
        setIsConsumable(false);
    }
    public void setQuality(int x){
        //quality = x;
        //1.bad 2.mediocre 3.fine 4.good 5.excelent 6.perfect
        if(x ==1){qualityString = "Bad";}
        else if (x ==2){ qualityString = "Mediocre";}
        else if (x ==3){ qualityString = "Fine";}
        else if (x ==4){ qualityString = "Good";}
        else if (x ==5){ qualityString = "Excelent";}
        else if (x ==6){ qualityString = "Perfect";}
    
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
    public String getQuality(){
        return qualityString;
    }
    
    public void onEquip(){}
    public void onUnequip(){}
}
