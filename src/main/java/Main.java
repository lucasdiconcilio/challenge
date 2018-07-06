import files.Reader;
import files.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Main {
    public static void main(String[] args) throws IOException {

        WatchService watcher = FileSystems.getDefault().newWatchService();
        WatchKey key;
        try {
            callReader();
            key = watcher.take(); // blocking call, similar to sleep()
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void callReader() throws IOException {
        File folder = new File("/home/ilegra0331/data/in");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Reader reader = new Reader(listOfFiles[i]);
                reader.analyser();
            }
            Writer.writeOutputFile();
        }

    }
}
