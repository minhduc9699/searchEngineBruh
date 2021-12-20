package engine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    public Engine () {}

    /*
    Loads the documents from the docs folder and returns the number of documents
    loaded. Refer to the Doc class for more information about a Doc object.
     */
    public int loadDocs(String folderName) {
        File folder = new File("docs");
        return folder.list().length;
    }

    //Returns an array of documents in the original order.
    public Doc[] getDocs() {
        return new Doc[1];
    }

    /*
    Performs the search function of the engine. Returns a list of sorted search
    results. Refer to the classes above to know the expected search results.
     */
    public List<Result> search(Query q) {
        List<Result> results = new ArrayList<>();
        return results;
    }

    /*
        Converts a list of search results into HTML format. The output of this method is
    the output of Result.htmlHighlight() combined together (without any
    delimiter). Refer to the 3rd line of the file testCases.html for a specific example
     */
    public String htmlResult(List<Result> results) {
        return "";
    }

}
