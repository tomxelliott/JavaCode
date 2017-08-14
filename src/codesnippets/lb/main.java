
/**
 * Created by tomelliott on 28/07/2017.
 */
public class Main {

    public static void main(String[] args) {
        FileParser fp = new FileParser();
        fp.parseLoanData();
        fp.parseInvestmentRequests();
        fp.matchLoans();
        fp.printMatchedLoans();
    }
}




//    Loans loans = new Loans(11, 1000, "FIXED", 24, "08/01/2015");
  //  InvestmentReq ir = new InvestmentReq("Tom", 1000, "FIXED", 30);
    //    System.out.println(loans.toString());
      //          System.out.println(ir.toString());
