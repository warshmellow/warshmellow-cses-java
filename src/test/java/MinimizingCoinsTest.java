import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MinimizingCoinsTest {
    @Test
    public void solve() throws IOException {
        // CHANGE ME
        String testName = "minimizingCoinsTest/";
        MinimizingCoins.Task solver = new MinimizingCoins.Task();
        MinimizingCoins.InputReader in;
        int linesPerTest = 2;
        // END CHANGE ME

        String testResourcesRoot = "src/test/resources/";
        String testResourcesPath = testResourcesRoot + testName;

        String inputFile = testResourcesPath + "input.txt";
        String resultFile = testResourcesPath + "result.txt";
        String expectedfile = testResourcesPath + "expected.txt";

        in = new MinimizingCoins.InputReader(new FileInputStream(inputFile));
        OutputStream outputStream = new FileOutputStream(resultFile);
        PrintWriter out = new PrintWriter(outputStream);

        int testNumber = Files.readAllLines(Paths.get(inputFile)).size() / linesPerTest;

        for (int i = 0; i < testNumber; i++) {
            solver.solve(i, in, out);
        }
        out.close();

        List<String> allLines = Files.readAllLines(Paths.get(resultFile));
        List<String> expectedLines = Files.readAllLines(Paths.get(expectedfile));

        for (Integer i = 0; i < allLines.size(); i++) {
            Integer curr = i + 1;
            assertEquals("Test case " + curr.toString() + " failed", expectedLines.get(i), allLines.get(i));
        }
    }
}
