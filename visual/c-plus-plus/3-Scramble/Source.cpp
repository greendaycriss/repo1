#include <iostream>
#include <string>
using namespace std;

#define encode_key 0x2a1bf9ee

void scramble( string& p_str )
{
	size_t key = p_str.size( );
	key ^= encode_key;
	int loop_times = p_str.size( ) / sizeof( size_t );//x32: 41/4=10    //x64: 41/8=5
	for ( int i = 0; i < loop_times; i++ )
	{
		( ( size_t* )p_str.data( ) )[ i ] ^= key;
	}
	for ( int i = 0; i < ( p_str.size( ) % sizeof( size_t ) ); i++ )
	{
		( ( char* )p_str.data( ) )[ ( loop_times * sizeof( size_t ) ) + i ] ^= ( ( char* )&key )[ i ];
	}
}

int main()

{
	string input = "passw0rd";
	string after_md5 = "bed128365216c019988915ed3add75fb";
	after_md5 += " ";
	after_md5 += input;

	scramble( after_md5 );
	cout << "Hello!";
	
	cout << nl;

// 	base64::encode( after_md5 );
	return 0;
}