/**
 * Parent class for Loans parsed from Landbay data.
 *
 * The base Loan information is contained within this class and any further
 * specific information will be contained within the subclasses.
 *
 * Created by tomelliott on 28/07/2017.
 */

public class Loans {

    private int loanID;
    private int loanAmount;
    private String product;
    private int loanTerm;
    private String completedDate;

    public Loans(int loanID, int loanAmount, String product,
                 int loanTerm, String completedDate) {
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.product = product;
        this.loanTerm = loanTerm;
        this.completedDate = completedDate;
    }

    /**
     * Getter method to return the loan ID.
     * @return
     */
    public int getLoanID() {
        return loanID;
    }

    /**
     * Setter method to alter the loan ID.
     * @param loanID
     */
    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    /**
     * Getter method to return the integer value for the loan amount.
     * @return
     */
    public int getLoanAmount() {
        return loanAmount;
    }

    /**
     * Setter method to alter the loan amount.
     * @param loanAmount
     */
    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Getter method to return the product type.
     * @return
     */
    public String getProduct() {
        return product;
    }

    /**
     * Setter method to alter the product type.
     * @param product
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Getter method to return the loan term.
     * @return
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * Setter method to alter the loan term.
     * @param loanTerm
     */
    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    /**
     * Getter method to return the completed date of the loan.
     * @return
     */
    public String getCompletedDate() {
        return completedDate;
    }

    /**
     * Setter method to alter the completed date of the loan.
     * @param completedDate
     */
    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    @Override
    /**
     * Print a String representation of the Loan.
     * This method is being used to print out the loan details of the matched loans.
     * @return Details of the loan that are stored in the object fields.
     */
    public String toString() {
        return "Loan ID: " +  loanID + "\n";
                //+ "Loan Amount: " + loanAmount + "\n";
                //+ "Product: " + product + "\n" +
                //"Loan Term: " + loanTerm + "\n" +
                //"Completed Date: " + completedDate + "\n";
    }
}
