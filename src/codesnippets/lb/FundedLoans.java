import java.util.HashMap;

/**
 * Once the program has run, the program must output the loans that are fully funded,
 * the names of the people funding the loans and the amount of money they
 * have invested in the loan.
 *
 * Created by tomelliott on 29/07/2017.
 */
public class FundedLoans {

    private Loans loan;
    private HashMap<String, Integer> investorInfo;

    public FundedLoans(Loans loan, HashMap<String, Integer> investorInfo) {
        this.loan = loan;
        this.investorInfo = investorInfo;
    }

    public Loans getLoan() {
        return loan;
    }

    public HashMap<String, Integer> getInvestorInfo() {
        return investorInfo;
    }
}
