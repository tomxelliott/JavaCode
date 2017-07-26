
public void squares(int a, int b) {
        String result = "";
        for(int c = a; c <= b; c++) {
            long squareRoot = (int) Math.sqrt(c);
            if(squareRoot*squareRoot == c) {
                result = result + c + " ";
            }
        }
        System.out.println(result);
    }
