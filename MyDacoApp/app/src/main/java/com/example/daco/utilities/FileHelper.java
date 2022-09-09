package com.example.daco.utilities;
import android.widget.Toast;

import com.example.daco.data.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

    public static Map<String, Object> toMap(JSONObject jsonobj)  throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonobj.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }
            else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
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
