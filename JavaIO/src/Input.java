import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;


public class Input {
    private Scanner scanner = new Scanner(System.in);
    private Scanner fileScanner;
    private Scanner urlScanner;
    private File file;
    private URL url;

    private void setFileScanner() throws Exception {
        this.fileScanner = new Scanner(file);
    }

    private void setUrlScanner() throws Exception {
        this.urlScanner = new Scanner(url.openStream());
    }

    public String nextString() {
        String text = scanner.nextLine();
        return text;
    }

    public int nextInt() {
        int number = scanner.nextInt();
        return number;
    }

    public void file(String filename) throws FileNotFoundException {
        try {
            this.file = new File(filename);
            setFileScanner();
        } catch (FileNotFoundException e) {
            System.out.println("file " + filename + " not found");
            throw e;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fileFromConsole() {
        System.out.println("enter filename:");
        try {
            file(nextString());
        } catch (FileNotFoundException e) {
            fileFromConsole();
        }
    }

    public void filePrint() {
        try {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void url(String address) {
        try {
            this.url = new URL(address);
            setUrlScanner();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void urlPrint() {
        try {
            String content = new String();
            while (urlScanner.hasNext()) {
                content = urlScanner.nextLine();
                System.out.println(content);
            }
            urlScanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}







