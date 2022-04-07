package com.filemanipulation;

public class FPThread {

	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(Thread.currentThread().getId()+":"+i);
				}
				
			}
		};
		
		// is the same as the above
		Runnable runnable2 = ()->{
			for(int i=0; i<10; i++) {
				System.out.println(Thread.currentThread().getId()+":"+i);
			}
		};
		
	Thread thread = new Thread(runnable);
	thread.start();
	
	Thread thread2 = new Thread(runnable2);
	thread2.start();

	}

}
