import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHasher {
    public static void main(String[] args) throws IOException {
        File f = new File("./JavaFileSystem");
        f.mkdir();

        File notes = new File("./JavaFileSystem/notes.txt");
        FileWriter writer = new FileWriter(notes);
        writer.write("These are some of the best notes I've ever written");
        writer.close();
        
        File data = new File("./JavaFileSystem/data.txt");
        writer = new FileWriter(data);
        writer.write("Man take a look at all of this data");
        writer.close();

        File log = new File("./JavaFileSystem/log.txt");
        writer = new FileWriter(log);
        writer.write("Whatever you were doing before really sucked");
        writer.close();
    }
}