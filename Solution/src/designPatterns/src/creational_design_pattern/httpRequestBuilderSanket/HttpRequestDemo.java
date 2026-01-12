package designPatterns.src.creational_design_pattern.httpRequestBuilderSanket;

public class HttpRequestDemo {
    public static void main(String[] args) {
        HttpRequest httpRequest = HttpRequest.builder()
                .method("POST")
                .url("https://api.example.com/data")
                .addHeader("Content-Type", "application/json")
                .body("{\"name\":\"Pen\"}")
                .timeout(15)
                .build();

        HttpRequest.Builder builder = HttpRequest.get("https://api.example.com/data");
        HttpRequest getHttpRequest = builder.addHeader("Accept", "application/json")
                .timeout(10)
                .build();

        System.out.println(httpRequest.toString());
        System.out.println(getHttpRequest.toString());


    }
}
