package com.bluoh.utils;


import com.bluoh.model.Notification;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashutosh on 26-09-2016.
 */
public class Util {

    public static String sendNotification(Notification notification){

        final String apiKey = "AIzaSyBcKII4bmIodWmM2MRDei4R3-QQ3QRTKiw";
        final String fcmUrl = "https://fcm.googleapis.com/fcm/send";

        try {

            URL url = new URL(fcmUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + apiKey);

            conn.setDoOutput(true);

            String input = new JSONObject(notification).toString();

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("\nNotification : " + input);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "error : "+ e.getMessage();
        }
    }

    public static void copyNonNullProperties(Object src, Object target){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
