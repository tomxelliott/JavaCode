import java.io.*;
import java.util.*;

public class Stairs {

    public static void main(String[] args) {
        int n = 5;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <n ; i++)
            builder.append(" ");
        int j = 0;

        for (int i = 1; i <=n; i++) {
            builder.replace(builder.length()-i,
                    builder.length() - j, "#");
            System.out.println(builder);
            j++;
        }
    }
}
