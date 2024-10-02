import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import playerFiles.*;
import items.*;

public class saveFiles {
    File saveFile = new File("saveFile.txt");
    private boolean newSave = false;


    public boolean isNewFile(){
        return newSave;
    }
    public File getFile(){
        return saveFile;
    }

    public void readSave(){
        try{
            if(saveFile.createNewFile()){
                newSave = true;
            }
            else{
                //File already Exists
            }
        }
        catch(IOException e){
            System.out.println("Error Exit Code 1");
            System.exit(0);
        }
    }

    public void save(player p, int AreaNum, int StageNum){
        try{
            //delete old save
            saveFile.delete();
            saveFile.createNewFile();

            FileWriter fWriter = new FileWriter(saveFile);

            // get string version of inventory 
            String s = "";
            for(item e: player.inventory){
                s += e.getName() + " ";
            }
            
            fWriter.write("Player-Name: " + player.getName() + "\n");
            fWriter.write("Player-Current-Health: " + player.getHealth() + "\n");
            fWriter.write("Player-Maximum-Health: " + player.getMaxHealth() + "\n");
            fWriter.write("Player-Strength: " + player.getStrength() + "\n");
            fWriter.write("Player-Agility: " + player.getAgility() + "\n");
            fWriter.write("Player-Intelligence: " + player.getIntelligence() + "\n");
            fWriter.write("Player-XP-to-Level-Up: " + player.getXpToLevelUp() + "\n");
            fWriter.write("Player-XP: " + player.getXP() + "\n");
            fWriter.write("Player-Inventory: " + s + "\n");
            fWriter.write("World-StageNum: " + StageNum);
            fWriter.write("World-AreaNum: " + AreaNum);
            fWriter.close();
            

        }
        catch(IOException e){
            System.out.println("fasldfkj");
        }
    }
}
