package tman.system.peer.tman;

import common.peer.PeerAddress;
import common.peer.PeerMessage;
import java.util.ArrayList;


public class ThinkLeaderMessage extends PeerMessage
{
    private ArrayList<PeerAddress> electionGroup;

    public ThinkLeaderMessage(PeerAddress source, PeerAddress destination, ArrayList<PeerAddress> electionGroup) {
        super(source, destination);
        this.electionGroup = electionGroup;
    }

    public ArrayList<PeerAddress> getElectionGroup() {
        return electionGroup;
    }
}
