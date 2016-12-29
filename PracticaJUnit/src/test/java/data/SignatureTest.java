package data;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rav3
 */
public class SignatureTest {
    
    public SignatureTest() {
    }

    /**
     * Test of hashCode method, of class Signature.
     */
    @Test
    public void same_hashcode_for_equal_signatures() {
        byte[] signatureBytes = new byte[10];
        new Random().nextBytes(signatureBytes);
        Signature signature = new Signature(signatureBytes);
        Signature sameSignature = new Signature(signatureBytes);
        assertEquals(signature.hashCode(), sameSignature.hashCode());
    }

    /**
     * Test of equals method, of class Signature.
     */
    @Test
    public void testEquals() {
        byte[] signatureBytes = new byte[10];
        new Random().nextBytes(signatureBytes);
        Signature signature = new Signature(signatureBytes);
        Signature sameSignature = new Signature(signatureBytes);
        assertTrue(signature.equals(sameSignature));
    }
    
}
