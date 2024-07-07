
import java.io.IOException;
import java.io.*;

class BufferedReaderChar{
    public static void main(String []args)throws IOException{
        String data="arsalan is becoming a programmer.\nprogress.";

        //writing 

        File file=new File("file.txt");
        FileWriter out=new FileWriter(file);
        //creating a buffered output stream.
        BufferedWriter writer= new BufferedWriter(out);

        writer.write(data);
        writer.close();

        //reading

        FileReader in=new FileReader(file);
        //creating a buffered input stream.
        BufferedReader reader= new BufferedReader(in);

        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        
        int i;
        while((i=reader.read())!=-1){       //reding bites till EOF
            System.out.print((char)i);
        }

        reader.close();
        
    }
 }
 