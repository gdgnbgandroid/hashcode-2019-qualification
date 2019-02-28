package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    private Scanner scanner = null;

    public InputParser(File in) {
        try {
            scanner = new Scanner(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<Photo> parse() {
        List<Photo> res = new LinkedList<>();
        int numOfInput = scanner.nextInt();
        nextLine();
        for(int i = 0; i < numOfInput; i++)
            res.add(Photo.newInstance(nextLine(), i));
        return res;

    }

    private String nextLine() {
        return scanner != null && hasNext() ?  scanner.nextLine() : "";

    }

    private boolean hasNext() {
        return scanner.hasNextLine();
    }

}
