
package beans;

import java.util.List;
import javax.ejb.Remote;

/**
 * 
 * @author katharina
 */
@Remote
public interface IMarketBasketBean {
    
    public List<String> addContent(String input);
    
}
