import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main
{

	public static void main ( String [ ] args )
	{

		
		Document document = null;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    try 
	    {
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      document = builder.newDocument();
	    }catch (ParserConfigurationException parserException) {
	      parserException.printStackTrace();
	    }
		    
	    Element root = document.createElement( "LayoutPreparationParams" );
	    document.appendChild ( root );
	    
	    // add 1st child element
	    Element elem1 = document.createElement( "LayoutPreparationParams" );

	    Attr elem1Attr1 = document.createAttribute( "RunIndex" );
	    elem1Attr1.setValue ( "2" );
	    elem1.setAttributeNode ( elem1Attr1 );
	    
	    Attr elem1attr2 = document.createAttribute( "Sides" );
	    elem1attr2.setValue ( "OneSidedFront" );
	    elem1.setAttributeNode ( elem1attr2 );
	    
	    root.appendChild (  elem1 );
	    
	    
	    // add 2nd child element
	    Element elem2 = document.createElement( "LayoutPreparationParams" );

	    Attr elem2Attr1 = document.createAttribute( "Rotate" );
	    elem2Attr1.setValue ( "Rotate180" );
	    elem2.setAttributeNode ( elem2Attr1 );
	    
	    Attr elem2Attr2 = document.createAttribute( "RunIndex" );
	    elem2Attr2.setValue ( "4" );
	    elem2.setAttributeNode ( elem2Attr2 );
	    
	    Attr elem2Attr3 = document.createAttribute( "Sides" );
	    elem2Attr3.setValue ( "OneSidedFront" );
	    elem2.setAttributeNode ( elem2Attr3 );
	    
	    Element elem2Elem1 = document.createElement( "FitPolicy" );
	    Attr elem2Elem1Attr1 = document.createAttribute ( "SizePolicy" );
	    elem2Elem1Attr1.setValue ( "ReduceToFit" );
	    elem2Elem1.setAttributeNode ( elem2Elem1Attr1 );
	    elem2.appendChild ( elem2Elem1 );
	    
	    root.appendChild (  elem2 );
	    
	    
	    // add 3th child element
	    Element elem3 = document.createElement( "LayoutPreparationParams" );

	    Attr elem3Attr1 = document.createAttribute( "RunIndex" );
	    elem3Attr1.setValue ( "6 ~ 7" );
	    elem3.setAttributeNode ( elem3Attr1 );
	    
	    Attr elem3Attr3 = document.createAttribute( "Sides" );
	    elem3Attr3.setValue ( "OneSidedFront" );
	    elem3.setAttributeNode ( elem3Attr3 );
	    
	    root.appendChild (  elem3 );
	    
	    
	    System.out.println ( document );
	    System.out.println ( root );

	    // write the XML document to disk
	    try 
	    {

	      // create DOMSource for source XML document
	      Source xmlSource = new DOMSource(document);

	      // create StreamResult for transformation result
	      Result result = new StreamResult(new FileOutputStream("myDocument.xml"));

	      // create TransformerFactory
	      TransformerFactory transformerFactory = TransformerFactory.newInstance();

	      // create Transformer for transformation
	      Transformer transformer = transformerFactory.newTransformer();

	      transformer.setOutputProperty("indent", "yes");

	      // transform and deliver content to client
	      transformer.transform(xmlSource, result);
	
	    }
	    // handle exception creating TransformerFactory
	    catch (TransformerFactoryConfigurationError factoryError) 
	    {
	      System.err.println("Error creating " + "TransformerFactory");
	      factoryError.printStackTrace();
	    }catch (TransformerException transformerError) {
	      System.err.println("Error transforming document");
	      transformerError.printStackTrace();
	    }    catch (IOException ioException) {
	      ioException.printStackTrace();
	    }
	}
	

}
