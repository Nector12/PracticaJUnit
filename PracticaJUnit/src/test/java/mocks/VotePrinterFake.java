package mocks;

import data.Vote;

/**
 *
 * @author rav3
 */
/**
 * Mock of VotePrinter service
 * Used to test if the vote is printed
 */
public class VotePrinterFake extends ForbiddenVotePrinter {

    public int printed = 0;

    @Override
    public void print(Vote vote) {
        this.printed++;
    }
    
}
