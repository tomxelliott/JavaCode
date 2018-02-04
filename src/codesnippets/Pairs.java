class Pairs {

  public static void main(String[] args) {
    int[] a1 = new int[]{-1, -2, 4, -6, 5, 7};
    int[] a2 = new int[]{6, 3, 4, 0};

    int[] b1 = new int[]{1, 2, 4, 5, 7};
    int[] b2 = new int[]{5, 6, 3, 4, 8};

    System.out.println(pairs(a1, a2, 8));
    System.out.println(pairs(b1, b2, 9));
  }

    private static String pairs(int[] a, int[] b, int goalSum) {
      String resultString = "";
      for(int x = 0; x < a.length; x++){
          for(int y = 0; y < b.length; y++) { 
        if((a[x] + b[y]) == goalSum && resultString.equals("")) {
            resultString += a[x] + " " + b[y];
        } else if((a[x] + b[y]) == goalSum) {
          resultString += ", " + a[x] + " " + b[y]; 
        }
          }
      }


      if(resultString.equals("")) {
                return "-1";
      } else {
          return resultString;
      }
    }
}
