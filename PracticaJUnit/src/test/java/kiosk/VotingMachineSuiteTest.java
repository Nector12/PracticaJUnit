package kiosk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author rav3
 */
/**
 * Test suite designed to run all test related to VotingMachine
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({VotingMachineActivateEmisionTests.class,
    VotingMachineCanVoteTests.class,
    VotingMachineVoteTests.class,
    VotingMachineSendReceiptTests.class})
public class VotingMachineSuiteTest {

}
