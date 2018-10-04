package sample;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Task implements Runnable{

	
	public Task(String name) {
		super();
		this.name = name;
	}
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		int duration=(int) (Math.random()*1000);
	try {
		for (int i = 0; i < 5; i++) {
			System.out.println("Executing :"+name);
		}
		
		Thread.sleep(duration);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
		
	}
	
}

public class TheadDemo {

	public static void main(String[] args) {
		ThreadPoolExecutor exe=(ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			Task task=new Task("task is:"+i);
			System.out.println("created task is "+task.getName());
			exe.execute(task);
		}
		//exe.execute(new Task("task is:"));
exe.shutdown();
	}

}
