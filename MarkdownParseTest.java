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
}