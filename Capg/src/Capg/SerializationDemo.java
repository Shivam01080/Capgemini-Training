package Capg;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;

//enter roll, enter marks, list all records, give roll and search for marks, no duplicate values


public class SerializationDemo {

	public static void main(String[] args) {
		FileOutputStream fout = new FileOutputStream("empData.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(new Employee(234, "PQRS"));
		oos.writeObject(new Employee(234, "ABCD"));
		oos.close();
		fout.close();
		
		FileInputStream fin = new FileInputStream("empData.bin");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Object ob1 = ois.readObject();
		Object ob2 = ois.readObject();
		ois.close();
		fin.close();
		
	}

}
