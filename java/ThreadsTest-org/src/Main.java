import java.util.concurrent.CountDownLatch;

public class Main {

	static Convertor myConv = new Convertor( );

	//testStopExecuteByCancel
	public static void main(String[] args) {
		
		
		final CountDownLatch latch = new CountDownLatch( 1 );
		
		
		Thread th = new Thread() {
		    public void run() {
		    		myConv.cancel( );
		            
		            // Release the lock
		            latch.countDown();    
		    }  
		};
		th.start();
		
		// Run conversion in parallel with Cancel thread
		boolean ret = myConv.execute( );
		
		try {
			// Block the Main thread until its released later from Cancel thread
			latch.await();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
	
		//assertFalse( ret );
	}

}
