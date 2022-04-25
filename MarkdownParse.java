//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
// import static org.junit.Assert.*;
// import org.junit.*;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openParen1 = markdown.indexOf("[", currentIndex);
            int closeParen1 = markdown.indexOf("]", openParen1);
            int OpenParen2 = markdown.indexOf("(", closeParen1);
            int closeParen2 = markdown.indexOf(")", OpenParen2);
            toReturn.add(markdown.substring(OpenParen2 + 1, closeParen2));
            currentIndex = closeParen2 + 1;
            if (currentIndex == markdown.length()-1) {
                break;
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}





