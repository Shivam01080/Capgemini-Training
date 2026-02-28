package Capg;
import java.io.*;
public class RAccessdemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("data.txt", "r");
		long length = file.length();

        for (long i = length - 2; i < length; i++) {
            file.seek(i);             
            int ch = file.read();      
            System.out.print((char) ch);
        }

        file.close();
    }
}

