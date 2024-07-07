import java.io.*;
class A implements Cloneable{
    int i;
    public A(int a){
       i=a;
    }
    void show(){
       System.out.print(i);
    }
 
 
 
 class clonable{
    public static void main(String []args)throws CloneNotSupportedException{
       A obj1=new A(5);
       obj1.show();
       A obj2=(A)obj1.clone();
       obj2.show();
    }
 }
 }