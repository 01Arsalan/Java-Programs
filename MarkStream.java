import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class imlemeMarkStream {

  public static void main(String[] args) throws IOException {
    String str = "Hello World";

    File file = new File("test.txt");

    FileWriter writer = new FileWriter(file);

    writer.write(str);

    writer.close();

    FileReader FR = new FileReader(file);
    BufferedReader reader = new BufferedReader(FR);

    System.out.print(reader.markSupported());
    System.out.println();

    for (int i = 0; i < 3; i++) {
      System.out.print((char) reader.read());
    }
    System.out.println();
    reader.mark(10); // this will mark the stream at 5th character and will remember this mark, till 10 more characters are read.

    for (int i = 0; i < 9; i++) {
      System.out.print((char) reader.read());
    }

    reader.reset(); // this will reset the stream to the earlier saved point.
    System.out.println("\n\n");

    for (int i = 0; i < 8; i++) {
      System.out.print((char) reader.read());
    }

    reader.close();
  }
}
