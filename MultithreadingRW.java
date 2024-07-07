import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

class DataIn extends Thread {

  File file;
  FileReader reader;

  void allocation() throws IOException {
    file = new File("test.txt");
  }

  void read() throws IOException {
    reader = new FileReader(file);
    int c;
    while ((c = reader.read()) != -1) {
      System.out.print((char) c);
    }

    reader.close();
  }

  @Override
  public void run() {
    try {
      allocation();
      System.out.println("\n\nReading ...\n");
      read();
      System.out.println("\n\nReadingF ...\n");
    } catch (IOException e) {
      System.out.println("Reading Exception Caught.\n");
    }
  }
}

class DataOut extends Thread {

  File file;
  String str;
  RandomAccessFile ride;

  void write() throws FileNotFoundException, IOException {
    str = "it should work..";
    file = new File("test.txt");
    ride = new RandomAccessFile(file, "rw");
    ride.seek(ride.length());
    ride.writeChars(str);
    ride.close();
  }

  public void run() {
    try {
      System.out.println("Writing...");

      write();
      System.out.println("WritingF...");
    } catch (IOException e) {
      System.out.print("Writing Exception Caught.\n");
    }
  }
}

class MultithreadingRW {

  public static void main(String[] args) throws InterruptedException {
    DataIn objR = new DataIn();
    DataOut objW = new DataOut();

    objR.setPriority(10);
    objR.start();
    if (objR.isAlive()) {
      System.out.print("alive");
      DataOut.sleep(500);
    }

    objW.start();
    DataIn.sleep(500);

    System.out.println("\n\nReading and Writing Operations Finished.\n");

    objR.run();
  }
}
