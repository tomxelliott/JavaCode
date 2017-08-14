import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * The FileParser class deals with all reading and handling of data received in the CSV files.
 * Created by tomelliott on 28/07/2017.
 */
public class FileParser {

    private static final String COMMA_DELIMITER = ",";
    private List<Loans> loanList = new ArrayList<>();
    private List<InvestmentReq> fixedInvestmentReqList = new ArrayList<>();
    private List<InvestmentReq> trackerInvestmentReqList = new ArrayList<>();
    private List<FundedLoans> fundedLoansList = new ArrayList<>();


    /**
     * Creation of FilerParser object.
     * ArrayLists to be used by the object are initialised for usage.
     */
    public FileParser() {
        loanList = new ArrayList<>();
        fixedInvestmentReqList = new ArrayList<>();
        trackerInvestmentReqList = new ArrayList<>();
        fundedLoansList = new ArrayList<>();
    }

    /**
     * Read loan data contained within CSV file and add all parsed loans into ArrayList.
     * Each line of the CSV file after the line containing the headers is added based on the information provided.
     * If the Loan type declared in the CSV file is neither FIXED nor TRACKER, it is disregarded by the Reader.
     * The loans are added to the list based on their type (Fixed / Tracker).
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
                    if(loanDetails[2].equals("FIXED")) {
                        FixedLoan fixedLoan = new FixedLoan(Integer.parseInt(loanDetails[0]),
                                Integer.parseInt(loanDetails[1]),loanDetails[2],
                                Integer.parseInt(loanDetails[3]), loanDetails[4]);
                        loanList.add(fixedLoan);
                    }
                    else if(loanDetails[2].equals("TRACKER")) {
                        TrackerLoan trackerLoan = new TrackerLoan(Integer.parseInt(loanDetails[0]),
                                Integer.parseInt(loanDetails[1]),loanDetails[2],
                                Integer.parseInt(loanDetails[3]), loanDetails[4]);
                        loanList.add(trackerLoan);
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
     * Print out the Loans parsed from the loan list.
     */
    public void printLoanList() {
        for(Loans l : loanList) {
            System.out.println(l.getLoanID()+"  "+l.getLoanAmount()+"  "
                    +l.getProduct()+"  "+l.getLoanTerm()+"  "+l.getCompletedDate());
        }
    }

    /**
     * Read Investment Request data contained within CSV file and add all parsed requests into ArrayList.
     * Each line of the CSV file after the line containing the headers is added based on the information provided.
     * If the Investment Request type declared in the CSV file is neither FIXED nor TRACKER,
     * it is disregarded by the Reader.
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

    /**
     * This function iterates through the loans and attempts to match Fixed and Tracker Loans to potential investors.
     * Only loans that are fully funded are added to the ArrayList containing funded loans.
     * Loans must meet certain constraints set by Landbay in order to be approved and funded.
     */
    public void matchLoans() {
        HashMap<String, Integer> investorInformation = new HashMap<>();
        for(Loans l : loanList) {
            for(InvestmentReq fixed : fixedInvestmentReqList) {
                if(l.getLoanTerm() <= fixed.getInvestmentTerm()) {
                    if(l.getLoanAmount() >= fixed.getInvestmentAmount()
                            || l.getLoanAmount() - fixed.getInvestmentAmount() >= 0
                            && !fixed.isInvestmentMatched()) {
                        l.setLoanAmount(l.getLoanAmount() - fixed.getInvestmentAmount());
                        investorInformation.put(fixed.getInvestor(), fixed.getInvestmentAmount());
                        fixed.setInvestmentMatched(true);
                    }
                }

            }
            if(l.getLoanAmount() == 0 && l instanceof FixedLoan) {
                FundedLoans fl = new FundedLoans(l, investorInformation);
                fundedLoansList.add(fl);
            }
        }


        for(Loans l : loanList) {
            for(InvestmentReq tracker : trackerInvestmentReqList) {
                if (l.getLoanTerm() < tracker.getInvestmentTerm()) {
                    if(l.getLoanAmount() >= tracker.getInvestmentAmount()
                            || l.getLoanAmount() - tracker.getInvestmentAmount() >= 0
                            && !investorInformation.containsKey(tracker.getInvestor())) {
                        l.setLoanAmount(l.getLoanAmount() - tracker.getInvestmentAmount());
                        investorInformation.put(tracker.getInvestor(), tracker.getInvestmentAmount());
                    }
                }
            }
            if(l.getLoanAmount() == 0 && l instanceof TrackerLoan) {
                FundedLoans fl = new FundedLoans(l, investorInformation);
                fundedLoansList.add(fl);
            }
        }

     }

    /**
     * This method prints all loans that meet the constraints set by Landbay to match a loan with potential investors.
     * The Loan ID along with all investors and the amount invested are printed out.
     */
    public void printMatchedLoans() {
        for(FundedLoans fl : fundedLoansList){
            System.out.println("Loan Details:\n" + fl.getLoan() +
                    "Investors & Amount invested: " + fl.getInvestorInfo() + ".\n");
        }
    }
}
