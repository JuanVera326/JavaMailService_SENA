package com.in.model;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.in.controller.Controller;


public class ReadWordFiles {
	
	private Controller controller;

	public String convertWordToHtml(String wordFilePath) throws IOException {
		
		StringBuilder contentBuilder = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream(wordFilePath);
             XWPFDocument document = new XWPFDocument(fileInputStream)) {

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    contentBuilder.append(run.getText(0));
                }
                contentBuilder.append("<br/>");
            }
        }

        return contentBuilder.toString();
    }

	public void setController(Controller controller) {
		this.controller = controller;
	}

}
