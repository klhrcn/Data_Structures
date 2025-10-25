import java.util.*;
import java.io.*;

public class KBestCounterTester{
    public static void main(String[]args){
        KBestCounter<Integer> kBest = new KBestCounter<>(5);

        int[] exData={12,7,25,3,19,14,30,8,17,10};

        for(int num:exData){
            kBest.count(num);
            System.out.println("Counted: "+num);
        }

        List<Integer> result = kBest.kbest();

        System.out.println("Top 5 largest values sorted: "+result);
    }
}
