import java.util.Comparator;

public class TestComparator 
{

	public static void main( String[] args ) 
	{
		Comparator < String > comp = new IntervalComparator( );
		int test = comp.compare( "-676", "-1255" );
		
		 
		System.out.println( test );
	}

}
