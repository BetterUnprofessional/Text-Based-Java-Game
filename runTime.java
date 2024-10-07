
import java.io.IOException;
import java.util.Scanner;
import monsters.*;
import playerFiles.*;
import util.response;
import world.*;
import items.*;


public class runTime
{
    
    
    
    public static void main(String[] args) {
        saveFiles saves = new saveFiles();
        saves.readSave();
        new shopitems();
        new monsterArrayList();
        gui.runGui();
        

        Scanner userInput = new Scanner(System.in);
        player p1;
        if(saves.isNewFile()){
             //Startup
            System.out.println("What is your name young one?");
            String Name = userInput.nextLine();

            System.out.println("Ah, yes, Good day " + Name + " its so good to see you.");
            
            //Create Player
            p1 = new player(Name);

            //Allocate poins
            System.out.println("Its time to allocate some skill points!");
            System.out.println("Would You like to allocate your own points? ");
            String Response = userInput.nextLine();
            if(response.respondYes(Response))
            {
                System.out.println("You have 10 points to spend on 4 different attributes! Choose wisely.");
                p1.playerPointAllocation();

            }
            else{
                p1.allocateSkillPoints();

            }
        }
        else{//WERE READING FILES NOW????
            int chealth, maxhealth, str, ag, inte, xptlu, xp;
            String nameS, invListString;
            try{
            Scanner myReader = new Scanner(saves.getFile());
            nameS = myReader.nextLine();
            myReader.next();
            chealth = myReader.nextInt();
            myReader.nextLine();
            myReader.next();
            maxhealth = myReader.nextInt();
            myReader.nextLine();
            myReader.next();
            str = myReader.nextInt();
            myReader.nextLine();
            myReader.next();
            ag = myReader.nextInt();
            myReader.nextLine();
            myReader.next();
            inte = myReader.nextInt();
            myReader.nextLine();
            myReader.next();
            xptlu = myReader.nextInt();
            myReader.nextLine();
            myReader.next();
            xp = myReader.nextInt();
            myReader.nextLine();
            invListString = myReader.nextLine();
            p1 = new player(nameS);
            p1.allocateSkillPoints(str,ag,inte);
            player.setMaxHealth(maxhealth);
            player.setHealth(chealth);
            player.setXP(xp);
            player.setXpToLevelUp(xptlu);


            //////...... MUST BE IMPLIMENTED OTHERWISE BAD AND SAD AND NO GOOD
            for (Class<? extends item> e : shopitems.allItemsList) {
                if(e.getName().equals())
                
            }



            myReader.close();
            }
            catch(IOException e){
                System.out.println("Uh oh");
                p1 = new player("Empty Player");
            }
        }

       
        world W = new world();
        //Play Loop
        
        System.out.println("These are your final stats!");
        player.printStats();
        while(true){
            saves.save(p1, 0, 0); 
            W.menu();
            player.update();
        }
        
    }
}