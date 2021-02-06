import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;


public class App {

    static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        logger.info("Application started.");
        if (args.length != 1) {
            logger.error("Invalid request");
            logger.error("The number of argument must be 1.");
            return;
        }
        String zipcode = args[0];
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // Build URL
            URIBuilder builder = new URIBuilder("https://zipcloud.ibsnet.co.jp/api/search");
            builder.setParameter("zipcode", zipcode);
            HttpGet request = new HttpGet(builder.build());
            // Add request headers
            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
            // Execute Get request
            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println("⬇  Here's Address Info based on the zipcode.⬇");
                    System.out.println("==============================================================");
                    System.out.println(result);
                    System.out.println("==============================================================");
                } else {
                    logger.error("Invalid request.");
                }

            } finally {
                response.close();
            }

        } finally {
            httpClient.close();
            logger.info("Application completed.");
        }
    }
}
