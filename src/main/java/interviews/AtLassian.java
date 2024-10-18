package interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */

class VotingForm {
    String[] candidates;
    VotingForm(int maxLimit) {
        candidates = new String[maxLimit];
    }
    public void casteVote(String[] input) {
        if(input.length > this.candidates.length) {
            throw new RuntimeException(input.length + "is exceeding max limit " + this.candidates.length);
        }
        candidates = input;
    }

}

// name, score
// Map (Key, Value)

class Pair {
    String name;
    Integer score;
    Pair(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
}

public class AtLassian {

    Map<String, Integer> votingScoreMap = new HashMap<>();

    public List<String> getResults(List<VotingForm> votingForms) {

        for(VotingForm votingForm: votingForms) {
            int score = 1000;

            for (int i = 0; i < votingForm.candidates.length; i++) {
                String candidateName = votingForm.candidates[i];

                votingScoreMap.computeIfAbsent(candidateName, k -> 0);

                votingScoreMap.put(candidateName, votingScoreMap.get(candidateName) + score--);
            }
        }

        List<Pair> candidateWithScores = new ArrayList<>();
        for(Map.Entry<String, Integer> e: votingScoreMap.entrySet()) {
            candidateWithScores.add(new Pair(e.getKey(), e.getValue()));
        }

        candidateWithScores.sort(Comparator.comparingInt(p -> -p.score));

        return candidateWithScores.stream().map((p) -> p.name).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        int maxLimit = 3;
        VotingForm votingForm1 = new VotingForm(maxLimit);
        votingForm1.casteVote(new String[] {"c1", "c2", "c3"});
        VotingForm votingForm2 = new VotingForm(maxLimit);

        votingForm2.casteVote(new String[] {"c2", "c4", "c3"});

        VotingForm votingForm3 = new VotingForm(maxLimit);
        votingForm3.casteVote(new String[] {"c5", "c2", "c3"});

        List<VotingForm> list= new ArrayList<>();
        list.add(votingForm1);
        list.add(votingForm2);
        list.add(votingForm3);
        AtLassian atLassian = new AtLassian();

        List<String> result =  atLassian.getResults(list);
        for (String name: result) {
            System.out.printf(name + " ");
        }
    }
}
