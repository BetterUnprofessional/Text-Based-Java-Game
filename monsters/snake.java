package monsters;
import world.world;
import player.player;
import util.TrekkerMath;

public  class snake extends monster {
    public snake(){
        super.setName("Snake");
        super.setStrength(TrekkerMath.randomInt(2, 1));
        super.setOrigionalHealth((int)(TrekkerMath.randomDouble(1.34, .7) * (player.playerLevel + world.stageNum + 4)));
        super.setSpeed((int)(monsterCreater.fastMonsterSpeed() * 1.5));
    }
    @Override
    public String attackString(){
        return "bites you really hard";
    }
}