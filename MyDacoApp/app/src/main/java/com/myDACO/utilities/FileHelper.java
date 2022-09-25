package com.myDACO.utilities;

import com.myDACO.data.Planes;
import com.myDACO.data.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileHelper {
    public Set<Users> getResource(InputStream inputStream) {
        String strJson = null;
        Set<Users> setUsers = new HashSet<>();
        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            strJson = new String(buffer, "UTF-8");
            // Create the root JSONObject from the JSON string.
            JSONObject jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.getJSONArray("data");

            //Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String username = jsonObject.optString("username");
                String pss = jsonObject.optString("password");
                String name = jsonObject.optString("name");
                String id = jsonObject.optString("id");
                Users user = new Users(id, name, username, pss);
                setUsers.add(user);
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return setUsers;
    }

    public List<Planes> toList(InputStream inputStream) {
        String strJson = null;
        List<Planes> list = new ArrayList<Planes>();
        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            strJson = new String(buffer, "UTF-8");
            // Create the root JSONObject from the JSON string.
            JSONObject jsonRootObject = new JSONObject(strJson);
            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.getJSONArray("planes");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.optString("name");
                String id = jsonObject.optString("id");
                Planes plane = new Planes(name, id);
                list.add(plane);
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String concatString(String pre, String post) {
        StringBuilder builder = new StringBuilder();
        builder.append(pre);
        builder.append(" ");
        builder.append(post);
        return  builder.toString();
    }
}
