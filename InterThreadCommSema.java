class RW {
    int bound = 1;
    String str;
    int count = 0;
  
    synchronized void write(String str) {
      while (bound <= 0) {
        try {
          wait();
        } catch (Exception e) {
        }
      }
      System.out.println("Teacher : " + str);
      this.str = str;
      bound--;
    }
  
    synchronized void read() {
      while (bound >= 2) {
        notify();
        bound = 0;
      }
      bound++;
      count++;
      System.out.println("Student : " + str);
    }
  
    synchronized void hod(String s) {
      while (count <= 6) {
        try {
          wait();
          notify();
        } catch (Exception e) {
        }
        if(count==6)
        System.out.println("\nHOD : " + s + "\n");
      }
    }
  }
  
  class Teacher extends Thread {
    String s[] = { "Arsalan will do it", "java is ok ok", "c++ is complex." };
    RW obj;
  
    Teacher(RW obj) {
      this.obj = obj;
    }
  
    public void run() {
      synchronized (this) {
        for (int i = 0; i < 3; i++)
          obj.write(s[i]);
      }
    }
  }
  
  class student extends Thread {
    RW obj;
  
    student(RW obj) {
      this.obj = obj;
    }
  
    public void run() {
  
      for (int i = 0; i < 3; i++)
        obj.read();
    }
  }
  
  class HOD extends Thread {
    String annonce = "Keep It Up...\nYou are Doing it well..";
    RW obj;
  
    HOD(RW obj) {
      this.obj = obj;
    }
  
    public void run() {
      obj.hod(annonce);
    }
  
  }
  
  class InterThreadCommSema {
    public static void main(String[] args) throws InterruptedException {
  
      RW obj = new RW();
  
      Teacher t = new Teacher(obj);
      Thread th = new Thread(t);
  
      th.start();
  
      HOD h = new HOD(obj);
      h.start();
  
      student s1 = new student(obj);
      student s2 = new student(obj);
      student s3 = new student(obj);
  
      s1.start();
      s1.join();
  
      s2.start();
      s2.join();
  
      s3.start();
      s3.join();
  
      // Thread t1=new Thread(){
      // public void run(){
      // obj.write(s1[0]);
      // for(int i=0;i<3;i++)
      // obj.read(s1[0]);
      // }
      // };
      // t1.start();
      // t1.join();
  
      // Thread t2=new Thread(){
      // public void run(){
      // obj.write(s1[1]);
      // for(int i=0;i<3;i++)
      // obj.read(s1[1]);
      // }
      // };
      // t2.start();
      // t2.join();
  
      // Thread t3=new Thread(){
      // public void run(){
      // obj.write(s1[2]);
      // for(int i=0;i<3;i++)
      // obj.read(s1[2]);
      // }
      // };
      // t3.start();
  
    }
  }