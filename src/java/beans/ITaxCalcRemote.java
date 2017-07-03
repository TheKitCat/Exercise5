
package beans;

import javax.ejb.Remote;

/**
 * Interface class for remote bean
 * @author katharina
 */
@Remote
public interface ITaxCalcRemote {
    
    public Double calcTax(Float amount, Float tax);
    
}
