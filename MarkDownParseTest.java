import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.imageio.IIOException;

import org.junit.*;

public class MarkDownParseTest {

    @Test
    public void addition(){
        assertEquals(2,1+1);
    }

    @Test   
    public void Test1() throws IOException {
        String test= Files.readString(Path.of("test-file.md"));
        List<String> expected = List.of("https://something.com","some-thing.html");
        assertEquals(expected, MarkdownParse.getLinks(test));
    }

    @Test   
    public void Test2() throws IOException {
        String test= Files.readString(Path.of("test-file1.md"));
        List<String> expected = List.of("https://docs.google.com/document/d/1FOldotuoowWibUocRI9UkmbfTolUIUbZEYokeispdaw/edit#"
        ,"https://learn.zybooks.com/zybook/UCSDCSE12CaoSpring2022/chapter/3/section/2");
        assertEquals(expected, MarkdownParse.getLinks(test));
    }

    @Test   
    public void Test3() throws IOException {
        String test= Files.readString(Path.of("test-file2.md"));
        List<String> expected = List.of();
        assertEquals(expected, MarkdownParse.getLinks(test));
    }

    @Test   
    public void Test4() throws IOException {
        String test= Files.readString(Path.of("test-file3.md"));
        List<String> expected = List.of();
        assertEquals(expected, MarkdownParse.getLinks(test));
    }
}
