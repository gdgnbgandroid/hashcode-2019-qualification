package hashcode;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class InputParserTest {

    private InputParser parser = null;
    private File file = null;

    @Before
    public void before() {
        file = new File("resource/example.in");
        parser = new InputParser(file);
    }

    @Test
    public void parse() {
        parser.parse();
    }
}