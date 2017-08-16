import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by tomelliott on 28/07/2017.
 */
public class FileParserAlt {

    private static final String COMMA_DELIMITER = ",";
    private List<Loans> loanList = new ArrayList<>();
    private List<InvestmentReq> fixedInvestmentReqList = new ArrayList<>();
    private List<InvestmentReq> trackerInvestmentReqList = new ArrayList<>();
    private List<FundedLoans> fundedLoansList = new ArrayList<>();

    public FileParserAlt() {
        loanList = new ArrayList<>();
        fixedInvestmentReqList = new ArrayList<>();
        trackerInvestmentReqList = new ArrayList<>();
        fundedLoansList = new ArrayList<>();
    }

    /**
     *
     */
    public void parseLoanData() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("loans.csv"));

            //Skip over the first line containing the headers.
            String line = "";

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] loanDetails = line.split(COMMA_DELIMITER);

                if(loanDetails.length > 0 ) {
                    Loans loan = new Loans(Integer.parseInt(loanDetails[0]),
                            Integer.parseInt(loanDetails[1]),loanDetails[2],
                            Integer.parseInt(loanDetails[3]), loanDetails[4]);
                    loanList.add(loan);
                }
            }
        }
        catch(Exception ee) {
            ee.printStackTrace();
        }
        finally {
            try {
                br.close();
            }
            catch(IOException ie) {
                System.out.println("Error occurred while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
    }

    /**
     * Print out the Loans parsed from the loan list.
     */
    public void printLoanList() {
        for(Loans l : loanList) {
            System.out.println(l.getLoanID()+"  "+l.getLoanAmount()+"  "
                    +l.getProduct()+"  "+l.getLoanTerm()+"  "+l.getCompletedDate());
        }
    }

    /**
     *
     */
    public void parseInvestmentRequests() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("investmentRequests.csv"));

            String line = "";

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] investmentRequests = line.split(COMMA_DELIMITER);

                if(investmentRequests.length > 0 ) {
                    if(investmentRequests[2].equals("FIXED")) {
                    InvestmentReq ir = new InvestmentReq(investmentRequests[0],
                            Integer.parseInt(investmentRequests[1]),investmentRequests[2],
                            Integer.parseInt(investmentRequests[3]));
                    fixedInvestmentReqList.add(ir);
                    }
                    else if(investmentRequests[2].equals("TRACKER")) {
                        InvestmentReq ir = new InvestmentReq(investmentRequests[0],
                                Integer.parseInt(investmentRequests[1]),investmentRequests[2],
                                Integer.parseInt(investmentRequests[3]));
                        trackerInvestmentReqList.add(ir);
                    }
                }
            }
        }
        catch(Exception ee) {
            ee.printStackTrace();
        }
        finally {
            try {
                br.close();
            }
            catch(IOException ie) {
                System.out.println("Error occurred while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
    }

    /**
     * Print out the investments parsed from the Investment Request file.
     */
    public void printInvestmentReqList() {
        for(InvestmentReq invReq : fixedInvestmentReqList) {
            System.out.println(invReq.getInvestor()+"  "+invReq.getInvestmentAmount()+"  "
                    +invReq.getProductType()+"  "+invReq.getInvestmentTerm());
        }
        System.out.println();
        for(InvestmentReq invReq : trackerInvestmentReqList) {
            System.out.println(invReq.getInvestor()+"  "+invReq.getInvestmentAmount()+"  "
                    +invReq.getProductType()+"  "+invReq.getInvestmentTerm());
        }
    }



    public void loanMatch() {
        for(Loans l : loanList) {
            HashMap<String, Integer> investorInformation = new HashMap<>();
            for(InvestmentReq fixed : fixedInvestmentReqList) {
                if(l.getLoanTerm() <= fixed.getInvestmentTerm()) {
                    if(l.getLoanAmount() >= fixed.getInvestmentAmount()
                            || l.getLoanAmount() - fixed.getInvestmentAmount() >= 0
                            && !investorInformation.containsKey(fixed.getInvestor())) {
                        l.setLoanAmount(l.getLoanAmount() - fixed.getInvestmentAmount());
                        investorInformation.put(fixed.getInvestor(), fixed.getInvestmentAmount());
                    }
                    //if(l.getLoanAmount() == 0) {
                    FundedLoans fl = new FundedLoans(l, investorInformation);
                    fundedLoansList.add(fl);
                }

            }

        }


        for(Loans l : loanList) {
            List<String> investorNames = new ArrayList<>();
            for(InvestmentReq tracker : trackerInvestmentReqList) {
                if (l.getLoanTerm() < tracker.getInvestmentTerm()) {

                }
            }
        }

        /*
        Once the program has run, the program must output the loans that are fully funded,
        the names of the people funding the loans and the amount of money they
        have invested in the loan.*/
    }

    public void printMatchedLoans() {
        for(FundedLoans fl : fundedLoansList){
            System.out.println("Loan Details:\n" + fl.getLoan() +
                    "Investors & Amount invested: " + fl.getInvestorInfo() + ".\n");
        }
    }
}
