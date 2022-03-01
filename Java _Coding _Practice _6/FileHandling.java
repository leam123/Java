import java.io.*;

//Serialization
public class FileHandling{
	public boolean serialize(String file, Object obj){
		boolean ok = false;
		try{
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(obj);
			out.close();
			fout.close();
			ok = true;
		}catch(IOException ie){}

		return ok;
	}
	public Object deserialize(String file) throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fin);
		Object obj = in.readObject();
		in.close();

		return obj;
	}
}