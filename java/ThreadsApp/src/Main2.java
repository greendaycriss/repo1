import java.util.concurrent.CountDownLatch;

public class Main2 {

	static Convertor myConv = new Convertor( );

	//testStopExecuteByCancel
	public static void main(String[] args) {
		
		Thread th = new Thread()
		{
			public void run() {
				myConv.execute();
			}
			
		};
		th.start();
		
//		Sleep( 1000 );
		
//		myConf.Cancel();
				
	}

}
