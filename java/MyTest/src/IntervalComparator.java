import java.util.Comparator;

public class IntervalComparator implements Comparator < String >
{

	public IntervalComparator ()
	{
		
	}

	@Override
	public int compare( String string1, String string2 ) 
	{
		
		String sNumber1 = "";
		for ( int i = 0; i < string1.length(); i ++ )
		{
			char c = string1.charAt( i );
			if( ( i == 0 && ( c == '-' ) ) || Character.isDigit( c ) )
			{
				sNumber1 = sNumber1 + c;
			}
			else
			{
				break;
			}
		}
		
		String sNumber2 = ""; 
		for ( int i = 0; i < string2.length(); i ++ )
		{
			
			char c = string2.charAt( i );
			if( ( i == 0 && ( c == '-' ) ) || Character.isDigit( c ) )
			{
				sNumber2 = sNumber2 + c;
			}
			else
			{
				break;
			}
		}
		
     	Integer number1 = Integer.parseInt( sNumber1 );
		Integer number2 = Integer.parseInt( sNumber2 );
		if( number1 < number2 )
		{
			return -1;
		}
		else if ( number1 > number2 )
		{
			return 1;
		}
		
		return 0;
	}
}





