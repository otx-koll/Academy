package net.ricerich.clientnetdb.Network;

import android.os.AsyncTask;
import android.util.Log;

import net.ricerich.clientnetdb.Custom_Adapter;
import net.ricerich.clientnetdb.UserInfo;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NetworkSearch extends AsyncTask<String, Void, String> {
    private URL Url;
    //    private String URL_Adress = "http://10.100.103.21/testWeb/testDB3_search.jsp";
    private String URL_Adress = "http://211.104.196.146:8006/testWeb/testDB3_search.jsp";
    private Custom_Adapter adapter;

    public NetworkSearch(Custom_Adapter adapter){
        this.adapter = adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";

        try {
            Url = new URL(URL_Adress);
            HttpURLConnection con = (HttpURLConnection) Url.openConnection();

            // 전송모드 설정
            con.setDefaultUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            // content-type 설정
            // 텍스트만 전송할 때 사용
            con.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            // 전송값 설정
            StringBuffer buffer = new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);

            // 서버로 전송
            OutputStreamWriter outStream = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line + "\n");
            }
            res = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("Get result", res);
        return res; // return Result // 자동으로 onPostExecute의 string으로 들어간다. 그럼 String s의 s겠네
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        ArrayList<UserInfo> userList = new ArrayList<UserInfo>(); // 데이터 받을 곳
        int count = 0;
        try {
            count = JsonParser.getUserInfoJson(s, userList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(count == 0) {
        } else {
            adapter.setDatas(userList);
            adapter.notifyDataSetInvalidated();
        }
    }
}
