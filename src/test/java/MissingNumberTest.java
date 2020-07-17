import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class MissingNumberTest {

    @Test
    public void solve() throws IOException {
        String testResourcesRoot = "src/test/resources/";
        String testName = "missingNumberTest/";
        String testResourcesPath = testResourcesRoot + testName;

        String inputFile = testResourcesPath + "input.txt";
        String resultFile = testResourcesPath + "result.txt";
        String expectedfile = testResourcesPath + "expected.txt";

        InputStream inputStream = new FileInputStream(inputFile);
        OutputStream outputStream = new FileOutputStream(resultFile);
        MissingNumber.InputReader in = new MissingNumber.InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        MissingNumber.Task solver = new MissingNumber.Task();
        solver.solve(1, in, out);
        out.close();

        List<String> allLines = Files.readAllLines(Paths.get(resultFile));
        List<String> expectedLines = Files.readAllLines(Paths.get(expectedfile));

        for (Integer i = 0; i < allLines.size(); i++) {
            assertEquals(i.toString() + " case failed", expectedLines.get(i), allLines.get(i));
        }
    }
}