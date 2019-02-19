import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {

	/*
	* 4 ways to write files in Java
	*/
	public static void main(String[] args) {
		String data = "TEST STRING DaTA!123321";
		writeUsingFiles(data);
		writeUsingOutputStream(data);
		writeUsingFileWriter(data);
		writeUsingBufferedWriter(data, 1000);
		System.out.println("All files are written");
	}

	private static void writeUsingFiles(String data) {
		try {
			Files.write(Paths.get("file1.txt"), data.getBytes());
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	private static void writeUsingOutputStream(String data) {
		OutputStream os = null;
        try {
            os = new FileOutputStream(new File("file2.txt"));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

	private static void writeUsingFileWriter(String data) {
        File file = new File("file3.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } 

    /*
    * Use it when count of write are more
    * It can help to reduce IO and save time
    */
    private static void writeUsingBufferedWriter(String data, int noOfLines) {
        File file = new File("file4.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine=data+System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}