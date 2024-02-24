public class TrekkerMath {
    
    public static int randomInt(int toVal, int fromVal){
        int ret = (int)(Math.random() * toVal) + fromVal;
        return ret;
    }
    public static double randomDouble(double toVal, double fromVal){
        double ret = (Math.random() * toVal) + fromVal;
        return ret;
    }

}
