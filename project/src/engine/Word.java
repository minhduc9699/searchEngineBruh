package engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Word {
    //A set of stop words loaded by the loadStopWords() method.
    public static Set<String> stopWords = new HashSet<String>();
    private String suffix = "";
    private String prefix = "";
    private String text;

    public Word(String raw) {
        String str = raw;
        if (isKeyword()) {
            char[] cA = str.toCharArray();
            if (!Character.isAlphabetic(cA[0])) {
                this.prefix = str.substring(0,1);
                str = str.replace(this.prefix, "");
            }
            if (!Character.isAlphabetic(cA[cA.length-1])) {
                this.suffix = str.substring(str.length() - 1);
                this.str = str.replace(this.suffix, "");
            } else if (!Character.isAlphabetic(cA[cA.length - 2])) {
                this.suffix = str.substring(str.length() - 2);
                this.str = str.replace(this.suffix, "");
            }
        }
        this.text = str;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getPrefix() {
        return this.prefix;
    }

    //Returns true if the word is a keyword.
    boolean isKeyword() {
        if (raw.isEmpty()) return false;
        if (raw.chars().anyMatch(Character::isDigit)) return false;
        if (raw.chars().noneMatch(Character::isAlphabetic)) return false;
        if (raw.chars().anyMatch(x -> x == ' ')) return false;
        if (stopWords.contains(raw)) return false;
        return true;
    }

    //Returns the text part of the word.
    public String getText() {
        return this.text;
    }

    //Two words are considered equal if their text parts are equal, case-insensitively.
    public boolean equals(Object o) {
        Word w = (Word) o;
        return this.text.equalsIgnoreCase(w.getText());
    }

    //Returns the raw text of the word.
    public String toString() {
        return this.prefix + this.text + this.suffix;
    }

    //Construct and return a complete Word object from raw text.
    public static Word createWord(String raw) {
        return new Word(raw);
    }

    //Load stop words into the set Word.stopWords from the text file stopwords.txt at
    //the project’s root directory.
    public static boolean loadStopWords(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stopWords.add(line);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
