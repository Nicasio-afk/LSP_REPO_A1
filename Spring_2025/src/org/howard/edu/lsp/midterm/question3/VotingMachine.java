package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

//Represents a simple electronic voting machine.
public class VotingMachine {
    private Map<String, Integer> candidates;

    public VotingMachine() {
        candidates = new HashMap<>();
    }

    //Adds a candidate to the voting machine.
    public void addCandidate(String name) {
        if (!candidates.containsKey(name)) {
            candidates.put(name, 0);
        }
    }

    // Casts a vote for a candidate.
    public boolean castVote(String name) {
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1);
            return true;
        }
        return false;
    }

    //Returns the winner of the election.
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}