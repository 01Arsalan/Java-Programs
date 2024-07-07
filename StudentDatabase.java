import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Student implements Serializable {

  int id;
  String name;
  String dept;

  void setter() {
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter your Name : ");
    name = reader.nextLine();
    System.out.print("Enter your Dept. : ");
    dept = reader.nextLine();
    System.out.print("Enter your ID : ");
    id = reader.nextInt();
    reader.nextLine();
  }

  void getter() {
    System.out.println(
      "NAME : " + name + "\tDEPT. : " + dept + "\tID : " + id + "\n\n"
    );
  }
}

class Finder {

  int id() {
    System.out.print("Enter the ID of the Student : ");
    Scanner reader = new Scanner(System.in);
    int i = reader.nextInt();
    reader.close();
    return i;
  }
}

class StudentDatabase {

  public static void main(String[] args) {
    try {
      ObjectOutputStream writer = new ObjectOutputStream(  //creating writer object to write on file stream and creating and connecting that file to object stream.
        new FileOutputStream("Student.txt")
      );

      for (int i = 0; i < 3; i++) {
        Student s1 = new Student();             //re-initializing s1 object, or we have to use multiple objects for writing(Same object,could only be used to write one time.)
        s1.setter();
        writer.writeObject(s1);                 // writting on a file.
      }
      writer.flush();
      writer.close();

      Finder find = new Finder();
      int f = find.id();

      ObjectInputStream reader = new ObjectInputStream( //Creating a reader object to read from file and creating a Stream and connecting it to reader object and File.
        new FileInputStream("Student.txt")
      );
      int flag = 0;                                     // Flag to check, if record is found or not.
      Student s1 = new Student();
      for (int i = 0; i < 3; i++) {
        s1 = (Student) reader.readObject();            // reading from a file 
        if (s1.id == f) {
          System.out.print("\n\n");
          s1.getter();
          flag = 1;
        }
      }
      if (flag == 0) {
        System.out.print("\nRecord Not Found.");
      }
      reader.close();

    //   File Deletion Incomplete.

    } catch (IOException e) {                                       // Exception can be dealt in a different way.
      System.out.print("Input/Output Exception Caught.");
    } catch (ClassNotFoundException e) {
      System.out.print("ClassNotFound Exception Caught.");
    }
  }
}
