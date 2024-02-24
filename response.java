public class response{

    public boolean respondYes(String response){

        if (response.contains("Ye") || response.contains("Sure") || response.contains("ye") || response.contains("sure"))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public boolean respondNo(String response){

        if (response.contains("No") || response.contains("Na") || response.contains("no") || response.contains("na"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean quit(String response){
        if(response.equals("exit")  || response.equals("Exit") || response.equals("Leave") || response.equals("leave") || response.equals("quit") || response.equals("Quit")){
            return true;
        }
        else return false;
    }
    public boolean Shop(String response){
        if(response.equals("Shop")  || response.equals("shop")){
            return true;
        }
        else return false;
    }
    public boolean Dungeon(String response){
        if(response.equals("dungeon")  || response.equals("Dungeon")){
            return true;
        }
        else return false;
    }
    public boolean Items(String response){
        if(response.equals("items")  || response.equals("Items") || response.equals("Item") || response.equals("item")){
            return true;
        }
        else return false;
    }
}

