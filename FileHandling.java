import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandling {

    public static void main(String[] args) {

        try { // .createNewFile() method must be used inside try block.
            File myFile = new File("file1.txt"); // to create a ref for file
            if (myFile.createNewFile()) {
                System.out.print("\n\nFile Created : " + myFile + "\n");
            } else {
                System.out.print("\n\nFile already Exist : " + myFile.getName() + "\n");
            }

            FileWriter writer = new FileWriter("file1.txt"); // to create a writer object

            writer.write("Arsalan\n wani");
            writer.close();

            Scanner reader = new Scanner(myFile); // creating a reader obj of scanner class
            String data = reader.nextLine(); // reading a String, till a \n character is found.
            System.out.print("\n\n" + data);
            reader.close();

            if (myFile.delete()) { // used to delete file, returns bool value.
                System.out.print("File deleted : " + myFile + "\n");
            } else {
                System.out.print("Failed to delete File.");
            }
        } catch (IOException e) { // for catching any io exceptions created by failed file creation
            System.out.print("An error occured...Caught");
        }
    }
}
