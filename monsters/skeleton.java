package monsters;
import world.world;
import player.player;
import util.TrekkerMath;

public  class skeleton extends monster {
    public skeleton(){
        super.setName("Skeleton");
        super.setStrength(TrekkerMath.randomInt(5, 1));
        super.setOrigionalHealth((int)(TrekkerMath.randomDouble(1.74, 1) * (player.playerLevel + world.stageNum + 4)));
    }
    @Override
    public String attackString(){
        return "rattles his bones at you";
    }
}
