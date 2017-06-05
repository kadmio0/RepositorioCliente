

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

                Integer  n = rand.nextInt(50) + 1;
                Integer sleep_quality = rand.nextInt(80) + 1;
                postParameters.add(new BasicNameValuePair("steps",n.toString()));
		        postParameters.add(new BasicNameValuePair("user", "2"));
		        postParameters.add(new BasicNameValuePair("sleep_quality", sleep_quality.toString()));
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
