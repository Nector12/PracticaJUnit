package kiosk;

import java.util.Objects;

/**
 *
 * @author rav3
 */
public class ActivationCard {
    
    private String activationCode;
    private boolean active;

    public ActivationCard(String activationCode) {
        this.activationCode = activationCode;
        this.active = true;
    }
    
    public String getCode() {
        return this.activationCode;
    }
    
    public boolean isActive() {
        return this.active;
    }
    
    public void erase() {
        this.activationCode = null;
        this.active = false;
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
        final ActivationCard other = (ActivationCard) obj;
        if (this.activationCode.equals(other.activationCode)) {
            return true;
        } else {
            return false;
        }
    }

}
