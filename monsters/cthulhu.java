package monsters;
import playerFiles.*;
import world.world;
import util.TrekkerMath;

public class cthulhu extends boss {
    public cthulhu(){
        setName("Cthulhu");
        setStrength(TrekkerMath.randomInt(20, 7));
        setOrigionalHealth((int)(TrekkerMath.randomDouble(3, 2.5) * (player.playerLevel + world.stageNum + 4)));
    }
    public void attackEffects(int damageDoneToPlayer){
        this.setHealth(this.getHealth() + damageDoneToPlayer/3);
        System.out.println(getName() + " syphons " + damageDoneToPlayer/3 + " health from you!");
    }
    @Override
    public String attackString() {

        return "wraps you with its tenticles";
    }
}
