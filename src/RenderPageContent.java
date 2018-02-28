import java.util.Scanner;
import java.net.URL;
import java.io.*;

public class RenderPageContent {

/*
*Принимает строку, сверяет с шаблоном.
 */
    private static boolean readPage (String url) throws IOException {
        String line;
        if (url.matches("^(?:https?://)(?:(?:\\w+)\\.)+(?:\\w){2,3}[A-Za-z0-9.,\\-%/;_]*")) {
            URL link = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(link.openStream())
            );
            while ((line=in.readLine())!=null) {
                System.out.println(line);
            }
            in.close();
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        for (;;) {
            System.out.println("Please enter link or 'q' for exit: ");
            input = scanner.nextLine();
            try {
                if ((input.equals("q")) || (readPage(input)))  {break;}
            } catch (IOException mf) {
                mf.printStackTrace();
            }
        }
    }

}
