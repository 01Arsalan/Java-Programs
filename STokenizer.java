import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

class STokenizer{
   public static void main(String []args)throws InterruptedException,FileNotFoundException,IOException{
      FileReader reader=new FileReader("Student.txt");
      BufferedReader buffered=new BufferedReader(reader);
      StreamTokenizer token=new StreamTokenizer(buffered);

      token.ordinaryChars('d','c');// remove the parameters passed from tokens.
      
      int t;

      while((t=token.nextToken())!=StreamTokenizer.TT_EOF){
         switch(t){
            case StreamTokenizer.TT_NUMBER :
               System.out.println("Number : "+token.nval);
               break;
            case StreamTokenizer.TT_WORD :
               System.out.println("Word : "+token.sval);
         }
      }
   }
}