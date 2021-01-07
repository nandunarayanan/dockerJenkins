import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.google.common.io.ByteStreams;

public class yamlLib
{
	public static void yamlWrite( Map<String, Object> map, String path) throws IOException
    {
		Yaml yaml = new Yaml();
		yamlLib yamlWrt = new yamlLib();
    	
    	
    	FileWriter writer = new FileWriter(path);
    	yaml.dump(map, writer);
    	
    }
	
	public static Map<String, String> yamlRead(String FilePath) throws IOException
    {
    	Yaml yaml = new Yaml();
    	yamlLib yamlWrite = new yamlLib();
    	
    	Map<String, String> map = (Map<String, String>) yaml.load(new FileInputStream(new File(FilePath)));
    	return map;
    }
}