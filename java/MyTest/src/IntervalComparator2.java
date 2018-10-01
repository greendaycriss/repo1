import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import org.testng.internal.collections.Pair;


public class IntervalComparator2 implements Comparator < TreeSet< String > >
{

	
	
	
	
	@Override
	public int compare ( TreeSet < String > string1, TreeSet < String > string2 )
	{
		
		
		String first = string1.first ( );
		String first2 = string2.first ( );
		
		
		Comparator < String > comp = new IntervalComparator( );
		return comp.compare (  first, first2 );
	}

}
