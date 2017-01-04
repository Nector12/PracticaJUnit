
package mocks;

import kiosk.ActivationCard;
import services.ValidationService;

/**
 *
 * @author rav3
 */
/**
 * Used to test Invalid activationCards
 */
public class ValidationServiceWrong implements ValidationService {

    @Override
        public boolean validate(ActivationCard card) {
            return false;
        }

        @Override
        public void deactivate(ActivationCard card) {
            card.erase();
        }
    
}
