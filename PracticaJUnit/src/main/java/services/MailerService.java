package services;

import data.MailAddress;
import data.Signature;

/**
 *
 * @author rav3
 */
/**
 * External service for sending mails
 */
public interface MailerService {

    void send(MailAddress address, Signature signature);
    
}
