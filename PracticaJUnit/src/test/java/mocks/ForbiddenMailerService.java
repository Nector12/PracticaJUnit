package mocks;

import data.MailAddress;
import data.Signature;
import services.MailerService;

/**
 *
 * @author rav3
 */
public class ForbiddenMailerService implements MailerService {

    @Override
    public void send(MailAddress address, Signature signature) {
        throw new UnsupportedOperationException("Illegal operation");
    }

}
