import java.io.*;
import java.util.*;

public class NumberInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; scanner.hasNext() == true; i++) {
            System.out.println(i + " " + scanner.nextLine());
        }
    }
}
