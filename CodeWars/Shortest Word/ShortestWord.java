import java.util.Arrays;

public class Kata {
    public static int findShort(String s) {
        String[] parsed = s.split(" ");
        String shortest = parsed[0];
        for (String str:parsed) {
            if (str.length() < shortest.length())
                shortest = str;
        }
        return shortest.length();
    }
}