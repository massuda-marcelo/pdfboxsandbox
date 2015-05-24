package localhost.sandbox.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class CreateBlankDocument {

	public static void main(String[] args) throws IOException, COSVisitorException {

		// from https://pdfbox.apache.org/1.8/cookbook/documentcreation.html

		System.out.println("start...");

		// Create a new empty document
		PDDocument document = new PDDocument();

		// Create a new blank page and add it to the document
		PDPage blankPage = new PDPage();
		document.addPage(blankPage);

		// Save the newly created document
		document.save("BlankPage.pdf");

		// finally make sure that the document is properly
		// closed.
		document.close();

		System.out.println("finish...");
	}
}
