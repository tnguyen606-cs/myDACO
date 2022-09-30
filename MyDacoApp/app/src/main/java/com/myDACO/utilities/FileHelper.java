package com.myDACO.utilities;

import android.media.Image;

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
        Set<Users> setUsers = new HashSet<>();
        try {
            JSONArray jsonArray = convertJSONtoArray(inputStream, "data");
            //Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String username = jsonObject.optString("username");
                String pss = jsonObject.optString("password");
                String name = jsonObject.optString("name");
                String id = jsonObject.optString("id");
                Users user = new Users(id, username, pss);
                user.setName(name);
                setUsers.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return setUsers;
    }

    public List<Planes> toList(InputStream inputStream) {
        List<Planes> list = new ArrayList<Planes>();
        try {
            JSONArray jsonArray = convertJSONtoArray(inputStream, "planes");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.optString("name");
                String[] cargo = jsonObject.op
                Planes plane = new Planes(name, i);
                list.add(plane);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void remove(List<Planes> list, int position) {
        JSONArray newJ_Array = new JSONArray();
        try {
            int i = 0;
            do {
                if (i == position) {
                    Planes rm = list.remove(i);
                    System.out.println(rm.getPlane());
                } else {
                    JSONObject formDetailsJson = new JSONObject();

                    newJ_Array.put(list.get(i));
                }
            } while (i < list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected JSONArray convertJSONtoArray(InputStream inputStream, String data) {
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
            e.printStackTrace();
        }
        return null;
    }
}
