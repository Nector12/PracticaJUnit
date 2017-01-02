
package mocks;

import data.Vote;
import java.util.List;
import services.VotesDB;

/**
 *
 * @author rav3
 */
public class ForbiddenVotesDB implements VotesDB {

    @Override
    public void registerVote(Vote vote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vote> getVotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
