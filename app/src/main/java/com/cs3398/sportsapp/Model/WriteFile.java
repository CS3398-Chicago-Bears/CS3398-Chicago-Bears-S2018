import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteFile {
	public static void serializeDataOut(User userData)throws IOException{
	    String fileName= "Database.txt";
	    FileOutputStream fos = new FileOutputStream(fileName);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(userData);
	    oos.close();
	}

	public static User serializeDataIn() throws IOException, ClassNotFoundException {
	   String fileName= "Database.txt";
	   FileInputStream fin = new FileInputStream(fileName);
	   ObjectInputStream ois = new ObjectInputStream(fin);
	   User user= (User) ois.readObject();
	   ois.close();
	   return user;
	}
}
