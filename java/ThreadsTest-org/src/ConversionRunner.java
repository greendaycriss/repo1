import java.util.concurrent.atomic.AtomicBoolean;

//This class is thread unsafe.
public class ConversionRunner {

	private AtomicBoolean performed = new AtomicBoolean( false );
	
	public String execute() {
		System.out.println( "ConversionRunner.execute [ IN ]" );
		String result = "";
		this.performed.set( true );
		//this.locker_.acquire( );
		
		System.out.println( "ConversionRunner.execute [ Create Conversion file... ]" );
		System.out.println( "ConversionRunner.execute [ Run Conversion in a Process... ]" );
		// result = "Canceled"; <-- if VeryGOOD
		// result = "Canceled"; <-- if BAD

		//this.locker_.release( );
		System.out.println( "ConversionRunner.execute [ OUT ]" );		
		return result;
	}

	public void cancel() {
		System.out.println( "ConversionRunner.cancel [ IN ]" );
		
		if( !this.performed.get() ) {
			System.out.println( "ConversionRunner.cancel [ OUT ] <--- BAD" );
			return;
		}
		System.out.println( "ConversionRunner.execute [ Create Cancel file... ]" );
		
		System.out.println( "ConversionRunner.cancel [ OUT ]<--- VeryGOOD" );
	}

}
