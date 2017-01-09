package mocks;

import data.Vote;
import services.VotePrinter;

/**
 *
 * @author rav3
 */
public class ForbiddenVotePrinter implements VotePrinter {

    @Override
    public void print(Vote vote) {
        throw new UnsupportedOperationException("Illegal operation");
    }

}
