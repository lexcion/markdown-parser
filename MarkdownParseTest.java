import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void markdownTestFile1() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
        links = parse.getLinks(Files.readString(Path.of("test-file.md")));
        assertEquals(links.size(), 2);
        assertEquals(links.get(0), "https://something.com");
        
        assertEquals(links.get(1), "some-thing.html");
    }

    @Test
    public void markdownTestFile2() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
    links = parse.getLinks(Files.readString(Path.of("test-file-2.md")));
        assertEquals(links.size(), 2);
        assertEquals(links.get(0), "https://something.com");
        assertEquals(links.get(1), "some-thing.html");
    }

    @Test
    public void markdownTestFile3() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
    links = parse.getLinks(Files.readString(Path.of("test-file-3.md")));
        assertEquals(links.size(), 1);
        assertEquals(links.get(0), "some-thing.html");
    }

    @Test
    public void markdownTestFile4() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
    links = parse.getLinks(Files.readString(Path.of("test-file-4.md")));
        assertEquals(links.size(), 1);
        assertEquals(links.get(0), "https://something.com");
    }

    @Test
    public void markdownTestFile5() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
    links = parse.getLinks(Files.readString(Path.of("test-file-5.md")));
        assertEquals(links.size(), 2);
        assertEquals(links.get(0), "https://something.com");
        assertEquals(links.get(1), "some-thing.html");


          
    }

    @Test
    public void markdownTestSnippet1() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
        links = parse.getLinks(Files.readString(Path.of("labreport4tests/snippet1.md")));
     
        ArrayList<String> expected = new ArrayList<>(3);
        expected.add("`google.com");  expected.add("google.com");  expected.add("ucsd.edu"); 

        assertEquals(expected, links);
    }

    @Test
    public void markdownTestSnippet2() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
        links = parse.getLinks(Files.readString(Path.of("labreport4tests/snippet2.md")));

        ArrayList<String> expected = new ArrayList<>(3);
        expected.add("a.com");  expected.add("");  expected.add("example.com"); 
        
        assertEquals(expected, links);


          
    }

    @Test
    public void markdownTestSnippet3() throws IOException{
        MarkdownParse parse = new MarkdownParse();
        ArrayList<String> links;
        
        links = parse.getLinks(Files.readString(Path.of("labreport4tests/snippet3.md")));
     
        ArrayList<String> expected = new ArrayList<>(3);
        expected.add("https://www.twitter.com");  expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");  expected.add("https://cse.ucsd.edu/"); 

        assertEquals(expected, links);
          
    }
}

/*
javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
*/