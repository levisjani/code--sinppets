/*
*	Thread with syncronized method. 
*/

class Data{

	syncronized void Print_Data(String t_name){
		for (int i=0; i<5; i++ ) {
			try{
				Thread.sleep(1000);
				System.out.println(t_name+" : "+i);
			}catch(InterruptedException ie){
				System.out.println("Child Thread Interrupted");
			}
		}
	}
}

class NewThread extends Thread{

	private Data D;
	String t_name;

	NewThread(String t_name,Data D){
		this.t_name = t_name;
		this.D = D;
		start();
	}

	public void run(){
		D.Print_Data(t_name);
	}
}

public class javaapp{

	public static void main(String[] args) {
		Data Data_obj = new Data();
		NewThread thread1 = new NewThread("Thread1",Data_obj);
		NewThread thread2 = new NewThread("Thread2",Data_obj);
	}
}
