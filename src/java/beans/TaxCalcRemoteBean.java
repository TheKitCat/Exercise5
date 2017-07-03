
package beans;

import java.text.DecimalFormat;
import javax.ejb.Stateless;

/**
 * Bean for tax calculation
 * @author katharina
 */
@Stateless
public class TaxCalcRemoteBean implements ITaxCalcRemote {


    /**
     * Tax calculation method
     *
     * @param amount float The net amount
     * @param tax float The tax in percentage
     * @return Double The total amount
     */
    @Override
    public Double calcTax(Float amount, Float tax) {
        double res = amount * ((tax + 100) / 100);
        // round 2 digits
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(res));
    }

}
