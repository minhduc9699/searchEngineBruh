package engine;

import java.util.ArrayList;
import java.util.List;

public class Query {
    private String searchPhrase;
    private String keywords;

    /*
        A constructor which receives the raw search phrase from user, then extract only
    keywords from it.
     */
    public Query(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    /*
        Returns a list of the query’s keywords in the same order as they appear in the
    raw search phrase.
     */
    public List<Word> getKeywords() {
        List keyWordList = new ArrayList<>();
        return keyWordList;
    }

    /*
        Returns a list of matches againt the input document. Sort matches by position
    where the keyword first appears in the document. See the Match class for more
    information about search matches.
     */
    public List<Match> matchAgainst(Doc d) {
        List matchList = new ArrayList<>();
        return matchList;
    }


}
