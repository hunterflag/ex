package tw.idv.hunterchen.lab.iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ex_Stream {

	public static void dump(InputStream inputStream, OutputStream outputStream) 
			throws IOException {
		byte[] data = new byte[128];
		int length = 0;
		int sum = 0;
		while((length = inputStream.read(data)) != -1) {
			sum += length;
			System.err.printf("%s: %d, and sum: %d%n", "dump size", length, sum);
			outputStream.write(data, 0, length);
		}
		
	}
	public static void filePadding(File file, char paddingChar, int paddingSize) {
			try {
				FileOutputStream lFileOutputStream = new FileOutputStream(file, true);
				OutputStreamWriter lOutputStreamWriter = new OutputStreamWriter(lFileOutputStream);
				BufferedWriter lBufferedWriter = new BufferedWriter(lOutputStreamWriter);
				for(int i=0; i<paddingSize; i++) {
					lBufferedWriter.append(paddingChar);
				}
//				lBufferedWriter.flush();
				lBufferedWriter.close();
//				lOutputStreamWriter.close();
//				lFileOutputStream.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public static void aesFilePadding(File file, int divisor ) {
		int size = divisor - (int) (file.length() % divisor);
		filePadding(file, '4', size);
	}

	public static void aesFilePadding(String filePath, int divisor ) {
		File file = new File(filePath);
		int size = divisor - (int) (file.length() % divisor);
		try {
			FileWriter writer = new FileWriter(file, true);
			for (int i=0; i<size; i++) {
				writer.append('f');
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) 
			throws IOException {
		String inputFileName  = "d:\\temp\\ioStream\\input.temp.utf8.txt";
		String outputFileName = "d:\\temp\\ioStream\\output.temp.txt";
		File lInputFile = new File(inputFileName);
		File lOutputFile = new File(outputFileName);
//		FileInputStream  fis = new FileInputStream(lInputFile);
//		FileOutputStream fos = new FileOutputStream(outputFileName); 
//		
//		lFile.getTotalSpace();
		/*
		FileInputStream fis = new FileInputStream(testFileName);
		*/
//		Ex_Stream.dump(fis, System.out);

		//		System.err.printf("%n%d", lFile.length());
//		System.err.printf("\n%d", lInputFile.length());
//		
//		int paddingSize = (int) (lInputFile.length() % 16);
//		System.err.printf("\n%s: %d", "paddingSize", paddingSize);
//		Ex_Stream.dump(fis, fos);
//		for(int i=0; i<paddingSize; i++) {
//			System.out.printf("%n%s: %d", "counter", i);
//			fos.write(0);
//			
//		}
//		
//		fos.flush();
//		fos.close();
//		
//		Ex_Stream.filePadding(lOutputFile, '2', 12);
//		Ex_Stream.aesFilePadding(lOutputFile, 17);
		Ex_Stream.aesFilePadding(outputFileName, 17);
		
	}

}
