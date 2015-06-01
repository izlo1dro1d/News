package kz.kbtu.news;

import android.app.FragmentManager;
import java.io.IOException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kaisabekov on 25.05.2015.
 */

public class MainActivity extends FragmentActivity {


    static final int NUMBER_OF_LIST = 4;
    MyAdapter mAdapter;
    ViewPager mPager;
    private static FragmentManager fragmentManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
        fragmentManager = getFragmentManager();
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        load_clubs();
        load_oth();
        load_rest();
        load_sushi();
    }



    public void load_clubs(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("http://nightmovement.kz/get_clubs.php");
                    HttpEntity httpEntity = null;
                    HttpResponse httpResponse = null;
                    try{
                        httpResponse = httpClient.execute(httpGet);
                        httpEntity = httpResponse.getEntity();
                        String ans = EntityUtils.toString(httpEntity);

                        JSONArray jsonArray = new JSONArray(ans);
                        JSONObject jsonObject;
                        for(int i=0;i<jsonArray.length();i++){
                            try {
                                jsonObject = (JSONObject) jsonArray.get(i);
                                News.Clubs[i] = jsonObject.getString("shot");
                                News.Clubs_f[i] = jsonObject.getString("full");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        long cnt=0;
        thread.start();
        while(thread.isAlive()){
            cnt++;
        }

    }
    public void load_rest(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("http://nightmovement.kz/get_restorans.php");
                    HttpEntity httpEntity = null;
                    HttpResponse httpResponse = null;
                    try{
                        httpResponse = httpClient.execute(httpGet);
                        httpEntity = httpResponse.getEntity();
                        String ans = EntityUtils.toString(httpEntity);

                        JSONArray jsonArray = new JSONArray(ans);
                        JSONObject jsonObject;
                        for(int i=0;i<jsonArray.length();i++){
                            try {
                                jsonObject = (JSONObject) jsonArray.get(i);
                                News.Restorans[i] = jsonObject.getString("shot");
                                News.Restorans_f[i] = jsonObject.getString("full");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        long cnt=0;
        thread.start();
        while(thread.isAlive()){
            cnt++;
        }

    }
    public void load_sushi(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("http://nightmovement.kz/get_sushi.php");
                    HttpEntity httpEntity = null;
                    HttpResponse httpResponse = null;
                    try{
                        httpResponse = httpClient.execute(httpGet);
                        httpEntity = httpResponse.getEntity();
                        String ans = EntityUtils.toString(httpEntity);

                        JSONArray jsonArray = new JSONArray(ans);
                        JSONObject jsonObject;
                        for(int i=0;i<jsonArray.length();i++){
                            try {
                                jsonObject = (JSONObject) jsonArray.get(i);
                                News.Sushi[i] = jsonObject.getString("shot");
                                News.Sushi_f[i] = jsonObject.getString("full");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        long cnt=0;
        thread.start();
        while(thread.isAlive()){
            cnt++;
        }

    }
    public void load_oth(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("http://nightmovement.kz/get_other.php");
                    HttpEntity httpEntity = null;
                    HttpResponse httpResponse = null;
                    try{
                        httpResponse = httpClient.execute(httpGet);
                        httpEntity = httpResponse.getEntity();
                        String ans = EntityUtils.toString(httpEntity);

                        JSONArray jsonArray = new JSONArray(ans);
                        JSONObject jsonObject;
                        for(int i=0;i<jsonArray.length();i++){
                            try {
                                jsonObject = (JSONObject) jsonArray.get(i);
                                News.Other[i] = jsonObject.getString("shot");
                                News.Other_f[i] = jsonObject.getString("full");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        long cnt=0;
        thread.start();
        while(thread.isAlive()){
            cnt++;
        }

    }

}