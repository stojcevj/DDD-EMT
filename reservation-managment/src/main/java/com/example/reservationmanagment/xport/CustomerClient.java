package com.example.reservationmanagment.xport;

import com.example.reservationmanagment.valueobjects.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class CustomerClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public CustomerClient(@Value("${app.customer-list.url}") String serverUrl){
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromHttpUrl(this.serverUrl);
    }

    public void increaseCustomerReservations(String customerId){
        restTemplate
                .exchange(uri().path("/increaseCustomer")
                                .queryParam("customerId", customerId)
                                .build()
                                .toUri(),
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }).getStatusCode();
    }

    public void createCustomer(String id,String name,String phone,String streetName,Integer number){
        restTemplate
                .exchange(uri().path("/createCustomer")
                                .queryParam("id", id)
                                .queryParam("name", name)
                                .queryParam("phone", phone)
                                .queryParam("streetName", streetName)
                                .queryParam("number", number)
                                .build()
                                .toUri(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        }).getStatusCode();
    }

}
