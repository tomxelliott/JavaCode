import java.util.*;
class WordCount {

    public static void main(String[] args) {
        HashMap<String,Integer> hm1 = wordCounter("this is a dog and a dog cat dog together");                                                                                                                                                                             
        for (Map.Entry<String, Integer> entry : hm1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static HashMap<String,Integer> wordCounter(String sentence) {
        HashMap<String, Integer> results = new HashMap<>();
        String[] words = sentence.split("\\s+");
        for(String s: words) {
            if(results.containsKey(s)) {
                results.put(s, results.get(s) + 1);
            } else {
                results.put(s, 1);
            }
        }
        return results;
    }

}
