package monsters;

import java.util.ArrayList;

import util.TrekkerMath;

public class monsterArrayList {

    public static ArrayList<Class<? extends monster>> monsterSubclasses = new ArrayList<Class<? extends monster>>();
    
    public monsterArrayList(){
        //Add the classes to the ArrayList on Creation
        monsterSubclasses.add(skeleton.class);
        monsterSubclasses.add(slime.class);
        monsterSubclasses.add(witch.class);
        monsterSubclasses.add(goblin.class);
        monsterSubclasses.add(snake.class);
        monsterSubclasses.add(troll.class);
    }
    
    public static Class<? extends monster> getMonsterType(){
        return monsterSubclasses.get(TrekkerMath.randomInt( monsterSubclasses.size(), 0));
    }
}
