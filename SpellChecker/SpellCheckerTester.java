import java.util.*;
import java.io.*;

public class SpellCheckerTester{
    public static void main (String[]args){
        try{
            SpellChecker checker = new SpellChecker("words.txt");
            List<String> misspelled=checker.getIncorrectWords("test.txt");
            System.out.println("Misspelled words:");
            for (String word:misspelled){
                System.out.println("-"+word);
            
                Set<String> suggestions=checker.getSuggestions(word);
                System.out.println("Suggestions: "+suggestions);

            }

            
        }catch (IOException e){
        System.err.println("Error loading files: "+e.getMessage());
        }
    }

}