
import java.io.IOException;
import java.io.*;

class BufferdStreamByte{
    public static void main(String []args)throws IOException{
        String data="arsalan is becoming a programmer.\nprogress.";

        //writing 

        File file=new File("file.txt");
        OutputStream out=new FileOutputStream(file);
        //creating a buffered output stream.
        BufferedOutputStream writer= new BufferedOutputStream(out);

        writer.write(data.getBytes());//getbyte()--to convert in bytes
        writer.close();

        //reading

        InputStream in=new FileInputStream(file);
        //creating a buffered input stream.
        BufferedInputStream reader= new BufferedInputStream(in);
        
        
        int i;
        while((i=reader.read())!=-1){       //reding bites till EOF
            System.out.print((char)i);
        }
        reader.close();
        
    }
 }
 