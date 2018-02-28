import java.util.Scanner;
import java.net.URL;
import java.io.*;

public class RenderPageContent {

    private static boolean readPage (String url) {
        if (url.matches("^(?:https?://)(?:(?:\\w+)\\.)+(?:\\w){2,3}[A-Za-z0-9.,\\-%/;_]*")) {
            try {
                URL link = new URL(url);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(link.openStream())
                );
                printSite(in);
            } catch (IOException mf) {
                mf.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    private static void printSite (BufferedReader bufferedReader) throws IOException{
        String line;
        while ((line=bufferedReader.readLine())!=null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        for (;;) {
            System.out.println("Please enter link or 'q' for exit: ");
            input = scanner.nextLine();
            if (input.equals("q")) {break;}
            if (readPage(input)) {break;}
        }
    }

}
