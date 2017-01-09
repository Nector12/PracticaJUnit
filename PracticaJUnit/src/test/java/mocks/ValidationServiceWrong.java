package mocks;

import kiosk.ActivationCard;

/**
 *
 * @author rav3
 */
/**
 * Used to test invalid activationCards
 */
public class ValidationServiceWrong extends ForbiddenValidationService {

    @Override
    public boolean validate(ActivationCard card) {
        return false;
    }

}
