package org.vyatsu.seo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Objects;

public class Position{

        public static String getPositionBySupplierAndQuery(String query, String brand) {
            int countPages = 3;
            int position = 1;
            int temp = 1;

            String encodedQuery;
            while(temp != countPages){
                try {
                    encodedQuery = URLEncoder.encode(query, "UTF-8");
                    String url = "https://search.wb.ru/exactmatch/ru/common/v4/search?query=" + encodedQuery + "&resultset=catalog&appType=1&curr=rub&dest=-2383149&spp=27&page=1";

                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpGet httpGet = new HttpGet(url);

                    try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                        if (response.getStatusLine().getStatusCode() == 200) {

                            HttpEntity entity = response.getEntity();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));

                            StringBuilder jsonContent = new StringBuilder();
                            String line;

                            while ((line = reader.readLine()) != null) {
                                jsonContent.append(line);
                            }

                            ObjectMapper objectMapper = new ObjectMapper();
                            JsonNode jsonNode = objectMapper.readTree(jsonContent.toString());

                            JsonNode productsArray = jsonNode.path("data").path("products");

                            int tempPos = 0;
                            String tempBrand = "";
                            for (JsonNode productNode : productsArray) {
                                // Извлекаем значение brand для текущего продукта
                                tempBrand = productNode.path("brand").asText();

                                if (Objects.equals(brand, tempBrand)) {
                                    System.out.println("Позиция " + brand + " по запросу: " + query + " - " + position);
                                    position = 0;
                                    break;
                                }
                                position++;
                            }
                            temp++;
                        } else {
                            position = 0;
                            return "Ошибка при выполнении запроса. Код ответа: " + response.getStatusLine().getStatusCode();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    return e.getMessage();
                }
            }

            return "Позиция " + brand + " по запросу " + query + " - " + 300 + "+";
        }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
