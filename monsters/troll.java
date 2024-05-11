package monsters;
import world.world;
import player.player;
import util.TrekkerMath;

public  class troll extends monster {
    public troll(){
        super.setName("Troll");
        super.setStrength(TrekkerMath.randomInt(7, 3));
        super.setOrigionalHealth((int)(TrekkerMath.randomDouble(3.34, 2) * (player.playerLevel + world.stageNum + 4)));
        super.setSpeed(monsterCreater.slowMonsterSpeed());
    }
    @Override
    public String attackString(){
        return "whacks you with a large club";
    }
}