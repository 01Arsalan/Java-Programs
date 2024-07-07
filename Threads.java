class concurrent1 implements Runnable{
    void show(){
      System.out.println("abc");
      }
    @Override
    public void run() {
        System.out.println("Concurrent 1");
        show();
    }
    
  }
  class concurrent2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Concurrent 2");
    }
  }
  class concurrent3 implements Runnable{
    @Override
    public void run() {
        System.out.println("Concurrent 3");
    }
  }
  class Threads {
  
    public static void main(String[] args) {
        concurrent1 thread1=new concurrent1();
        concurrent2 thread2=new concurrent2();
        concurrent3 thread3=new concurrent3();
  
        Thread t1=new Thread(thread1);
        Thread t2=new Thread(thread2);
        Thread t3=new Thread(thread3);
  
        t1.start();
        t2.start();
        t3.start();
    }
  }
  