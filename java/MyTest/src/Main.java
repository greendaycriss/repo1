import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.testng.internal.collections.Pair;


public class Main 
{
	
	static String computeIntervals( List< Integer > input )
	{
		
		String result = "";
		
		
		int intervalStart = -1;
		int previousValue = -1;
		boolean first = true;
		
		for ( Integer currentValue : input )
		{
			if ( first )
			{
				first = false;
			}
			else
			{
				if( currentValue == previousValue + 1 )
				{
					if( intervalStart == -1 )
					{
						intervalStart = previousValue;
					}
				}
				else
				{
                    if ( intervalStart == -1 )
                    {
                    	result = result + previousValue + " ";
                    }
                    else
                    {
                    	result = result + intervalStart + " ~ " + previousValue + " ";
                        intervalStart = -1;
                    }
				}
			}
			previousValue = currentValue;
		}
		
        if ( intervalStart == -1 )
        {
        	result = result + previousValue;
        }
        else
        {
        	result = result + intervalStart + " ~ " + previousValue;
        }
		
		
		
		
		return result;
	}
	
	public static void main ( String[ ] args )
	{

		String result = computeIntervals( Arrays.asList ( 2, 4, 7, 8, 9, 19, 21, 30, 31, 35 ) );
//		String result = computeIntervals( Arrays.asList (  ) );
		
		System.out.println ( result );
	}
}






