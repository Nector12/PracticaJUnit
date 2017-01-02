package mocks;

import kiosk.ActivationCard;
import services.ValidationService;

/**
 *
 * @author rav3
 */
public class ForbiddenValidationService implements ValidationService {

    @Override
    public boolean validate(ActivationCard card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deactivate(ActivationCard card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
