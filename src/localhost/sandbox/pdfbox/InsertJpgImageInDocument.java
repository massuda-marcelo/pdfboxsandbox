package localhost.sandbox.pdfbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

public class InsertJpgImageInDocument {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, COSVisitorException {

		// adapted from http://www.printmyfolders.com/Home/PDFBox-Tutorial

		System.out.println("start...");

		/*
		 * Step 1: Prepare the document.
		 */PDDocument doc = new PDDocument();

		PDPage page = new PDPage();
		doc.addPage(page);

		/*
		 * Step 2: Prepare the image PDJpeg is the class you use when dealing
		 * with jpg images. You will need to mention the jpg file and the
		 * document to which it is to be added Note that if you complete these
		 * steps after the creating the content stream the PDF file created will
		 * show "Out of memory" error.
		 */

		PDXObjectImage image = null;
		image = new PDJpeg(doc, new FileInputStream("res/image.jpg"));

		/*
		 * Create a content stream mentioning the document, the page in the
		 * dcoument where the content stream is to be added. Note that this step
		 * has to be completed after the above two steps are complete.
		 */
		PDPageContentStream content = new PDPageContentStream(doc, page);

		/*
		 * Step 3: Add (draw) the image to the content stream mentioning the
		 * position where it should be drawn and leaving the size of the image
		 * as it is
		 */
		content.drawImage(image, 20, 20);
		content.close();

		/*
		 * Step 4: Save the document as a pdf file mentioning the name of the
		 * file
		 */

		doc.save("PdfWithJpgImage.pdf");

		System.out.println("finish...");
	}

}
