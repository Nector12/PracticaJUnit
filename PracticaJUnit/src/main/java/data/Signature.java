package data;

import java.util.Arrays;

/**
 * Describes a digital signature
 *
 * @author Nector
 */
final public class Signature {
    
    private final byte[] signature;

    public Signature(byte[] signature) {
        this.signature = signature;
    }

    public byte[] getSignature() {
        return signature;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Arrays.hashCode(this.signature);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Signature other = (Signature) obj;
        if (!Arrays.equals(this.signature, other.signature)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Signature{" + "signature=" + signature + '}';
    }
    
    
    
}
