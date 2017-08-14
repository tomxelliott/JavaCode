/**
 * Created by tomelliott on 28/07/2017.
 */
public class InvestmentReq {
    
    private String investor;
    private int investmentAmount;
    private String productType;
    private int investmentTerm;
    private boolean investmentMatched;

    public InvestmentReq(String investor, int investmentAmount,
                         String productType, int investmentTerm) {
        this.investor = investor;
        this.investmentAmount = investmentAmount;
        this.productType = productType;
        this.investmentTerm = investmentTerm;
        investmentMatched = false;
    }

    /**
     * Getter method to return the name of the investor.
     * @return The name of the investor.
     */
    public String getInvestor() {
        return investor;
    }

    /**
     * Setter method to alter the name of the investor.
     * @param investor
     */
    public void setInvestor(String investor) {
        this.investor = investor;
    }

    /**
     * Getter method to return the integer amount for the investment.
     * @return
     */
    public int getInvestmentAmount() {
        return investmentAmount;
    }

    /**
     * Setter method to alter the investment amount.
     * @param investmentAmount
     */
    public void setInvestmentAmount(int investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    /**
     * Getter method to return the name of the investment product type.
     * @return
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Setter method to alter the product type.
     * @param productType
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * Getter method to return the integer value for the term on the investment.
     * @return
     */
    public int getInvestmentTerm() {
        return investmentTerm;
    }

    /**
     * Setter method to alter the investment term.
     * @param investmentTerm
     */
    public void setInvestmentTerm(int investmentTerm) {
        this.investmentTerm = investmentTerm;
    }

    @Override
    /**
     * Print a string representation of the Investment request.
     * @return Details of the Investment Request fields.
     */
    public String toString() {
        return "Investor: " +  investor + "\n" +
                "Investment Amount: " + investmentAmount + "\n" +
                "Product Type: " + productType + "\n" +
                "Investment Term: " + investmentTerm + "\n";
    }

    /**
     *
     * @return
     */
    public boolean isInvestmentMatched() {
        return investmentMatched;
    }

    /**
     * Changes the status of whether the investment has been matched or not.
     * @param investmentMatched
     */
    public void setInvestmentMatched(boolean investmentMatched) {
        this.investmentMatched = investmentMatched;
    }
}
