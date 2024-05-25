package monsters;

import util.*;
import world.*;

import java.lang.reflect.*;

import playerFiles.*;

public class monsterCreater {
    
    public monsterCreater(world world, player Player){
    }

    public static monster createMonster(){

        //Get monster type
        //Class<?> monsterType = 

        Class<? extends monster> mType = monsterArrayList.getMonsterType();
        try {
            Constructor<? extends monster> ctor = mType.getDeclaredConstructor();
            monster m = ctor.newInstance();
            return m;
        } catch (NoSuchMethodException e) {
            // Handle the case where the default constructor is not found
            e.printStackTrace();
        } catch (InstantiationException e) {
            // Handle the instantiation exception
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // Handle illegal access exception
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // Handle invocation target exception
            e.printStackTrace();
        }

        return null;
    }


    public static boss createBoss(){

        //Get monster type
        //Class<?> monsterType = 

        Class<? extends boss> mType = monsterArrayList.getBossMonsterType();
        try {
            Constructor<? extends boss> ctor = mType.getDeclaredConstructor();
            boss b = ctor.newInstance();
            return b;
        } catch (NoSuchMethodException e) {
            // Handle the case where the default constructor is not found
            e.printStackTrace();
        } catch (InstantiationException e) {
            // Handle the instantiation exception
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // Handle illegal access exception
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // Handle invocation target exception
            e.printStackTrace();
        }

        return null;
    }


    public static int fastMonsterSpeed(){
        if(player.getPlayerLevel() > 10){
            return (int)(TrekkerMath.randomDouble(2, .9) * (player.getPlayerLevel() / 4));
        }
        return (int)(TrekkerMath.randomDouble(5, 1.1) * 1);
    }

    public static int slowMonsterSpeed(){
        if(player.getPlayerLevel() > 10){
            return (int)(TrekkerMath.randomDouble(1.2, .5) * (player.getPlayerLevel() / 4));
        }
        return (int)(TrekkerMath.randomDouble(3, 1.1) * 1);
    }
}
