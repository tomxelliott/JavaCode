class BinaryInt {
    public static void main(String[] args) {
		System.out.println(binaryToInt(11001100));
    }

    public static int binaryToInt(int binaryNo) {
		String number = String.valueOf(binaryNo);
		char[] chars = number.toCharArray();

		int result = 0;
		if(chars.length != 8) { 
		    System.out.println("Please enter only 8 bit long numbers!");
		}
	    int x = 0;
	    int binaryMultiplier = 128;
	    while(x < chars.length) {
			if(String.valueOf(chars[x]).contains("0") || String.valueOf(chars[x]).contains("1")) {
			    result = result + (Integer.parseInt(String.valueOf(chars[x])) * binaryMultiplier); 
			} else {
				System.out.println("This function only accepts binary numbers");

	    	}
			binaryMultiplier /= 2;
			x++;
	    }
	    return result;
    }
}
