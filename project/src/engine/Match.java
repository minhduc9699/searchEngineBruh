package engine;

public class Match implements Comparable<Match>{
    private int freq;
    private int firstIndex;
    private Doc d;
    private Word w;

    /*
        Compare this with another Match object by the first index. This method obeys
    the standard behavior specified by Java. Match object A is greater than Match
    object B if the first index of A is greater than the first index of B.
     */
    @Override
    public int compareTo(Match o) {
        return 0;
    }

    /*
        A constructor to initialize a Match object with the document, the word, the
    frequency of the word in the document and the first position of the word in the
    document.
     */
    public Match(Doc d, Word w, int freq, int firstIndex) {
        this.d = d;
        this.w = w;
        this.freq = freq;
        this.firstIndex = firstIndex;
    }

    /*
    Returns the frequency of the match (as explained above).
     */
    public int getFreq() {
        return this.freq;
    }

    /*
    Returns the first index of the match (as explained above).
     */
    public int getFirstIndex() {
        return this.firstIndex;
    }

    public Word getWord() {
        return this.w;
    }
}
