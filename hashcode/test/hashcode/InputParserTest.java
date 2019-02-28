package hashcode;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class InputParserTest {

    private InputParser parser = null;
    private File file = null;

    @Before
    public void before() {
        file = new File("resource/a_example.txt");
        parser = new InputParser(file);
    }

    @Test
    public void parse() {

        List<Photo> inputs = parser.parse();

        assertEquals(4, inputs.size());

        String[] photo1Tags = {"cat", "beach", "sun"};
        Set<String> photo1TagSet = new HashSet<>(Arrays.asList(photo1Tags));
        assertEquals(photo1TagSet, inputs.get(0).getTags());
    }


}