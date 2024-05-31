
import java.util.Scanner;
import monsters.*;
import playerFiles.*;
import util.response;
import world.*;


public class runTime
{
    
    
    
    public static void main(String[] args) {
        new shopitems();
        new monsterArrayList();
        
        Scanner userInput = new Scanner(System.in);
        //Startup
        System.out.println("What is your name young one?");
        String Name = userInput.nextLine();

        System.out.println("Ah, yes, Good day " + Name + " its so good to see you.");
        System.out.println("What race would you like to be? Example: Dragon, Human, Fish");
        String race = userInput.nextLine();
        
        //Create Player
        player p1 = new player(Name, race);

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
        world W = new world();
        //Play Loop
        
        System.out.println("These are your final stats!");
        player.printStats();
        while(true){
            
            W.menu();
            player.update();
            
        }
        
    }
}