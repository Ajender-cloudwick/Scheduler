import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by AjenderNeelam on 10/5/17.
 */
public class NonSharedShedulerCurlparser {
 public NonSharedShedulerCurlparser(String url){
     try {
     URL scheduler_url = new URL(url);
     URLConnection yc = scheduler_url.openConnection();
     String result = "";
     JSONArray jArray = null;
     BufferedReader in = new BufferedReader(new InputStreamReader(
             yc.getInputStream()));
     StringBuilder sb = new StringBuilder();
     String inputLine;
     while ((inputLine = in.readLine()) != null) {

         sb.append(inputLine);
         //System.out.println("sb is"+ in );
     }
     in.close();
     result = sb.toString();
     JSONParser parser = new JSONParser();
     JSONObject json = (JSONObject) parser.parse(result);
     //System.out.println(json);
     JSONObject schd=(JSONObject) json.get("scheduler");
     // System.out.println("schd is "+schd);

     JSONObject schdinfo= (JSONObject) schd.get("schedulerInfo");
     // System.out.println("schdinfo is "+schdinfo);

     String val = (String) schdinfo.get("type");
     // System.out.println("type is "+val);

     JSONObject queues = (JSONObject) schdinfo.get("queues");
     //System.out.println("queues is "+queues);

     JSONArray queue =  (JSONArray)queues.get("queue");
     // System.out.println("queue is " +queue);
     for(Object projectObj: queue.toArray()){
         JSONObject project = (JSONObject)projectObj;
         String qname = (String) project.get("queueName");
         //     System.out.println("qname is " +qname);
         JSONObject usedres = (JSONObject)((JSONObject) projectObj).get("resourcesUsed");
         //     System.out.println(usedres);
         Long cores = (Long) usedres.get("vCores");
         Long memory = (Long) usedres.get("memory");
         System.out.println(qname + "            " + cores +"                "+ memory);
     }
     // JSONArray val1 = (JSONArray) queue.get(0);
     //System.out.println("val is " +val1);

     //   JSONObject queue = (JSONObject) schdinfo.get("queue");
     //   System.out.println("queue is "+queue);
     } catch (ParseException e) {
         e.printStackTrace();
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}
