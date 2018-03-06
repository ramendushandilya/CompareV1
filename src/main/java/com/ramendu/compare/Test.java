package com.ramendu.compare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://affiliate-api.flipkart.net/affiliate/api/ramendu98.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Fk-Affiliate-Id", "ramendu98");
            connection.setRequestProperty("Fk-Affiliate-Token", "acbfa63280704742bdcb1c3d30de0b9e");

            if(connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error Code :"+ connection.getResponseCode());
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String output;

            System.out.println("Output from the endpoint");
            while ((output = reader.readLine()) != null) {
                System.out.println(output);
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
