import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.testng.internal.collections.Pair;

public class MyMap
{

	void function( )
	{
		//------------------------------------------------------
		ArrayList< Pair < String, String > > list1 = new ArrayList< Pair < String, String > >( Arrays.asList( new Pair< String, String >( "Sides", "OneSidedFront" ), new Pair< String, String >( "rRef", "Media0" ), new Pair< String, String >( "LocationName", "Top" ) ) );
		Pair < String, ArrayList < Pair < String, String > > > bigPair1 = new Pair  < String, ArrayList < Pair < String, String > > >( "-323 ~ 2121", list1 );
		
		//------------------------------------------------------
		ArrayList< Pair < String, String > > list2 = new ArrayList< Pair < String, String > >( Arrays.asList( new Pair< String, String >( "Sides", "OneSidedFront" ), new Pair< String, String >( "rRef", "Media1" ), new Pair< String, String >( "LocationName", "Top" ) ) );
		Pair < String, ArrayList < Pair < String, String > > > bigPair2 = new Pair  < String, ArrayList < Pair < String, String > > >( "40 50", list2 );
		
		//------------------------------------------------------
		ArrayList< Pair < String, String > > list3 = new ArrayList< Pair < String, String > >( Arrays.asList( new Pair< String, String >( "Sides", "OneSidedFront" ), new Pair< String, String >( "rRef", "Media1" ), new Pair< String, String >( "LocationName", "Bottom" ) ) );
		Pair < String, ArrayList < Pair < String, String > > > bigPair3 = new Pair  < String, ArrayList < Pair < String, String > > >( "1 ~ 21", list3 );		
	
		//------------------------------------------------------		
		ArrayList< Pair < String, String > > list4 = new ArrayList< Pair < String, String > >( Arrays.asList( new Pair< String, String >( "Sides", "TwoSided" ), new Pair< String, String >( "rRef", "Media1" ), new Pair< String, String >( "LocationName", "Top" ) ) );
		Pair < String, ArrayList < Pair < String, String > > > bigPair4 = new Pair  < String, ArrayList < Pair < String, String > > >( "13", list4 );
		
		
		ArrayList < Pair < String, ArrayList < Pair < String, String > > > > bigList = new ArrayList < Pair < String, ArrayList < Pair < String, String > > > >( Arrays.asList( bigPair1, bigPair2, bigPair3, bigPair4 ) );
		Map < ArrayList < Pair < String, String > >, TreeSet< String > > map = new HashMap< ArrayList < Pair < String, String > >, TreeSet< String > >();
		for ( Pair< String, ArrayList< Pair < String, String > > > pair : bigList ) 
		{
			String interval = pair.first( );
			ArrayList < Pair < String, String > > attributes = pair.second( );
			
			Set< String > sortedSet;
			sortedSet = map.get( attributes );			
			if( sortedSet == null )
			{
				sortedSet = new TreeSet< String > ( new IntervalComparator() );
				map.put( attributes, ( TreeSet< String > ) sortedSet );
			}
			sortedSet.add( interval );
		}
		
		Map < TreeSet< String >, ArrayList < Pair < String, String > > > sortedMap = new TreeMap< TreeSet< String >, ArrayList < Pair < String, String > > >( new IntervalComparator2() );
		for ( Map.Entry < ArrayList < Pair < String, String > >, TreeSet< String > > entry : map.entrySet() ) 
		{
			sortedMap.put ( entry.getValue ( ), entry.getKey ( ) );		
		}
		
		
		
		System.out.println( map );
		System.out.println( "-------------------------------------------------------------------------------------------------" );
		System.out.println( sortedMap );
	}
		
}
