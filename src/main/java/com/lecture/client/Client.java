package com.lecture.client;

import java.io.ByteArrayInputStream;
        import java.io.IOException;
        import java.nio.charset.Charset;

        import javax.xml.soap.MessageFactory;
        import javax.xml.soap.MimeHeaders;
        import javax.xml.soap.SOAPConnection;
        import javax.xml.soap.SOAPConnectionFactory;
        import javax.xml.soap.SOAPException;
        import javax.xml.soap.SOAPMessage;
        import javax.xml.transform.Source;
        import javax.xml.transform.Transformer;
        import javax.xml.transform.TransformerFactory;
        import javax.xml.transform.stream.StreamResult;

public class Client {

    public static void main(String args[]) {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            String url = "http://localhost:8080/SoapService/service?wsdl";
            String soapMessage = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://www.soapws.example.com\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <soap:getLibraries/>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            SOAPMessage soapResponse = soapConnection.call(getSoapMessageFromString(soapMessage), url);

            printSOAPResponse(soapResponse);

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }

    private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }
}
