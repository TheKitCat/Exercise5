package beans;

import java.text.DecimalFormat;
import javax.ejb.Stateless;

/**
 * Class for tax calculation on local level, by implementing the appropriate interface.
 * @author katharina
 */
@Stateless
public class TaxCalcLocalBean implements ITaxCalcLocal {

    /**
     * Tax calculation method
     *
     * @param amount float The net amount
     * @param tax float The tax in percentage
     * @return Double The total amount
     */
    public Double calcTax(Float amount, Float tax) {
        double res = amount * ((tax + 100) / 100);
        // round 2 digits
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(res));
    }
}
