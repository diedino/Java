import java.util.Arrays;

public class ShortestWord {
    public static int findShort(String s) {
        String[] parsed = s.split(" ");
        String shortest = parsed[0];
        for (String str:parsed) {
            if (str.length() < shortest.length())
                shortest = str;
        }
        return shortest.length();
    }
    public static void main(String[] args){
    	System.out.println(findShort(args[0]));
    }
}
