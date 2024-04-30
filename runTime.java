import java.util.ArrayList;
import java.util.Scanner;
import monsters.*;
import player.*;
import util.response;
import world.world;

public class runTime
{
    
    
    
    public static void main(String[] args) {
        new monsterArrayList();
        monster h = monsterCreater.createMonster();
        System.out.println(h.getClass());
        
        Scanner userInput = new Scanner(System.in);

        response userResponse = new response();


        //Startup
        System.out.println("What is your name young one?");
        String Name = userInput.nextLine();

        System.out.println("Ah, yes, Good day " + Name + " its so good to see you.");
        System.out.println("What race would you like to be? Example: Dragon, Human, Fish");
        String race = userInput.nextLine();
        
        //Create Player
        player p1 = new player(Name, race);

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //
        //
        //   Testing Giving Items to the Player
        //  
        //      Result : It works
        //////////////////////////////////////////////////////////////////////////////////////////////////


        //p1.addItemToPlayer(2);
        //p1.addItemToPlayer(0);
        //p1.addItemToPlayer(5);
        //p1.printPlayerItems();


        //Allocate poins
        System.out.println("Its time to allocate some skill points!");
        System.out.println("Would You like to allocate your own points? ");
        String Response = userInput.nextLine();
        if(userResponse.respondYes(Response))
        {
            System.out.println("You have 10 points to spend on 4 different attributes! Choose wisely.");
            p1.playerPointAllocation();
            
        }
        else{
            p1.allocateSkillPoints();

        }
        world W = new world(p1);
        //Play Loop
        
        System.out.println("These are your final stats!");
        p1.printStats();
        while(true){
            
            W.menu();
            //initial input
            /* 
            String input = userInput.nextLine();
            
            if(response.quit(input)){System.exit(0);}

            System.out.println("You're in " + W.getArea() + "on stage " + W.getStage());

            W.menu();
            */
            
            System.out.println("Continuing the loop");
        }
        
    }
}