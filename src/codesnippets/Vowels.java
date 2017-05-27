
/**
 *
 *
 */
public class Vowels
{
    public Vowels()
    {
      // Nothing to initialise at creation...
    }

    
    public int countVowels(String word)
    {
        int vowelCount = 0;
        char[] in = word.toCharArray();
        for(char x : in) {
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                vowelCount++;
            }
        } 
        return vowelCount;
    }
}
