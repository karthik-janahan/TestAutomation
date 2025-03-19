package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Properties;

public class ReadproperfyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fReader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		Properties p = new Properties();
		p.load(fReader);
		p.getProperty("browser");
		//p.getProperty("testurl");
		System.out.println(fReader);
	}

}
