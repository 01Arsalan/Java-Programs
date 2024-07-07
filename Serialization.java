import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable; //for ObjectOutputStream.(Exception otherwise)

class student implements Serializable {

  int id;
  String name;

  student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  void getter() {
    System.out.println("ID   : " + id + "\nNAME : " + name + "\n");
  }
}

public class Serialization {

  public static void main(String[] args) {
    student s1 = new student(1001, "Arsalan");

    try {
      File myFile = new File("file1.txt"); //creation of file, we can also skip file creation here.
      if (myFile.createNewFile()) {
        System.out.print("\n\nFile Created : " + myFile + "\n");
      } else {
        System.out.print("\n\nFile already Exist : " + myFile.getName() + "\n");
      }

      FileOutputStream write = new FileOutputStream(myFile); // creating a output stream, also creates a new file if we want.
      ObjectOutputStream writer = new ObjectOutputStream(write); // Writer object to write into (write ) stream.
      writer.writeObject(s1);
      writer.flush();
      writer.close();

      ObjectInputStream reader = new ObjectInputStream( // creating a input stream and and stream writer(reader) in the same line.
        new FileInputStream(myFile)
      );
      student s2 = (student) reader.readObject();
      reader.close();

      s2.getter();

      if (myFile.delete()) {
        System.out.print("File deleted : " + myFile + "\n");
      } else {
        System.out.print("Failed to delete File.");
      }
    } catch (IOException e) {
      System.out.print("An error occured...Caught");
    } catch (ClassNotFoundException c) {
      System.out.print("Class not found Exception caught.");
    }
  }
}
