import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        
        char[] ch=S.toCharArray();
        String result = "";
        while(start < end) {
            result += ch[start];
            start++;
        }
        System.out.println(result);
    }
}
