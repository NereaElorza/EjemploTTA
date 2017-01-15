package appejemplo.tta.intel.ehu.eus.appejemplo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by nerea on 15/01/17.
 */
public class Data {
    private RestClient restClient;
    private String server = "http://u017633.ehu.eus:28080/ServidorTta/rest/tta/";

    private int id;
    private String name;
    private int lessonNum;
    private String lessonTit;
    private int nextTest;
    private int nextExercise;

    private String wording;
   // private String choice;

    public Data(){

    }

    public User user (String dni) throws IOException, JSONException {
      JSONObject json = restClient.getJson(String .format("getStatus?dni=%d",dni));

      id = json.getInt("id");
      name = json.getString("name");
      lessonNum= json.getInt("lessonNum");
      lessonTit= json.getString("lessonTit");
      nextTest=json.getInt("nextTest");
      nextExercise=json.getInt("nextExercise");

      User status = new User(id, name, lessonNum, lessonTit, nextTest, nextExercise);
      return status;
  }
    public Test test() throws IOException, JSONException {
        JSONObject json = restClient.getJson(String.format("getTest?id=1"));
        wording = json.getString("wording");
        JSONArray array = new JSONArray();
        //choice es un array

        Test t = new Test(wording,wording);//wording y choice
        return t;
    }

    public Exercise exercise() throws IOException, JSONException {
        JSONObject json = restClient.getJson(String.format("getExercise?id=1"));
        wording = json.getString("wording");
        id = json.getInt("id");

        Exercise e = new Exercise(id,wording);//wording y choice
        return e;
    }
}
