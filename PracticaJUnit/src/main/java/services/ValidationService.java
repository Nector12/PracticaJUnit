package services;

import kiosk.ActivationCard;

/**
 *
 * @author rav3
 */
/**
 * Local service for validating activation cards
 */
public interface ValidationService {

    boolean validate(ActivationCard card);
    void deactivate(ActivationCard card);
    
}
