import java.util.*;
class UniqueString {

    public static void main(String[] args) {
        System.out.println(uniqueChars("helog"));
        System.out.println(uniqueChars("testv"));
    }

    public static boolean uniqueChars(String input) {
        char[] array = input.toCharArray();
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] == array[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
