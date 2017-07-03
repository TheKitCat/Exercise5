
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author katharina
 */
@Stateful
public class MarketBasketBean implements IMarketBasketBean{

    private List<String> content;
    
    public MarketBasketBean(){
        this.content = new ArrayList<>();
    }
    
    @Override
    public List<String> addContent(String input){
        this.content.add(input);
        return this.content;
    }
}
