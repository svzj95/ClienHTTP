import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ClienHTTP {
    public static void main(String args[]) throws IOException {
        ClienHTTP.getQuery();
        ClienHTTP.postQuery();

    }

    public static void getQuery() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://speller.yandex.net/services/spellservice/checkText?text=You%20sholl%20not%20pass");
        CloseableHttpResponse httpResponse;
        httpResponse = httpClient.execute(httpGet);

        System.out.println(EntityUtils.toString(httpResponse.getEntity()));

        httpResponse.close();
    }

    public static void postQuery() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://speller.yandex.net/services/spellservice/checkText");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("text", "You sholl not pass"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse httpResponse;
        httpResponse = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
        httpResponse.close();
    }
}
