package items;
import playerFiles.*;
public class bread extends consumables{
    int healthIncrease =  player.getMaxHealth()  / 3;
    public bread(){
        setPrice(7);
        setName("Bread");
    }
    public void Use(){
        removeFromInv();
        System.out.println("You heal for " + healthIncrease);
        player.addHealth(healthIncrease);
    }
}
