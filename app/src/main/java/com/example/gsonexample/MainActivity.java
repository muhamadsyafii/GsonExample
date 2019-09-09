package com.example.gsonexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<DataGson> gsonList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GsonAdapter gsonAdapter;
    private Gson gson;
//    private JSONObjecject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.gson_view);
        gsonAdapter = new GsonAdapter(gsonList);
        RecyclerView.LayoutManager gLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gLayoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gsonAdapter);

        actiongsonrecycle();
    }

    private void actiongsonrecycle() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://v1.api.1gate.jp/tenants?api_id=fff563a6-783d-49a3-a9eb-876a0f951bdd";

        StringRequest stringRequest =  new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;

                        try {
                            jsonObject = new JSONObject(response);
                            DataGson dataGson = gson.fromJson(jsonObject.get("tenants").toString(),DataGson.class);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }


//                        DataGson dataGson = gson.fromJson(jsonObject.get("tenants").toString(),DataGson.class);
//
                        Log.e("Respone", response);
//
//                            JSONObject object = new JSONObject(response);
//                            DataGson dataGson = gson.fromJson(jsonObject.getJSONObject("tenant").toString(),DataGson.class);
//                            String name = dataGson.getImg();
                        //                        GsonBuilder gsonBuilder = new GsonBuilder();
//                        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//                        gson = gsonBuilder.create();


//                        try {
//                            membaca pembuka json
//                            JSONObject object = new JSONObject(response);
//                            JSONArray arrayTenant = object.getJSONArray("tenants");
//                            for (int i = 0; i < arrayTenant.length(); i++) {
//                                JSONObject item = arrayTenant.getJSONObject(i);
//                                JSONObject category = item.getJSONObject("category");
//                                JSONObject properties = item.getJSONObject("properties");
//                                JSONObject logo = properties.getJSONObject("logo");
//                                JSONObject value = logo.getJSONObject("value");
//                                Array
//                                String flooor = "";
//                                JSONArray arrayFloor = item.getJSONArray("floors");
//                                for (int a = 0; a < arrayFloor.length(); a++){
//                                    JSONObject floor = arrayFloor.getJSONObject(a);
//                                    flooor = flooor.concat(floor.getString("name"));
//                                }
//                                DataGson dataGson = new DataGson();
//                                dataGson.setImg(dataGson.getString("url"));
//                               dataGson.setNama(item.getString("name"));
//                               gsonList.add(dataGson);

//                            }
//                            gsonAdapter.notifyDataSetChanged();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
                Log.e("Error","Reesult"+error.getMessage());
            }
        })
        {
            private JSONObject jsonObject;

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header=new HashMap<>();
                header.put("X-Api-Key","eP134CM1kN5oTnsMztdokhs6");
                return header;
            }
        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}