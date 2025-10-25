import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;


public class SpellChecker implements SpellCheckerInterface{
    private Set<String> dictionary;

    private String modify(String word){
        return word.toLowerCase().replaceAll("[^a-z0-9]","");
    }

    public SpellChecker(String filename) throws IOException{
        dictionary = new HashSet<>();

        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNext()){
            String word = modify(scanner.next());
            if (!word.isEmpty()){
                dictionary.add(word);
            }
        }
        scanner.close();
    }

    private boolean containsWord(String word){
        return dictionary.contains(word);
    }

    @Override
    public List<String> getIncorrectWords(String filename){
        List<String>incorrect = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNextLine()){
                String[] split = scanner.nextLine().toLowerCase().split("\\s+");
                for (String raw:split){
                    String cleaned = modify(raw);
                    if(!cleaned.isEmpty() &&!containsWord(cleaned)){
                        incorrect.add(cleaned);
                    }
                }
            }
        }catch(IOException e){
            System.err.println("File not found: "+filename);
        }
        
        return incorrect;
    }

    @Override
    public Set<String> getSuggestions(String word){
        word=modify(word);
        Set<String> suggestions = new HashSet<>();
         
         //add character
         for(int i=0; i<=word.length(); i++){
            for (char c= 'a'; c<='z'; c++){
                String attempt = word.substring(0,i)+c+word.substring(i);
                if(containsWord(attempt)){
                    suggestions.add(attempt);
                }
            }
         }

         //remove
         for(int i=0; i<word.length();i++){
            String attempt = word.substring(0,i)+word.substring(i+1);
            if(containsWord(attempt)){
                suggestions.add(attempt);
            }
         }

         //swap 
         for (int i=0; i<word.length()-1; i++){
            char[] chars = word.toCharArray();
            char temp=chars[i];
            chars[i] = chars[i+1];
            chars[i+1]=temp;
            String attempt = new String(chars);
            if(containsWord(attempt)){
                suggestions.add(attempt);
            }
         }

         suggestions.remove(word);

         return suggestions;
    }

}
