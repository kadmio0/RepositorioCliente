

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class RestClient {
    public static void main(String[] args) {
        try {

            while(true){

                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpPost postRequest = new HttpPost(
                        "http://localhost:8080/band");

                ArrayList<NameValuePair> postParameters;

                postParameters = new ArrayList<NameValuePair>();
                Random rand = new Random();

                Integer  step = rand.nextInt(50) + 1;
                Integer bpms = rand.nextInt(39)+52;
                Integer distances = rand.nextInt(4)+1;
                Float latitude = rand.nextFloat()*7+3;
                Float longitude = rand.nextFloat()*10+5;
                Integer calories =rand.nextInt(20)+5;

                postParameters.add(new BasicNameValuePair("steps",step.toString()));
                postParameters.add(new BasicNameValuePair("bpm", bpms.toString()));
                postParameters.add(new BasicNameValuePair("distance", distances.toString()));
                postParameters.add(new BasicNameValuePair("latitude", latitude.toString()));
                postParameters.add(new BasicNameValuePair("longitude", longitude.toString()));
                postParameters.add(new BasicNameValuePair("calories", calories.toString()));
                postParameters.add(new BasicNameValuePair("user", "1"));

                postRequest.setEntity(new UrlEncodedFormEntity(postParameters));
                postRequest.addHeader("accept", "application/json");

                HttpResponse response = httpClient.execute(postRequest);

                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatusLine().getStatusCode());
                }

                BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
                httpClient.getConnectionManager().shutdown();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }




        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}