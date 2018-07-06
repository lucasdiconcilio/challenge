package files;

import java.io.*;

public class Writer {

    public static void writeOutputFile()
            throws IOException {

        PrintWriter writer = new PrintWriter("/home/ilegra0331/data/out/the-file-name.txt", "UTF-8");
        writer.println("Resume of analysed data");
        writer.println("Number of salesman is " + Reader.getNumberOfSalesMan());
        writer.close();
    }
}
