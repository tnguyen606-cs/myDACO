package com.myDACO.utilities;

import android.app.Activity;
import android.media.Image;
import android.util.JsonWriter;
import android.util.Log;
import android.widget.Toast;

import com.myDACO.R;
import com.myDACO.data.Planes;
import com.myDACO.data.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileHelper {
    // JSON Node names
    private final String TAG_NAME = "name";
    private final String TAG_USERNAME = "username";
    private final String TAG_PASSWORD = "password";
    private final String TAG_ID = "id";
    private final String TAG_ACTIVE = "Active";
    private final String TAG_CARGO = "cargos";
    private final String TAG_PERSONNEL = "personnel";

    public Set<Users> getUserResource(InputStream inputStream) {
        Set<Users> setUsers = new HashSet<>();
        try {
            JSONArray jsonArray = convertJSONtoArray(inputStream, "data");
            //Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String username = jsonObject.optString(TAG_USERNAME);
                String pss = jsonObject.optString(TAG_PASSWORD);
                String name = jsonObject.optString(TAG_NAME);
                String id = jsonObject.optString(TAG_ID);
                Users user = new Users(id, name, username, pss);
                setUsers.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return setUsers;
    }

    public List<Planes> toList(JSONArray jsonArray) {
        List<Planes> list = new ArrayList<Planes>();
        try {
            /** Add each of Plane Obj to the Plane List */
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.optString(TAG_NAME);
                String id = jsonObject.optString(TAG_ID);
                boolean isActive = jsonObject.optBoolean(TAG_ACTIVE);
                // If your json string is an array, use JSONArray
                JSONArray cargos = jsonObject.getJSONArray(TAG_CARGO);
                JSONArray personnel = jsonObject.getJSONArray(TAG_PERSONNEL);
                // To get the items from the array from "getItemsArray" helper method
                Planes plane = new Planes(name, id, isActive, getItemsArray(cargos), getItemsArray(personnel));
                list.add(plane);
            }
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data as converting to List  " + e.toString());
        }
        return list;
    }

    public JSONArray convertJSONtoArray(InputStream inputStream, String data) {
        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String strJson = new String(buffer, "UTF-8");
            // Create the root JSONObject from the JSON string.
            JSONObject jsonRootObject = new JSONObject(strJson);
            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.getJSONArray(data);
            return jsonArray;
        } catch (JSONException | IOException e) {
            Log.e("JSON Parser", "Error extracting data from JSON file " + e.toString());
        }
        return null;
    }

    protected List<String> getItemsArray(JSONArray jArray) {
        List<String> l = new ArrayList<>();
        for (int i = 0; i < jArray.length(); i++)
        {
            try {
                String oneItem = jArray.getString(i);
                l.add(oneItem);
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data an array of a json item " + e.toString());
            }
        }
        return l;
    }
}
