
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class write{
  synchronized void proceed(int n)throws IOException{
    File file= new File("test.txt");
    FileWriter writer= new FileWriter(file);
    
    writer.write("writing...1");
    writer.close();

    for(int i=0;i<n;i++){
      System.out.println("i:"+i);
    }
  }
}

class writer1 extends Thread{
  write w;
  Thread th;

  writer1(write w){
    this.w=w;
    th=new Thread(this);
    th.start();
  }
  public void run(){
    try{
        w.proceed(5);
    }catch(IOException e){
      System.out.print(e);
    }
  }
}
class writer2 extends Thread{
  write w;
  Thread th;
  writer2(write w){
    this.w=w;
    th=new Thread(this);
    th.start();
  }
  public void run(){
    try{
        w.proceed(10);
    }catch(IOException e){
      System.out.print(e);
    }
  }
}

class Synchronization{
  public static void main(String []args)throws InterruptedException{

    write W1=new write();

    writer2 w1 =new writer2(W1);
    w1.th.join();// will not let any other thread execute unless w1.th is executed..  no synchronization is NEEDED if we use join();
    writer1 w2=new writer1(W1);

    
    
    

   



  }
}