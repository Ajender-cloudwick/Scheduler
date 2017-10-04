
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class scheudlerjavaparser {

    private static final String filePathNonShared = "/Users/AjenderNeelam/IdeaProjects/schedulerjsonparser/src/main/resources/nonshared.json";
    private static final String filePathShared = "/Users/AjenderNeelam/IdeaProjects/schedulerjsonparser/src/main/resources/sharedcluster.json";

    public static void main(String[] args) {
     //   new schedulerParser(filePathNonShared);
        new NonSharedSchedulerParser(filePathNonShared);
        new SharedClusterSchedulerParser(filePathShared) ;

    }

}