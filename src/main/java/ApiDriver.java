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
    public static final String HOSTNAME = "https://blockstream.info";
    public String QueryApi() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse getResponse = null;

        //GET /block-height/:height
        //using the height 680000 get the block hash
        String uri = "/api/block-height/680000";
        HttpGet getBlockHashGivenHeight = new HttpGet(HOSTNAME + uri);

        String blockHash = "";
        try {
            getResponse = httpclient.execute(getBlockHashGivenHeight);
            blockHash = EntityUtils.toString(getResponse.getEntity(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getResponse.close();
        }

        //using the block hash
        //GET /block/:hash/txs[/:start_index]
        uri = "/api/block/"+blockHash+"/txs";
        HttpGet getTransactions = new HttpGet(HOSTNAME + uri);

        String txs = "";
        try {
            getResponse = httpclient.execute(getTransactions);
            txs = EntityUtils.toString(getResponse.getEntity(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getResponse.close();
        }

        return txs;
    }
}
