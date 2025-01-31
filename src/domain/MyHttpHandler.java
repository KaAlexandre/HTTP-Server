package domain;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestParamValue = null;
        if ("GET".equals(exchange.getRequestMethod())) {
            requestParamValue = handleGetRequest(exchange);
        } else if ("POST".equals(exchange)) {
            requestParamValue = handlePostRequest(exchange);
        }
        handleResponse(exchange, requestParamValue );
    }


    private String handleGetRequest(HttpExchange exchange) {
        return exchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
    }

    private String handlePostRequest(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i = inputStream.read()) != -1) {
            stringBuilder.append((char) i);
        }
        return stringBuilder.toString();
    }

    private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<html>")
                .append("<body>")
                .append("<h1>")
                .append("Hello,")
                .append(StringEscapeUtils.escapeHtml4(requestParamValue))
                .append("</h1>")
                .append("</body>")
                .append("</html>");


        String htmlResponse = htmlBuilder.toString();
        httpExchange.sendResponseHeaders(200,htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }

}