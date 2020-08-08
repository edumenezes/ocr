package com.ebm.ocr.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OcrUtils {

	@BeforeAll
	static void setup() {
		System.setProperty("TESSDATA_PREFIX", "/home/eduardo/eclipse-workspace/ocr/work/tessdata/eng.traineddata");
	}
	
	@Test
	void callOcrWithSuccess() {
		Tesseract tesseract = getTesseract();
		File file = new File("/home/eduardo/eclipse-workspace/ocr/work/image_test_ocr.tiff");
		String result = null;
		try {
			result = tesseract.doOCR(file);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}


	
	private static Tesseract getTesseract() {
		Tesseract instance = new Tesseract();
		instance.setDatapath("/home/eduardo/eclipse-workspace/ocr/work/tessdata");
		instance.setLanguage("eng");
		instance.setHocr(true);
		return instance;
	}
}
