package kiosk;

import data.IrisScan;
import java.util.Optional;

/**
 *
 * @author rav3
 */
public class ActivationCard {
    
    private String activationCode;
    private boolean active;
    private Optional<IrisScan> irisScan;  

    public ActivationCard(String activationCode) {
        this.activationCode = activationCode;
        this.active = true;
        this.irisScan = Optional.empty();
    }

    public void setIrisScan(IrisScan irisScan) {
        this.irisScan = Optional.of(irisScan);
    }

    public Optional<IrisScan> getIrisScan() {
        return irisScan;
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
