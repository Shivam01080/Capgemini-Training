package Capg;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryDemo {

    public static void main(String[] args) {

        File dir = new File("C:\\Users\\HP\\eclipse-workspace\\Capg\\src\\Capg");

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Directory doesn't exist");
            return;
        }
        File[] javaFiles = dir.listFiles((d, name) -> name.endsWith(".java"));

        if (javaFiles == null || javaFiles.length == 0) {
            System.out.println("No Java files found.");
            return;
        }

        Arrays.sort(javaFiles, Comparator.comparingLong(File::length).reversed());
        System.out.println("Java files :");
        for (File file : javaFiles) {
            System.out.println(file.getName());
        }
        
    }
}
