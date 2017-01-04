package mocks;

import data.Vote;
import services.VotePrinter;

/**
 *
 * @author rav3
 */
/**
 * Mock of VotePrinter service
 * Used to test if the vote is printed
 */
public class VotePrinterFake implements VotePrinter {

    public int printed = 0;

    @Override
    public void print(Vote vote) {
        this.printed++;
    }
    
}
