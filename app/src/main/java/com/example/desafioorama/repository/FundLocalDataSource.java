package com.example.desafioorama.repository;

import android.content.Context;

import com.example.desafioorama.models.FundInformation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;


public class FundLocalDataSource {

    public ArrayList<FundInformation> listFundsInformation = new ArrayList<>();

    public FundLocalDataSource() {
    }

    public void saveCache(Context context, ArrayList<FundInformation> funds) {

        File path = context.getFilesDir();
        File file = new File(path, "fundList.txt");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String JSONObject = gson.toJson(funds);
        String newObject = "{" + "funds" + ":" + JSONObject + "}";
        FileOutputStream fileInputStream;
        try {
            fileInputStream = new FileOutputStream(file);
            fileInputStream.write(newObject.getBytes());
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<FundInformation> getCache(Context context) {
        File path = context.getFilesDir();
        File file = new File(path, "fundList.txt");
        int length = (int) file.length();
        byte[] bytes = new byte[length];

        try {
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contents = new String(bytes);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {

            JSONObject jsonObject = new JSONObject(contents);
            JSONArray jsonArray = jsonObject.getJSONArray("funds");
            ArrayList<FundInformation> listdata = new ArrayList<FundInformation>();

            if (jsonArray != null) {


                for (int i = 0; i < jsonArray.length(); i++) {
                    FundInformation fooFromJson = gson.fromJson(String.valueOf(jsonArray.get(i)), FundInformation.class);
                    listdata.add(fooFromJson);
                }
                listFundsInformation.addAll(listdata);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listFundsInformation;

    }

}
