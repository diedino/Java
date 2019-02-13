import java.util.Arrays;

public class ShortestWord_2 {
    public static int findShort(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(String::length).min().getAsInt();
    }

    public static void main(String[] args){
    	System.out.println(findShort(args[0]));
    }
}