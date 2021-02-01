//dbUtils.java

package com.tcs.dbutils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;


public class dbUtils {
	
	public static DB dbGetDatabase(String server, int port, String dbName)
	 {
		 
		MongoClient mongo = new MongoClient(server, port);
	     DB db = mongo.getDB(dbName);
		 
		 return db;
	 }

	 public static JSONObject dbGetDoument(DB db, String CollectionName, int version, String filePath) throws FileNotFoundException, IOException, ParseException
	 {
		 
		 
		 DBCollection collection = db.getCollection(CollectionName);
		 BasicDBObject query = new BasicDBObject();
	     
	     query.put("version", version );
	     DBCursor cursor = collection.find(query);
	     
	     JSON json =new JSON();
	     @SuppressWarnings({ "static-access" })
		String serialize = json.serialize(cursor);//make sure string is not empty or null
	     JsonElement jelement = new JsonParser().parse(serialize);
	     JsonArray  jArray = jelement.getAsJsonArray();
	     
	     JSONObject  jsonObject = new JSONObject ();
	     jsonObject.put("Test",jArray);   
	     
	     try {
	         FileWriter file = new FileWriter(filePath);
	         file.write(jsonObject.toJSONString());
	         file.close();
	     	} catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	     	}

	     	Object jsonobj = new JSONParser().parse(new FileReader(filePath));
	     	JSONObject jo = (JSONObject) jsonobj;
	     	@SuppressWarnings("unchecked")
			List<Object> TextName =  (List<Object>) jo.get("Test");
	     	JSONObject getJson = new JSONObject();
	     	getJson = (JSONObject) TextName.get(0);
	     	
	     	return getJson;

	 }
	    
	 public static String dbGetElement(JSONObject document, String screenName, String elementName, String element)
	 {
		 JSONObject loginScreen = (JSONObject) document.get(screenName);
	     
	     JSONObject elementObj = (JSONObject) loginScreen.get(elementName);
	     
	     String elementVal = (String) elementObj.get(element);
	     
	     return elementVal;
	 }
	    
	 /****************************************************************************/
	     
	 public static void InsertJsonData(DBCollection collection, String filePath) throws FileNotFoundException, IOException, ParseException{
	    	Object obj = new JSONParser().parse(new FileReader(filePath));
	        DBObject object = (DBObject) JSON.parse(obj.toString());
	        collection.insert(object);
	    }
	 

}
