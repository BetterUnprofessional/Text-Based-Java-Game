    package monsters;

import player.player;
import util.TrekkerMath;
import world.world;

public class monster {
    
    private String mName;
    private int mHealth;
    private int mStrength;
    private int mSpeed;
    private int mArmour;
    private int mLevel;
    private world world;
    private player player;

    private static String[] fastMonsters = {"Goblin", "Snake", "Witch", "Vampire", "Banshee", "Kelpie", "Chupacabra", "Jersey Devil", "Kitsune", "Selkie", "Jackalope", "Qilin"};
    private static String[] armouredMonsters = {"Goblin", "Agressive Walrus", "Orc", "Troll", "Dragon", "Basilisk", "Boggart", "Naga", "Hodag"};
    private static String[] areaMonsterArray = {"Goblin", "Slime", "Agressive Walrus", "Dinosaur", "Snake", "Skeleton", "Orc", "Troll", "Witch", "Zombie", "Demon", "Dragon", "Vampire", "Werewolf", "Chimera", "Banshee", "Kelpie", "Dullahan", "Chupacabra", "Wendigo", "Jersey Devil", "Kitsune", "Nuckelavee", "Basilisk", "Fomorian", "Boggart", "Manticore", "Selkie", "Naga", "Bunyip", "Hodag", "Leshy", "Jackalope", "Qilin"};


    /*
     * Object oriented attempt 1
     */
    
    public monster(world world , player player){
        this.world = world;
        this.player = player;

        //CREATE THE MONSTER
        int randomNum = (int)(Math.random() * areaMonsterArray.length);
        mName = areaMonsterArray[randomNum];
        mHealth = (int)(TrekkerMath.randomDouble(1.34, .7) * (player.playerLevel + world.getStage() + 10)); 
        
        //See if monster should be fast
        if(TrekkerMath.arrContains(fastMonsters, mName)){
            mSpeed = (int)(TrekkerMath.randomDouble(2, .9) * (player.agility));
        }
        else{
            mSpeed = (int)(TrekkerMath.randomDouble(1.2, 0.25) * (player.agility + 1));
        }
        
        //See if monster should have armour
        if(TrekkerMath.arrContains(armouredMonsters, mName)){
            mArmour = TrekkerMath.randomInt(player.strength / 2, 0);
        }
        else{
            mArmour = 0;
        }
        
        //Old Speed Calc
        //mSpeed = (int)((player.playerLevel / 4) * TrekkerMath.randomDouble(1.5, 0.25));
    }
    public String getName(){
        return mName;
    }
    public int getHealth(){
        return mHealth;
    }
    public int subtractHealth(int x){
        if(mArmour != 0){
            double armMultiplyer = 1.0 / mArmour;
            double subtractor = ((double)x * armMultiplyer);
            mHealth -= (int)subtractor;
            return (int)subtractor;
        }
        else{
            mHealth -= x;
            return x;
        }
    }
    public int getStrength(){
        return mStrength;
    }
    public int getSpeed(){
        return mSpeed;
    }
    public int getLevel(){
        return mLevel;
    }
    public int getArmour(){
        return mArmour;
    }
    public void printMonster(){
        System.out.println(mName + " level " + mLevel + " has " + mHealth + " HP.");
    }

}
