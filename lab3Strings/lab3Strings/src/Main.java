
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("output.txt");
        String line;
        int k;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            k = scanner.nextInt();
            fileWriter.write(replaceKthLetter(line, k));
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    private static String replaceKthLetter(String line, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = line.split(" ");
        for (String word : words) {
            if (word.length() >= k) {
                stringBuilder.append(word, 0, k - 1);
                stringBuilder.append("*");
                stringBuilder.append(word.substring(k));
            } else {
                stringBuilder.append(word);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
