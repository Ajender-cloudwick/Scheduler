
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class scheudlerjavaparser {

    private static final String filePathNonShared = "/Users/AjenderNeelam/IdeaProjects/schedulerjsonparser/src/main/resources/nonshared.json";
    private static final String filePathShared = "/Users/AjenderNeelam/IdeaProjects/schedulerjsonparser/src/main/resources/sharedcluster.json";
    private static final String url = "http://ec2-34-207-185-229.compute-1.amazonaws.com:8088/ws/v1/cluster/scheduler";
    public static void main(String[] args) throws IOException, ParseException {

        //  new schedulerParser(filePathNonShared);
        //  new NonSharedSchedulerParser(filePathNonShared) ;
        //  new SharedClusterSchedulerParser(filePathShared) ;
        //  new NonSharedShedulerCurlparser(urlNonShared);
        //  new SharedScheulerCurlParser(url);

    }
}

