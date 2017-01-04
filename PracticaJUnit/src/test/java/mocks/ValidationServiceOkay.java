package mocks;

import kiosk.ActivationCard;
import services.ValidationService;

/**
 *
 * @author rav3
 */
/**
 * Used to test valid activationCards
 */
public class ValidationServiceOkay implements ValidationService {

    @Override
    public boolean validate(ActivationCard card) {
        return true;
    }

    @Override
    public void deactivate(ActivationCard card) {
        card.erase();
    }
}
