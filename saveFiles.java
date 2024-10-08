import items.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Scanner;
import playerFiles.*;
import world.shopitems;

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
                s += e.getItemName() + " ";
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
            fWriter.write("World-StageNum: " + StageNum + "\n");
            fWriter.write("World-AreaNum: " + AreaNum);
            fWriter.close();
            

        }
        catch(IOException e){
            System.out.println("fasldfkj");
        }
    }
    private static void goToNextReadableText(Scanner reader){
        reader.nextLine();
        reader.next();
    }
    public static player readPlayerSave(File file){
        int chealth, maxhealth, str, ag, inte, xptlu, xp;
            String nameS, invListString;
            player p1;
            try{
            Scanner myReader = new Scanner(file);
            nameS = myReader.nextLine();
            myReader.next();
            chealth = myReader.nextInt();
            saveFiles.goToNextReadableText(myReader);
            maxhealth = myReader.nextInt();
            saveFiles.goToNextReadableText(myReader);
            str = myReader.nextInt();
            saveFiles.goToNextReadableText(myReader);
            ag = myReader.nextInt();
            saveFiles.goToNextReadableText(myReader);
            inte = myReader.nextInt();
            saveFiles.goToNextReadableText(myReader);
            xptlu = myReader.nextInt();
            saveFiles.goToNextReadableText(myReader);
            xp = myReader.nextInt();
            saveFiles.goToNextReadableText(myReader);
            invListString = myReader.nextLine();
            p1 = new player(nameS);
            p1.allocateSkillPoints(str,ag,inte);
            player.setMaxHealth(maxhealth);
            player.setHealth(chealth);
            player.setXP(xp);
            player.setXpToLevelUp(xptlu);

            invListString = invListString.substring(1);
            while (!invListString.equals("")) {
                for (Class<? extends item> e : shopitems.allItemsList) {
                    int indexOfFirstSpace = invListString.indexOf(" ");
                    if(indexOfFirstSpace != -1){
                        if(getItemToAddToInv(e).getItemName().equals(invListString.substring(0,indexOfFirstSpace))){
                            player.addItemToPlayer(getItemToAddToInv(e));
                            invListString = invListString.substring(indexOfFirstSpace+1);

                        }
                    }
                }
            }



            myReader.close();
            return p1;
            }
            catch(IOException e){
                System.out.println("Uh oh");
                p1 = new player("Empty Player");
                return p1;
            }
    }
    public static item getItemToAddToInv(Class<? extends item> e){

        try{
        Constructor<? extends item> ctor = e.getDeclaredConstructor();
        item a = ctor.newInstance();
        
        return a;
        }
        catch(Exception exception){
            return new bread();
        }
    }
}
