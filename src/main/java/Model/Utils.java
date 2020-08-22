package Model;

import java.util.Random;

public class Utils {

    public int getIntBetween( int bottom, int top){
        Random random = new Random();
        return random.nextInt(top - bottom + 1) + bottom;
    }


}
