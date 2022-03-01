public class Main{
	public static void main(String[] args){
		Thread t = new Thread(new JavaLove());
		t.start();

		System.out.println("Thread 2");
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<3;i++){
					System.out.println("I Love Java");
					try{
						Thread.sleep((int)(Math.random() * 3000));
					}catch(InterruptedException ie){
						System.out.println(ie);
					}
				}
			}
		});
		t1.start();
	}
}