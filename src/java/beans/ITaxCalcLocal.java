
package beans;
import javax.ejb.Local;

/**
 * Interface class
 * @author katharina
 */
@Local
public interface ITaxCalcLocal {
    
    public Double calcTax(Float amount, Float tax);
}
