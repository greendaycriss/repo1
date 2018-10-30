using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace App1Collections
{
    class MyList : IMyCollection
    {

        private List<int> list;
        private TimeSpan totalTimeSpan;

        public MyList( int size )
        {
            list = new List<int>( );
        }

        public TimeSpan GetTotalTimeSpan()
        {
            return totalTimeSpan;
        }

        public void AddElement( int value )
        {
            Stopwatch stopWatch = new Stopwatch( );
            stopWatch.Start( );

            list.Add( value );

            TimeSpan timeSpan = stopWatch.Elapsed;
            totalTimeSpan = totalTimeSpan + timeSpan;
        }

        public int FindPositionByValue( int value )
        {
            Stopwatch stopWatch = new Stopwatch( );
            stopWatch.Start( );

            int position = list.IndexOf( value );

            stopWatch.Stop( );
            TimeSpan timeSpan = stopWatch.Elapsed;
            Console.WriteLine( "RunTime for FindPositionByValue:     " + timeSpan );

            return position;
        }

        public void RemoveElementByPosition( int position )
        {
            Stopwatch stopWatch = new Stopwatch( );
            stopWatch.Start( );

            if (list.Count > 0)
            {
                list.RemoveAt( position );
            }

            stopWatch.Stop( );
            TimeSpan timeSpan = stopWatch.Elapsed;
            Console.WriteLine( "RunTime for RemoveElementByPosition: " + timeSpan );
        }

        public void Print( )
        {
            for (int i = 0; i < list.Count; i++)
            {
                Console.WriteLine( "a[ {0} ] = {1}", i, list[ i ] );
            }
        }

    }
}