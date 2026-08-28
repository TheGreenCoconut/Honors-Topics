import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PathFinder {
    public static void main(String[] args) {
        // 1. ABSOLUTE PATH (change this to match your actual computer's path!)
        // Mac/Linux example: "/Users/yourname/Desktop/path-activity/absolute.txt"
        // Windows WSL example:
        // "/mnt/c/Users/yourname/Desktop/path-activity/absolute.txt"
        String absolutePath = "/Users/quinnharris/Documents/Programming/Java/Honors-Topics/Initial-Install/absolute.txt";

        System.out.println("--- Reading Absolute Path ---");
        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath))) {
            System.out.println("SUCCESS: " + br.readLine());
        } catch (IOException e) {
            System.out.println("FAIL: Could not find the absolute file. Did you update the path string?");
        }

        // 2. RELATIVE PATH (looks for the file exactly where the terminal is currently
        // sitting)
        String relativePath = "relative.txt";

        System.out.println("\n--- Reading Relative Path ---");
        try (BufferedReader br = new BufferedReader(new FileReader(relativePath))) {
            System.out.println("SUCCESS: " + br.readLine());
        } catch (IOException e) {
            System.out.println("FAIL: Could not find the relative file. Are you in the right folder?");
        }
    }
}