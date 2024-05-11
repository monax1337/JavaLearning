package validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Main {
    private static final String XML_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter15\\Ex5\\src\\validator\\resources\\book.xml";
    private static final String XSD_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter15\\Ex5\\src\\validator\\resources\\book.xsd";

    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSD_PATH));
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(XML_PATH)));
            System.out.println("Validation complete.");
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
