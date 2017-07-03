package beans;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * A simple singleton bean, which implements a counter
 * @author katharina
 */
@Singleton
@LocalBean
@Lock(LockType.READ)
public class SingletonCounter {
    private int count = 0; //init
    
    /**
     * Increments the counter value
     * If the state changes, all methods are locked for other clients
     */
    @Lock(LockType.WRITE)
    public void increment(){
        count++;
    }
    
    /**
     * 
     * @return      The count value
     */
    public int getCount(){
        return count;
    }
}
