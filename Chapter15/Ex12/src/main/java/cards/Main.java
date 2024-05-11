package cards;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class Main {
    private static final String XML_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter15\\Ex12\\src\\main\\java\\cards\\resources\\old_cards.xml";
    private static final String XSL_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter15\\Ex12\\src\\main\\java\\cards\\resources\\old_cards.xsl";
    private static final String PDF_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter15\\Ex12\\src\\main\\java\\cards\\resources\\old_cards.pdf";

    public static void main( String[] args )
    {
        try {
            convertToPDF();
        } catch (FOPException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void convertToPDF() throws IOException, FOPException, TransformerException {
        File xsltFile = new File(XSL_PATH);
        StreamSource xmlSource = new StreamSource(new File(XML_PATH));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        OutputStream out;
        out = new java.io.FileOutputStream(PDF_PATH);

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }
}