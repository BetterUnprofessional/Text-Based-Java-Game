
import java.util.Scanner;
import monsters.*;
import playerFiles.*;
import util.response;
import world.*;


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

            p1 = saveFiles.readPlayerSave(saves.getFile());
            

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