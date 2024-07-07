public class Garbage {
    public class Emp{
        private static int nxtid=1;
        int id;
        String name;

        Emp(String n){
            this.name=n;
            this.id=nxtid++;
        }
        void show(){
            System.out.print("\nName : "+name+" \nId : "+id+"\n");
        }
        void show_nxtid(){
            System.out.print("\nNext Id : "+nxtid+"\n");
        }
        protected void finalize()
        {
        --nxtid;
        }
    }
    Emp e1= new Emp("arsalan");
    Emp e2= new Emp("adil");
    Emp e3=new Emp("asif");

    Emp e4= new Emp("huzaib");
    Emp e5=new Emp("basit");



    public static void main(String []args){
        Garbage obj =new Garbage();
        obj.e1.show();
        obj.e1.show_nxtid();
        obj.e2.show();
        obj.e2.show_nxtid();
        obj.e3.show();
        obj.e3.show_nxtid();

        {
            obj.e5.show_nxtid();
            obj.e4=obj.e5=null;
            System.gc();
            System.runFinalization();
        }
        obj.e3.show_nxtid();

        

    }
}
