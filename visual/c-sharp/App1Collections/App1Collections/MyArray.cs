using System;
using System.Diagnostics;

namespace App1Collections
{
    class MyArray : IMyCollection
    {

        private int[ ] array;
        private readonly int size;
        private int count = 0;
        private TimeSpan totalTimeSpan;

        public MyArray( int size )
        {
            this.array = new int[ size ];
            this.size = size;
        }

        public TimeSpan GetTotalTimeSpan( )
        {
            return totalTimeSpan;
        }

        public void AddElement( int value )
        {
            Stopwatch stopWatch = new Stopwatch( );
            stopWatch.Start( );

            array[ count ] = value;
            count++;

            TimeSpan timeSpan = stopWatch.Elapsed;
            totalTimeSpan = totalTimeSpan + timeSpan;
        }

        public int FindPositionByValue( int value )
        {
            Stopwatch stopWatch = new Stopwatch( );
            stopWatch.Start( );

            int position = -1;
            for (int i = 0; i < array.Length; i++)
            {
                if (array[ i ] == value)
                {
                    position = i;
                }
            }

            stopWatch.Stop( );
            TimeSpan timeSpan = stopWatch.Elapsed;
            Console.WriteLine( "RunTime for FindPositionByValue:     " + timeSpan );

            return position;
        }

        public void RemoveElementByPosition( int position )
        {
            Stopwatch stopWatch = new Stopwatch( );
            stopWatch.Start( );

            if (array.Length > 0)
            {
                for (int i = position; i < array.Length - 1; i++)
                {
                    // moving elements downwards, to fill the gap at [index]
                    array[ i ] = array[ i + 1 ];
                }
                // finally, let's decrement Array's size by one

                Array.Resize( ref array, array.Length - 1 );
            }

            stopWatch.Stop( );
            TimeSpan timeSpan = stopWatch.Elapsed;
            Console.WriteLine( "RunTime for RemoveElementByPosition: " + timeSpan );
        }

        public void Print( )
        {
            for (int i = 0; i < array.Length; i++)
            {
                Console.WriteLine( "a[ {0} ] = {1}", i, array[ i ] );
            }
        }

    }
}