package engine;

import java.util.List;

public class Result implements Comparable<Result>{
    private List<Match> matches;
    private Doc d;

    /*
        A constructor to initialize a Result object with the related document and the list
    of matches.
     */
    public Result(Doc d, List<Match> matches) {
        this.d = d;
        this.matches = matches;
    }

    public Doc getDoc() {
        return this.d;
    }

    /*
    The method’s name explains itself.
     */
    public List<Match> getMatches() {
        return this.matches;
    }

    /*
    The method’s name explains itself.
     */
    public int getTotalFrequency() {
        return matches.stream().mapToInt(Match::getFreq).sum();
    }

    /*
    The method’s name explains itself.
     */
    public double getAverageFirstIndex() {
        int totalFrequency = getTotalFrequency();
        double averageFirstIndex = totalFrequency / matches.size();
        return averageFirstIndex;
    }

    /*
        Highlight the matched words in the document using HTML markups. For a
    matched word in the document’s title, put the tag <u> and </u> around the
    word’s text part (the <u> tag should not affect the word’s prefix and suffix). For a
    matched word in the document’s body, surround the word’s text part with the tag <b> and </b>.
     */
    public String htmlHighlight() {
        return "";
    }

    /*
        These are criteria to determine if Result A is greater than Result B
            (in descending order of priority):
             A has greater match count than B
             A has greater total frequency than B
             A has lower average first index than B
     */
    public int compareTo(Result o) {
        int matchSizeCompare = Integer.compare(this.matches.size(), o.matches.size());
        int totalFrequencyCompare = Integer.compare(this.getTotalFrequency(), o.getTotalFrequency());
        int averageFirstIndexCompare = Double.compare(this.getAverageFirstIndex(), o.getAverageFirstIndex()) * -1;
        List<int> criteriaCompares = Arrays.asList(matchSizeCompare, totalFrequencyCompare, averageFirstIndexCompare);
        for(int criteriaCompare: criteriaCompares) {
            if(criteriaCompare == 0) {
                return result;
            }
        }
    }

}
