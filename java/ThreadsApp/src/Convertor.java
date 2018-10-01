import java.util.concurrent.atomic.AtomicBoolean;

public class Convertor {
	
	private ConversionRunner runner = new ConversionRunner( );
	private AtomicBoolean performed = new AtomicBoolean( false );
	
	public boolean execute( ) {
		System.out.println( "Convertor.execute [ IN ]" );
		
		boolean ret = false;
		this.performed.set( true );
		
		System.out.println( "Convertor.execute [ Creates directory... ]" );
		String result = runner.execute( );
		if( result.equals( "Success" ) ) {
			// BAD
			ret = true;
		}
		System.out.println( "Convertor.execute [ OUT ]" );
		return ret;
	}
	
	public void cancel( ) {
		System.out.println( "Convertor.cancel [ IN ]" );
		if( !this.performed.get() ) {
			System.out.println( "Convertor.cancel [ OUT ] <--- BAD" );
			return;
		}
		
		runner.cancel( );
		System.out.println( "Convertor.cancel [ OUT ] <--- GOOD" );
	}

}
