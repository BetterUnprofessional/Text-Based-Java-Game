package util;
public class TrekkerMath {
    
    public static int randomInt(int toVal, int fromVal){
        int ret = (int)(Math.random() * toVal) + fromVal;
        return ret;
    }
    public static double randomDouble(double toVal, double fromVal){
        double ret = (Math.random() * toVal) + fromVal;
        return ret;
    }

    public static boolean arrContains(String[] array, String string){
        for(String e: array){
            if(e.equals(string)){
                return true;
            }
        }
        return false;
    }
    public static boolean arrContains(int[] array, int i){
        for(int e: array){
            if(e == i){
                return true;
            }
        }
        return false;
    }
    public static boolean arrContains(double[] array, double d){
        for(double e: array){
            if(e == d){
                return true;
            }
        }
        return false;
    }
}
