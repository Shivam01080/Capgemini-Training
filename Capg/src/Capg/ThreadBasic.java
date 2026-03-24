package Capg;



class ChildThread extends Thread{
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Child1 " + i);
		}
	}
}

class ChildThread2 implements Runnable{
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Child2 " + i);
		}
	}
}

public class ThreadBasic {

	public static void main(String[] args) {
		ChildThread t = new ChildThread();
		t.start();
		ChildThread2 obj = new ChildThread2 ();
		Thread t2 = new Thread(obj);
		t2.start();
		ThreadGroup group = new ThreadGroup("DB");
		group.
	}

}
