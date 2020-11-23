package net.ricerich.movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    static public int getUserInfoJson(String response, ArrayList<UserInfo> userList) throws JSONException {
        String strID, strName, strPasswd, strWriteTime;

        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);

            if(jsonObj.getString("ID").toString().equals("null"))
                strID = "-";
            else
                strID = jsonObj.getString("ID").toString();

            if(jsonObj.getString("NAME").toString().equals("null"))
                strName = "-";
            else
                strName = jsonObj.getString("NAME").toString();

            if(jsonObj.getString("PASSWORD").toString().equals("null"))
                strPasswd = "-";
            else
                strPasswd = jsonObj.getString("PASSWORD").toString();

            if(jsonObj.getString("WRITE_TIME").toString().equals("null"))
                strWriteTime = "-";
            else {
                strWriteTime = jsonObj.getString("WRITE_TIME").toString();
                String temp[] = strWriteTime.split(" ");
                strWriteTime = temp[0] + "\n" + temp[1];
            }
            userList.add(new UserInfo(strID, strName, strPasswd, strWriteTime));
        }
        return jsonArray.length();
    }
    static public int getResultJson(String response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }
}