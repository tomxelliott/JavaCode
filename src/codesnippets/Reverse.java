import java.util.*;

public class Reverse
{
    public Reverse()
    {
        // Nothing to be initialised at creation...
    }

    public String reverseString(String x)
    {
        char[] in = x.toCharArray();
        int begin = 0;
        int end = in.length-1;
        char temp;
        while(end > begin){
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
    
    public int numberOfLetters(String y) 
    {
        char[] in = y.toCharArray();
        int numberOfLetters = 0;
        for(int x = 0; x < in.length; x++) {
            numberOfLetters++;
        }
        return numberOfLetters;
    }
    
    public int numberOfWords(String z)
    {
        char[] in = z.toCharArray();
        int numberOfWords = 0;
        for(char c : in) {
            if(Character.isWhitespace(c)) {
                numberOfWords++;
            }
        }
        if(numberOfWords > 0) {
            numberOfWords++;
        }
        return numberOfWords;
    }
}
