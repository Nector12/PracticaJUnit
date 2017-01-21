package mocks;

import data.MailAddress;
import data.Signature;

/**
 *
 * @author rav3
 */
/**
 * Mock for MailerService Stores the mailAddress and the signature sent.
 */
public class MailerServiceFake extends ForbiddenMailerService {

    public MailAddress address;
    public Signature signature;

    @Override
    public void send(MailAddress address, Signature signature) {
        this.address = address;
        this.signature = signature;
    }

}
