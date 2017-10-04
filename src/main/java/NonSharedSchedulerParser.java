import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AjenderNeelam on 10/4/17.
 */
public class NonSharedSchedulerParser {
    NonSharedSchedulerParser(String filePath) {
        try {
            // read the json file
            FileReader reader = new FileReader(filePath);
            System.out.println("qname" + "          " + "cores_used" +"         "+ "memory_used" + "   of non shared cluster");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            // get an array from the JSON object

            JSONObject schd=(JSONObject) jsonObject.get("scheduler");
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
