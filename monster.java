public class monster {
    
    private String mName;
    private int mHealth;
    private int mStrength;
    private int mArmour;
    private int mLevel;
    private world world;
    private player player;

    public monster(world world , player player){
        this.world = world;
        this.player = player;

        //CREATE THE MONSTER
        String[] areaMonsterArray = {"Goblin", "Slime", "Agressive Walrus", "Dinosaur", "Snake", "Skeleton", "Orc", "Troll", "Witch", "Zombie", "Demon", "Dragon", "Vampire", "Werewolf", "Chimera", "Banshee", "Kelpie", "Dullahan", "Chupacabra", "Wendigo", "Jersey Devil", "Kitsune", "Nuckelavee", "Basilisk", "Fomorian", "Boggart", "Manticore", "Selkie", "Naga", "Bunyip", "Hodag", "Leshy", "Jackalope", "Qilin"
    };
        int randomNum = (int)(Math.random() * areaMonsterArray.length);
        mName = areaMonsterArray[randomNum];
        mHealth = (int)(TrekkerMath.randomDouble(1.34, .7) * (player.playerLevel + world.getStage() + 10)); 
    }
    public String getName(){
        return mName;
    }
    public int getHealth(){
        return mHealth;
    }
    public void subtractHealth(int x){
        mHealth -= x;
    }
    public int getStrength(){
        return mStrength;
    }
    public int getLevel(){
        return mLevel;
    }
    public void printMonster(){
        System.out.println(mName + " level " + mLevel + " has " + mHealth + " HP.");
    }

}
