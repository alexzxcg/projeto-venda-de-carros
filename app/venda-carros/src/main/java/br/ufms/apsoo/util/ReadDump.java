package br.ufms.apsoo.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDump {
  JSONParser parser = new JSONParser();

  public ReadDump() {
  }

  public JSONArray getJsonArray(Path file, String field) {

    try (Reader reader = new FileReader(file.toString())) {

      JSONObject jsonObject = (JSONObject) parser.parse(reader);
      // loop array
      return (JSONArray) jsonObject.get(field);
      // Iterator<String> iterator = msg.iterator();
      // while (iterator.hasNext()) {
      //   System.out.println(iterator.next());
      // }

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }

    // InputStream is = ReadDump.class.getResourceAsStream(file);
    // if (is == null) {
    // throw new NullPointerException("Cannot find resource file " + file);
    // }
    // String text = IOUtils.toString(is, "UTF-8");
    // JSONObject object = new JSONObject(text);
    // return object.getJSONArray(field);
  }

  public String getValueStr(JSONObject object, String key) {
    return (String) object.get(key);
    // return object.getString(key);
  }

  public int getValueInt(JSONObject object, String key) {
    return (int) object.get(key);
    // return object.getInt(key);
  }

  public double getValueDouble(JSONObject object, String key) {
    return (double) object.get(key);
    // return object.getDouble(key);
  }
}