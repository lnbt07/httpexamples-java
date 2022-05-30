package com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class getRequest {
    //url do request
    public static final String uRL_GET = "https://jsonplaceholder.typicode.com/posts";
//    public static final String uRL_GET = "http://httpbin.org/get";


    public static void main(String[] args) throws IOException, InterruptedException {
        //cliente http
        HttpClient client = HttpClient.newHttpClient();

        //criar requisição
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(uRL_GET))
                .build();

        //enviar uma solicitaçao
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //imprimir o conteudo recebido
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
