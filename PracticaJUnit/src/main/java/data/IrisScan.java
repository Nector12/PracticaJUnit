package data;

import java.util.Arrays;

/**
 * Describes the scanned iris
 * 
 * @author rav3
 */
public class IrisScan {
    
    private final byte[] irisCode;
    
    public IrisScan(byte[] irisCode) {
        this.irisCode = irisCode;
    }

    public byte[] getIrisCode() {
        return irisCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Arrays.hashCode(this.irisCode);
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
        final IrisScan other = (IrisScan) obj;
        if (!Arrays.equals(this.irisCode, other.irisCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IrisScan{" + "irisCode=" + irisCode + '}';
    }
    
}
