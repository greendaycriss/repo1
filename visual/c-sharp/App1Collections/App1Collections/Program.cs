using System;

namespace App1Collections
{
    class Program
    {

        static void Main( string[ ] args )
        {
            Random rand = new Random( );
            int size = 100;
            int position = 99;
            int value = 1232323;

            IMyCollection array = new MyArray( size );
            IMyCollection list = new MyList( size );
            for (int i = 0; i < size; i++)
            {
                int randomValue = rand.Next( );
                Console.WriteLine( "elem[ {0} ] = {1}", i, randomValue );

                array.AddElement( randomValue );
                list.AddElement( randomValue );
            }

            Console.WriteLine( "----------------------------------------------------------" );
            Console.WriteLine( "Array:" );
            Console.WriteLine( "RunTime for AddElement ( all ):      " + array.GetTotalTimeSpan() );
            array.FindPositionByValue( value );
            array.RemoveElementByPosition( position );
            Console.WriteLine( "----------------------------------------------------------" );
            Console.WriteLine( );

            Console.WriteLine( "----------------------------------------------------------" );
            Console.WriteLine( "List:" );
            Console.WriteLine( "RunTime for AddElement ( all ):      " + list.GetTotalTimeSpan() );
            list.FindPositionByValue( value );
            list.RemoveElementByPosition( position );
            Console.WriteLine( "----------------------------------------------------------" );
            Console.WriteLine( );
        }

    }
}
