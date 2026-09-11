import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class FileHasher {
    public static void main(String[] args) throws IOException {
        File f = new File("./JavaFileSystem");
        f.mkdir();

        String[] files = { "./JavaFileSystem/notes.txt", "./JavaFileSystem/data.txt", "./JavaFileSystem/log.txt" };

        writeFile(files[0], "Wow these notes are fire");
        writeFile(files[1], "Man take a look at all of this data");
        writeFile(files[2], "Whatever you were doing before really sucked");

        for (String str : files) {
            System.out.println(hashFile(str));
        }

        makeBackup(f);
    }

    private static void writeFile(String path, String content) {
        try {
            File f = new File(path);
            FileWriter writer = new FileWriter(f);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("File Creation Failed");
        }
    }

    private static void makeBackup(File directory) {
        try {
            File backup = new File("./" + directory.getName() + "/backup.txt");
            FileWriter writer = new FileWriter(backup);
            for (File file : directory.listFiles()) {
                if (file.getName().equals("backup.txt") || file.getName().equals(".DS_Store"))
                    continue;
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
        } catch (Exception e) {
        }
    }

    /**
     * Reads the file at filePath and returns its SHA-256 hash
     * as a lowercase hexadecimal string.
     */
    public static String hashFile(String filePath) throws IOException {
        StringBuilder contents = new StringBuilder();
        FileReader reader = new FileReader(filePath);
        int c;
        while ((c = reader.read()) != -1) {
            contents.append((char) (c));
        }
        reader.close();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(contents.toString().getBytes());
            return HexFormat.of().formatHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException: File could not be hashed");
        }
        return "";
    }
}