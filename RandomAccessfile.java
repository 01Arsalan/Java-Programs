import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class RandomAccessfile {

  public static void main(String[] args) throws IOException {
    //creating two file objects.
    File file1 = new File("test.txt");//files not in this folder.
    File file2 = new File("test1.txt");

    //creating two RAF objects for test.txt in read mode & for test1.txt in read and write mode.
    RandomAccessFile ride1 = new RandomAccessFile(file1, "r");
    RandomAccessFile ride2 = new RandomAccessFile(file2, "rw");

    System.out.println("File Length : "+ride1.length()+"\n\n");
    byte[] bites = new byte[420];
    //reading from text.txt and writing into byte array.
    ride1.read(bites);
    // printing byte array.
    System.out.println("File 1 : \n\n" + new String(bites));

    //changing file pointer position to 0
    ride2.seek(0);

    //using bites array to write into file 2
    ride2.write(bites);
    System.out.println("\n\n");

    //creating an another byte array for reading file 2
    byte[] bites2 = new byte[420];

    // reading into bites2 array from file 2
    ride2.readFully(bites2);

    System.out.println("copied text. File 2 : \n\n" + new String(bites2));

    ride1.close();
    ride2.close();
  }
}
