package monsters;
import items.*;
import playerFiles.*;
import world.world;
import util.TrekkerMath;

public class hydra extends boss {
    public hydra(){
        setName("Hydra");
        setStrength(TrekkerMath.randomInt(14, 7) + (player.playerLevel/2 + world.AREANUM));
        setOrigionalHealth((int)(TrekkerMath.randomDouble(3, 2.5) * (player.playerLevel + world.AREANUM + 4)));
    }
    public void attackEffects(int damageDoneToPlayer){
        for(item e : player.equipedItems){
            String s = e.getItemName();
            if(s.equals("Sword") || s.equals("Dagger")){
                System.out.println("You chop off a head but it grows 2 more");
                setHealth(getHealth()*2);
                setStrength(getStrength()*2);
            }
        }
    }
    @Override
    public String attackString() {

        return "bites you with one of its many heads";
    }
}
