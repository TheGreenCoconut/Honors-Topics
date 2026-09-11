import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHasher {
    public static void main(String[] args) throws IOException {
        File f = new File("./JavaFileSystem");
        f.mkdir();

        writeFile("JavaFileSystem", "notes.txt", "Wow these notes are fire");
        writeFile("JavaFileSystem", "data.txt", "Man take a look at all of this data");
        writeFile("JavaFileSystem", "log.txt", "Whatever you were doing before really sucked");

        makeBackup(f);
    }

    private static void writeFile(String directory, String file, String content) {
        try {
            File f = new File("./" + directory + "/" + file);
            FileWriter writer = new FileWriter(f);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("File Creation Failed");
        }
    }

    private static void makeBackup(File directory){
        try {
            File backup = new File("./" + directory.getName() + "/backup.txt");
            FileWriter writer = new FileWriter(backup);
            for (File file : directory.listFiles()) {
                if (file.getName().equals("backup.txt") || file.getName().equals(".DS_Store")) continue;
                System.out.println(file.getName());
                writer.write(file.getName() + ": ");
                FileReader reader = new FileReader(file);
                int c;
                while ((c = reader.read()) != -1) {
                    writer.write((char) (c));
                }
                reader.close();
                writer.write("\n");
            }   
            writer.close();
        } catch (Exception e){}
    }
}