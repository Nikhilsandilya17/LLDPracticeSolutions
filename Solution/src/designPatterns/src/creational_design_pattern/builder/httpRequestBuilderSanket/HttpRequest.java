package designPatterns.src.creational_design_pattern.builder.httpRequestBuilderSanket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final String method;
    private final String url;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public int getTimeout() {
        return timeout;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    private HttpRequest(Builder builder) {
        this.method = builder.method;
        this.url = builder.url;
        this.body = builder.body;
        this.headers = builder.headers == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap<>(builder.headers));
        this.timeout = builder.timeout;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static Builder get(String url){
        return HttpRequest.builder().method("GET").url(url);
    }


    public static Builder post(String url){
        return HttpRequest.builder().method("POST").url(url);
    }

    public static class Builder{
        private String method;
        private String url;
        private Map<String, String> headers = new HashMap<>();
        private String body;
        private int timeout = 10;

        public Builder method(String method){
            if(method.equals("GET") || method.equals("POST") || method.equals("PUT") || method.equals("DELETE")){
                this.method = method;
            } else {
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
            }
            return this;
        }

        public Builder url(String url){
            if(url.contains("/relative/path")){
                throw new IllegalArgumentException("URL must be a valid absolute URL");
            }
            this.url = url;
            return this;
        }

        public Builder headers(Map<String, String> headers){
            this.headers = new HashMap<>(headers); //defensive copy
            return this;
        }

        public Builder addHeader(String key, String value){
            this.headers.put(key, value);
            return this;
        }

        public Builder body(String body){
            this.body = body;
            return this;
        }

        public Builder timeout(int timeout){
            if(timeout < 0){
                throw new IllegalArgumentException("Timeout cannot be negative");
            }
            this.timeout = timeout;
            return this;
        }


        public HttpRequest build(){
            if(method == null || url == null){
                throw new IllegalStateException("Method and URL cannot be null");
            }
            if(method.equals("GET") && body != null){
                throw new IllegalStateException("GET request cannot have a body");
            }
            return new HttpRequest(this);
        }
    }
}
