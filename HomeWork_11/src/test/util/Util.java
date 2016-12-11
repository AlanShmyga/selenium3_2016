import java.util.Random;

/**
 * Created by alan on 11.12.16.
 */
public class Util {

    public static int getRandomNum(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
