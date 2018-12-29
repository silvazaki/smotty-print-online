package com.starcom.smotty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.starcom.smotty.app.AppController;
import com.starcom.smotty.data.Data;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    public String username;
    int success;
    private EditText txtuser, txtpass;

    private static final String TAG = LoginActivity.class.getSimpleName();

    Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtuser = (EditText) findViewById(R.id.txtuser);
        txtpass = (EditText) findViewById(R.id.txtpassword);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void masuk(View view) {
//        String user=txtuser.getText().toString(),pass=txtpass.getText().toString();
//        login(user,pass);
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }


    private void login(final String user, final String pass) {

        StringRequest strReq = new StringRequest(Request.Method.POST, data.url_login, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(data.TAG_SUCCESS);

                    if (success == 1) {
                        Toast.makeText(LoginActivity.this, jObj.getString(data.TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, jObj.getString(data.TAG_MESSAGE)+" "+txtuser.getText().toString(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("id",txtuser.getText().toString());
                        startActivity(i);
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                username = txtuser.getText().toString();
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(LoginActivity.this, error.getMessage()+username, Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", user);
                params.put("pass", pass);

                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(strReq, data.tag_json_obj);
    }

}