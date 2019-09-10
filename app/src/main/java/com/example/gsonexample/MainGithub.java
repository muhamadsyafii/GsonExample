package com.example.gsonexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class MainGithub extends AppCompatActivity {

    private static final String BASE_URL = "https://api.github.com/search/users?q=";
    private RecyclerView userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_github);
        userList = findViewById(R.id.userList);
        userList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false ));
        Button btn = findViewById(R.id.btnsearch);
        final EditText editText = findViewById(R.id.editsearch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cari(editText.getText().toString());
            }
        });
    }

    public void cari(String keyword) {
        String url = BASE_URL + keyword;
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("respone", response);
                try {
                    JSONObject object = new JSONObject(response);
                    Gson gson = new Gson();
                    List<User> users = Arrays.asList(gson.fromJson(object.getString("items"), User[].class));
                    userList.setAdapter(new GithubAdapter(MainGithub.this, users));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainGithub.this, "Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}