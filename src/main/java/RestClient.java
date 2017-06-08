import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
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

           for(int i=0;i<10;i++){

                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpPost postRequest = new HttpPost(
                        "http://localhost:8080/band");

                ArrayList<NameValuePair> postParameters;

                postParameters = new ArrayList<NameValuePair>();

                Random rand = new Random();

                Integer  step = rand.nextInt(50) + 1;
                Integer bpms = rand.nextInt(39)+52;
                Integer distances = rand.nextInt(4)+1;
                Integer latitude = rand.nextInt(100)+1;
                Integer longitude = rand.nextInt(100)+1;
                Integer calories =rand.nextInt(20)+5;
              //  Date fechanueva=new Date(2017,6,8);

                postParameters.add(new BasicNameValuePair("steps",step.toString()));
                postParameters.add(new BasicNameValuePair("bpm", bpms.toString()));
                postParameters.add(new BasicNameValuePair("distance", distances.toString()));
                postParameters.add(new BasicNameValuePair("fecha_registro", new Date(2017,6,8).toString()));
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


            for(int i=0;i<10;i++){

                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpPost postRequest2 = new HttpPost(
                        "http://localhost:8080/band");


                ArrayList<NameValuePair> postParameters2;


                postParameters2=new ArrayList<NameValuePair>();

                Random rand = new Random();


                Integer  step2 = 1;
                Integer bpms2 = 1;
                Integer distances2 = 1;
                Integer latitude2 = rand.nextInt(100)+1;
                Integer longitude2 = rand.nextInt(100)+1;
                Integer calories2 =1;
               // Date newDate2=

                postParameters2.add(new BasicNameValuePair("steps",step2.toString()));
                postParameters2.add(new BasicNameValuePair("bpm", bpms2.toString()));
                postParameters2.add(new BasicNameValuePair("distance", distances2.toString()));
                postParameters2.add(new BasicNameValuePair("fecha_registro", new Date(2017,6,7).toString()));
                postParameters2.add(new BasicNameValuePair("latitude", latitude2.toString()));
                postParameters2.add(new BasicNameValuePair("longitude", longitude2.toString()));
                postParameters2.add(new BasicNameValuePair("calories", calories2.toString()));
                postParameters2.add(new BasicNameValuePair("user", "1"));




                postRequest2.setEntity(new UrlEncodedFormEntity(postParameters2));
                postRequest2.addHeader("accept", "application/json");


                HttpResponse response2 = httpClient.execute(postRequest2);

                if (response2.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "

                            + response2.getStatusLine().getStatusCode());

                }


                BufferedReader br2 = new BufferedReader(
                        new InputStreamReader((response2.getEntity().getContent())));

                String output2;
                System.out.println("Output 2 from Server .... \n");
                while ((output2 = br2.readLine()) != null ) {

                    System.out.println(output2);
                }
                httpClient.getConnectionManager().shutdown();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            for(int i=0;i<1;i++){

                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpPost postRequest2 = new HttpPost(
                        "http://localhost:8080/band");


                ArrayList<NameValuePair> postParameters2;


                postParameters2=new ArrayList<NameValuePair>();

                Random rand = new Random();


                Integer  step2 = 1;
                Integer bpms2 = 1;
                Integer distances2 = 1;
                Integer latitude2 = 2000;
                Integer longitude2 = 1001;
                Integer calories2 =1;
                // Date newDate2=

                postParameters2.add(new BasicNameValuePair("steps",step2.toString()));
                postParameters2.add(new BasicNameValuePair("bpm", bpms2.toString()));
                postParameters2.add(new BasicNameValuePair("distance", distances2.toString()));
                postParameters2.add(new BasicNameValuePair("fecha_registro", new Date(2017,6,7).toString()));
                postParameters2.add(new BasicNameValuePair("latitude", latitude2.toString()));
                postParameters2.add(new BasicNameValuePair("longitude", longitude2.toString()));
                postParameters2.add(new BasicNameValuePair("calories", calories2.toString()));
                postParameters2.add(new BasicNameValuePair("user", "1"));




                postRequest2.setEntity(new UrlEncodedFormEntity(postParameters2));
                postRequest2.addHeader("accept", "application/json");


                HttpResponse response2 = httpClient.execute(postRequest2);

                if (response2.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "

                            + response2.getStatusLine().getStatusCode());

                }


                BufferedReader br2 = new BufferedReader(
                        new InputStreamReader((response2.getEntity().getContent())));

                String output2;
                System.out.println("Output 2 from Server .... \n");
                while ((output2 = br2.readLine()) != null ) {

                    System.out.println(output2);
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