using System;

namespace App1Collections
{
    interface IMyCollection
    {

        TimeSpan GetTotalTimeSpan( );
        void AddElement( int value );
        int FindPositionByValue( int value );
        void RemoveElementByPosition( int position );

    }
}