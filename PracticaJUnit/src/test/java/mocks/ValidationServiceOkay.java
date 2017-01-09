package mocks;

import kiosk.ActivationCard;

/**
 *
 * @author rav3
 */
/**
 * Used to test valid activationCards
 */
public class ValidationServiceOkay extends ForbiddenValidationService {

    @Override
    public boolean validate(ActivationCard card) {
        return true;
    }

    @Override
    public void deactivate(ActivationCard card) {
        card.erase();
    }
}
