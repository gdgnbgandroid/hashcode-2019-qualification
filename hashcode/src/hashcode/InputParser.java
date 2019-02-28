package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputParser {

    private File input = null;
    private Scanner scanner = null;

    public InputParser(File in) {
        this.input = in;
        try {
            scanner = new Scanner(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void parse() {
        while(hasNext())
            System.out.println(nextLine());

    }

    private String nextLine() {
        return scanner != null && hasNext() ?  scanner.nextLine() : "";

    }

    private boolean hasNext() {
        return scanner.hasNextLine();
    }

}
