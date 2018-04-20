package com.qtyd.fuse;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/18
 * @Description: qtyd-test消费者熔断器
 **/
@Component
public class QtydTestProvider implements ZuulFallbackProvider{

    @Override
    public String getRoute() {
        return "qtyd-test";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse(){

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mt = new MediaType("application","json", Charset.forName("utf-8"));
                httpHeaders.setContentType(mt);
                return httpHeaders;
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("qtyd-test暂时不可用".getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }
}
