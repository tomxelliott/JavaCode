/**
 * This subclass contains any features or functionality specific to a Fixed Loan.
 *
 * At this moment in time, the Tracker Loans and Fixed Loans do not have any features
 * that distinguish themselves from one another however that will likely change in the
 * future and this can easily be implemented using this inheritance structure.
 *
 * Created by tomelliott on 30/07/2017.
 */

public class FixedLoan extends Loans {
    public FixedLoan(int loanID, int loanAmount, String product, int loanTerm, String completedDate) {
        super(loanID, loanAmount, product, loanTerm, completedDate);
    }
}
