package engine;

public class Doc {
    private String doc;
    private String title;
    private String body;

    public Doc (String doc) {
        this.doc = doc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
