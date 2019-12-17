package com.example.apivolleypost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    RecyclerView rv;
    RequestQueue requestQueue;
    EditText editText;
    Button button;
    private List<personlist> list;
    String u_name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        editText=findViewById(R.id.edit_text);
        button=findViewById(R.id.button);
        rv=findViewById(R.id.rv1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

        Submit();
            }
        });
    }

    private void Submit()
    {
        String url="https://mutable-villages.000webhostapp.com/test_post.php";

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.d("HELLO", String.valueOf(response));
                rv=findViewById(R.id.rv1);
                RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(list);
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rv.setAdapter(recyclerViewAdapter);
            }


        },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
              Log.d("error",error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("u_name",editText.getText().toString());
                return map;
            }
        };
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
