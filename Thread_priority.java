class Thread_priority {

  public static void main(String[] args) throws InterruptedException {
    Thread th = Thread.currentThread();
    System.out.println(th.getName());

    th.setName("MAIN Thread.");

    System.out.println(th.getName());

    System.out.println(th.getPriority());

    th.setPriority(1);

    System.out.println(th.getPriority());

    for (int i = 0; i < 5; i++) {
      System.out.println("Main thread");
    }

    Thread ch = new Thread() {
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("child thread");
        }
      }
    };
    ch.setPriority(7);

    ch.start();

    Thread ch1 = new Thread() {
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("thread");
        }
      }
    };
    ch1.setPriority(10);
    ch1.start();
  }
}
