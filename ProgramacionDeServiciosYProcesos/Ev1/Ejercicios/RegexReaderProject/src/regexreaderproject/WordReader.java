package regexreaderproject;

import java.io.BufferedReader;
import java.io.Reader;

public class WordReader extends BufferedReader {

    private final String s;
    
    /**
     *
     * @param in
     * @param sz
     * @param s
     */
    public WordReader(Reader in, int sz, String s) {
        super(in, sz);
        this.s = s;
    }
    
    @Override
    public String readLine() {
        return null;
    }
}
