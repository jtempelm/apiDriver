import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ApiDriver {

    /**
     * For IDE setup purposes
     *          ▄              ▄    So testing skills
     *         ▌▒█           ▄▀▒▌
     *         ▌▒▒█        ▄▀▒▒▒▐   Wow so crypto
     *        ▐▄█▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
     *      ▄▄▀▒▒▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐   Many nibbles of knowledge
     *    ▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
     *   ▐▒▒▒▄▄▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▀▄▒▌
     *   ▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
     *  ▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌
     *  ▌░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌
     * ▌▒▒▒▄██▄▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▐
     * ▐▒▒▐▄█▄█▌▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▒▒▌
     * ▐▒▒▐▀▐▀▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▐
     *  ▌▒▒▀▄▄▄▄▄▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▒▌
     *  ▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒▒▄▒▒▐
     *   ▀▄▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒▄▒▒▒▒▌
     *     ▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀
     *       ▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀
     *          ▀▀▀▀▀▀▀▀▀▀▀▀
     *
     */
    public static final String HOSTNAME = "https://api-goerli.etherscan.io";

    public String QueryApi() throws IOException {
        final String uri = "/api";
        final String queryParams = "?module=account&action=balance&address=0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae&tag=latest";
        final String apiKey = "&apikey=xxx"; //don't commit the real api key

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(HOSTNAME + uri + queryParams + apiKey);

        CloseableHttpResponse getResponse = null;
        try {
            getResponse = httpclient.execute(httpGet);
            String responseBody = EntityUtils.toString(getResponse.getEntity(), StandardCharsets.UTF_8);
            Header[] headers = getResponse.getAllHeaders();
            return String.valueOf(getResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getResponse.close();
        }

//        HttpPost httpPost = new HttpPost("http://targethost/login");
//        String encodedJson = "{ \"wouldIUseAClassForThis\": \"yes\" }";
//        httpPost.setEntity(new StringEntity(encodedJson));
//        CloseableHttpResponse postResponse = httpclient.execute(httpPost);
//
//        try {
//            postResponse = httpclient.execute(httpPost);
//            Header[] headers = postResponse.getAllHeaders();
//            String responseBody = EntityUtils.toString(postResponse.getEntity(), StandardCharsets.UTF_8);
//            return String.valueOf(postResponse.getStatusLine().getStatusCode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            postResponse.close();
//        }

        return null;
    }
}
