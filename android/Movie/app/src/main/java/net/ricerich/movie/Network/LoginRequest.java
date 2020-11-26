package net.ricerich.movie.Network;

import android.os.AsyncTask;
import android.widget.Toast;

import net.ricerich.movie.Custom_Adapter;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginRequest extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Adress = "http://10.100.103.21/movieApp/movie_login.jsp";
    //    private String URL_Adress = "http://211.104.196.146:8006/movieApp/movie_insert.jsp";
//    private Custom_Adapter adapter;
//
//    public LoginRequest(Custom_Adapter adapter) {
//        this.adapter = adapter;
//    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        // 로그인 구현

        String res = "";

        try {
            Url = new URL(URL_Adress);
            HttpURLConnection con = (HttpURLConnection) Url.openConnection();

            con.setDefaultUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            StringBuffer buffer = new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);
            buffer.append("&password").append("=").append(strings[1]);

            OutputStreamWriter outStream = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line;
            while((line = in.readLine()) != null) {
                builder.append(line + "\n");
            }

            res = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        int res = 0;
        try {
            res = JsonParser.getResultJson(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(res == 0) {

        } else {

        }
    }
}
