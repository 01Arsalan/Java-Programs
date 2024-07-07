abstract class pen {

  void write() {}

  abstract void refill();
}

class Fountainpen extends pen {

  void changeNib() {
    System.out.println("Changing Nib..\n\n");
  }

  void write() {
    System.out.println("Writting..\n\n");
  }

  void refill() {
    System.out.println("refilling..\n\n");
  }
}

interface basicAnimal {
  void eat();
  void sleep();
}

class monkey {

  void jump() {
    System.out.println("Jumping\n\n");
  }

  void bite() {
    System.out.println("Biting..\n\n");
  }
}

class human extends monkey implements basicAnimal {

  public void eat() {
    System.out.println("Eating..\n\n");
  }

  public void sleep() {
    System.out.println("Sleeping..\n\n");
  }
}

interface smart_remote {
  void changeChannel();

  static void print() {
    System.out.print("can have static methods\n\n"); //can not be inherited;
  }
}

interface remote_old extends smart_remote {
  void switchon();
}

class Remote implements remote_old {

  public void switchon() {
    System.out.println("Switching on..\n\n");
  }

  public void changeChannel() {
    System.out.println("Changing channel..\n\n");
  }
}

class Interfacei {

  public static void main(String[] str) {
    smart_remote obj = new Remote();

    obj.changeChannel();
    smart_remote.print();
  }
}
