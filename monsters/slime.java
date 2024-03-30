package monsters;
import world.world;
import player.player;
public class slime extends monster{
    public slime(world w, player player){
        super(w, player);
    }
    public String attackString(){
        return "";
    }
}
