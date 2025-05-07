package org.senna;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepClient {

    private static final String BASE_URL = "https://viacep.com.br/ws/";

    public ViaCepResponse get(String cep) {
        try {
            String url = BASE_URL + cep.replaceAll("[^0-9]", "") + "/json/";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.body().contains("\"erro\": true")) {
                throw new CepNaoEncontradoException(cep);
            }

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), ViaCepResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o CEP: " + cep, e);
        }
    }

}