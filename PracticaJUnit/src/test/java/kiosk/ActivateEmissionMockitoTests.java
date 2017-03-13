package kiosk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import services.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Nector on 3/13/2017.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class ActivateEmissionMockitoTests {

    @InjectMocks
    VotingMachine votingMachine;

    @Mock
    ValidationService validationService;
    @Mock
    IrisScanner irisScanner;
    @Mock
    MailerService mailerService;
    @Mock
    SignatureService signatureService;
    @Mock
    VotePrinter votePrinter;
    @Mock
    VotesDB votesDB;

    @Test
    public void correctlyActivateEmission() {
        ActivationCard card = new ActivationCard("valid_code");
        when(validationService.validate(card)).thenReturn(true);
        votingMachine.activateEmission(card);
        assertTrue(votingMachine.canVote());
    }

}
