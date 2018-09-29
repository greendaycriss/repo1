//
// sync_client.cpp
// ~~~~~~~~~~~~~~~
//
// Copyright (c) 2003-2017 Christopher M. Kohlhoff (chris at kohlhoff dot com)
//
// Distributed under the Boost Software License, Version 1.0. (See accompanying
// file LICENSE_1_0.txt or copy at http://www.boost.org/LICENSE_1_0.txt)
//


#include <iostream>
#include <istream>
#include <ostream>
#include <string>
#include <boost/asio.hpp>

using boost::asio::ip::tcp;

int main(int argc, char* argv[])
{
	try
	{
/*
		if (argc != 3)
		{
			std::cout << "Usage: sync_client <server> <path>\n";
			std::cout << "Example:\n";
			std::cout << "  sync_client www.boost.org /LICENSE_1_0.txt\n";
			return 1;
		}
*/
		boost::asio::io_context io_context;

		// Get a list of endpoints corresponding to the server name.
		tcp::resolver resolver(io_context);
		tcp::resolver::results_type endpoints = resolver.resolve( "localhost", "8080");

		// Try each endpoint until we successfully establish a connection.
		tcp::socket socket(io_context);
		boost::asio::connect(socket, endpoints);

		// Form the request. We specify the "Connection: close" header so that the
		// server will close the socket after transmitting the response. This will
		// allow us to treat all data up until the EOF as the content.
		boost::asio::streambuf request;
		std::ostream request_stream(&request);
		request_stream << "GET " << "/PCServer/" << " HTTP/1.0\r\n";
		request_stream << "Host: " << "localhost:8080" << "\r\n";
		request_stream << "Accept: */*\r\n";
		request_stream << "Connection: close\r\n\r\n";

		// Send the request.
		boost::asio::write(socket, request);

		// Read the response status line. The response streambuf will automatically
		// grow to accommodate the entire line. The growth may be limited by passing
		// a maximum size to the streambuf constructor.
		boost::asio::streambuf response;
/*
		boost::asio::read_until(socket, response, "\r\n");

		// Check that response is OK.
		std::istream response_stream(&response);
		std::string http_version;
		response_stream >> http_version;
		unsigned int status_code;
		response_stream >> status_code;
		std::string status_message;
		std::getline(response_stream, status_message);
		if (!response_stream || http_version.substr(0, 5) != "HTTP/")
		{
			std::cout << "Invalid response\n";
			return 1;
		}
		if (status_code != 200)
		{
			std::cout << "Response returned with status code " << status_code << "\n";
			return 1;
		}

		// Read the response headers, which are terminated by a blank line.
		boost::asio::read_until(socket, response, "\r\n\r\n");

		// Process the response headers.
		std::string header;
		while (std::getline(response_stream, header) && header != "\r")
			std::cout << header << "\n";
		std::cout << "\n";

		// Write whatever content we already have to output.
		if (response.size() > 0)
			std::cout << &response;

		// Read until EOF, writing data to output as we go.
		boost::system::error_code error;
		while (boost::asio::read(socket, response, boost::asio::transfer_at_least(1), error))
		{
			std::cout << &response;
		}
		
*/

		boost::system::error_code error;
		boost::asio::read( socket, response, boost::asio::transfer_all( ), error );
		if ( error != boost::asio::error::eof )
		{
			throw boost::system::system_error(error);
		}
//		std::cout << &response;
		
		
		std::istream response_stream( &response );

		//------------------------------------------------------------------------
		std::string http_version;
		response_stream >> http_version;

		unsigned int status_code;
		response_stream >> status_code;

		std::string status_message;
		std::getline( response_stream, status_message );

		if ( !response_stream || http_version.substr( 0, 5 ) != "HTTP/" )
		{
			std::cout << "Invalid response\n";
			return 1;
		}
		if ( status_code != 200 )
		{
			std::cout << "Response returned with status code " << status_code << "\n";
			return 1;
		}
		//------------------------------------------------------------------------

		// Transfer-Encoding
		std::string transfer_encoding;
		std::string transfer_encoding_type;
		response_stream >> transfer_encoding;
		if ( "Transfer-Encoding:" != transfer_encoding )
		{
			return 1;
		}
		std::getline( response_stream, transfer_encoding_type );
		//------------------------------------------------------------------------

		// Date
		std::string date;
		std::string date_value;
		response_stream >> date;
		if ( "Date:" != date)
		{
			return 1;
		}
		std::getline( response_stream, date_value );
		//------------------------------------------------------------------------

		// Content-Length
		std::string content_length;
		std::string content_length_value;
//		response_stream >> content_length;
		std::getline(response_stream, content_length_value);
		//------------------------------------------------------------------------

		//body
		std::string body;
		std::getline( response_stream, body );
		//------------------------------------------------------------------------

			
	}
	catch (std::exception& e)
	{
		std::cout << "Exception: " << e.what() << "\n";
	}

	return 0;
}




