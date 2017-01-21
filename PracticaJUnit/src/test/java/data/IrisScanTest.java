package data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rav3
 */
public class IrisScanTest {

    public IrisScanTest() {
    }
    
    /**
     * Test of hashCode method, of class IrisScan.
     */
    @Test
    public void sameHashcodeForEqualAddresses() {
        IrisScan iris = new IrisScan(new byte[]{1,2,3});
        IrisScan sameIris = new IrisScan(new byte[]{1,2,3});
        assertEquals(iris.hashCode(), sameIris.hashCode());
    }
    
    @Test
    public void testEquals() {
        IrisScan iris = new IrisScan(new byte[]{1,2,3});
        IrisScan sameIris = new IrisScan(new byte[]{1,2,3});
        assertTrue(iris.equals(sameIris));
    }

}
