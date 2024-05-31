package monsters;
import world.world;
import playerFiles.player;
import util.TrekkerMath;

public  class giant extends monster {
    public giant(){
        super.setName("Giant");
        super.setStrength(TrekkerMath.randomInt(7, 3));
        super.setOrigionalHealth((int)(TrekkerMath.randomDouble(3.34, 2) * (player.playerLevel + world.AREANUM + 4)));
        super.setSpeed(monsterCreater.slowMonsterSpeed());
    }
    @Override
    public String attackString(){
        return "whacks you with his big fist";
    }
}