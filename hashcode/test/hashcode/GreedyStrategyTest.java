package hashcode;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class GreedyStrategyTest {

    private InputParser parser = null;
    private File file = null;


    @Test
    public void solveExample() {

        file = new File("resource/a_example.txt");

        parser = new InputParser(file);

        List<Photo> inputs = parser.parse();

        GreedyStrategy strategy = new GreedyStrategy(inputs);

        SlidesShow slidesShow = strategy.solve();

        saveResult(slidesShow.toString(), "a.out");
    }


    @Test
    public void solveB() {

        file = new File("resource/b_lovely_landscapes.txt");

        parser = new InputParser(file);

        List<Photo> inputs = parser.parse();

        GreedyStrategy strategy = new GreedyStrategy(inputs);

        SlidesShow slidesShow = strategy.solve();

        saveResult(slidesShow.toString(), "b.out");
    }

    @Test
    public void solveC() {

        file = new File("resource/c_memorable_moments.txt");

        parser = new InputParser(file);

        List<Photo> inputs = parser.parse();

        GreedyStrategy strategy = new GreedyStrategy(inputs);

        SlidesShow slidesShow = strategy.solve();

        saveResult(slidesShow.toString(), "c.out");
    }

    @Test
    public void solveD() {

        file = new File("resource/d_pet_pictures.txt");

        parser = new InputParser(file);

        List<Photo> inputs = parser.parse();

        GreedyStrategy strategy = new GreedyStrategy(inputs);

        SlidesShow slidesShow = strategy.solve();

        saveResult(slidesShow.toString(), "d.out");
    }

    @Test
    public void solveE() {

        file = new File("resource/e_shiny_selfies.txt");

        parser = new InputParser(file);

        List<Photo> inputs = parser.parse();

        GreedyStrategy strategy = new GreedyStrategy(inputs);

        SlidesShow slidesShow = strategy.solve();



        saveResult(slidesShow.toString(), "e.out");
    }

    private void saveResult(String result, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.print(result);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}