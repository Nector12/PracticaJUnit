package data;

import java.util.Objects;

/**
 * Describes a mail address
 *
 * @author rav3
 */
final public class MailAddress {

    private final String address;

    public MailAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        return address.hashCode();
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
        final MailAddress other = (MailAddress) obj;
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MailAddress{" + "address=" + address + '}';
    }

}
