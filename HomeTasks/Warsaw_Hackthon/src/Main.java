import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main implements Serializable{


    public static int bad(List<Integer> a, int l, int r) {
        int max_length=0;
        int minus = l;
        for (int i=l; i<r; i++) {
            while (!a.contains(i)) {
                i++;
                if (i>r) break;
            }
            if (i-1-minus >max_length) {
                System.out.println(i-1-minus);
                max_length = i - 1 - minus;
            }
            minus = i+1;
        }
        return max_length;
    }

    public static int minimumMoves(List<Integer> a, List<Integer> m) {
        int result = 0;
        for (int i=0; i< a.size(); i++) {
            while (a.get(i) > 0) {
                /*System.out.println("-----------");
                System.out.println(a.get(i)%10);
                System.out.println(m.get(i)%10);
                System.out.println("-----------");*/
                result += Math.abs((a.get(i)%10)-(m.get(i)%10));
                /*System.out.println(result);*/
                a.set(i, a.get(i)/10);
                /*System.out.println("a"+i+"="+a.get(i));*/
                m.set(i, m.get(i)/10);
            }
        }
        return result;
        //return 1;
    }

}

class A {
    public void m(Double...args) {

    }
}



enum Animals1 {
    LION, TIGER, BEAR;
}

enum Animals2 {
    LION, TIGER, BEAR;
    int weight;
}


enum Animals4 {
    LION(450), TIGER(450), BEAR;
    int weight;
    Animals4() {}
    Animals4(int w) {
        weight=w;
    }
}

class B {
    public void m(final List arg) {
        arg.add("a");
    }
}

class Tester1 {
    public static void main(String[] args) {
        B b = new B();
        List list = new ArrayList();
        b.m(list);
        for (int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}