package mocks;

import data.Vote;
import java.util.List;
import services.VotesDB;

/**
 *
 * @author rav3
 */
/**
 * Mock of VotesDB
 * Used to test if the correct Vote is registered
 */
public class VotesDBFake implements VotesDB {

    public Vote lastVote;
    public int nVotes = 0;

    @Override
    public void registerVote(Vote vote) {
        this.lastVote = vote;
        this.nVotes++;
    }

    @Override
    public List<Vote> getVotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
