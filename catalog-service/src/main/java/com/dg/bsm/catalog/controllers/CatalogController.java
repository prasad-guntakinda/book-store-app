package com.dg.bsm.catalog.controllers;

import com.dg.bsm.catalog.domain.BookInfo;
import com.dg.bsm.catalog.domain.CatalogBook;
import com.dg.bsm.catalog.domain.CatalogResponse;
import com.dg.bsm.catalog.domain.InventoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private WebClient webClient;

    @Value("${book-service.booksUrl}")
    private String booksUrl;
    @Value("${inventory-service.inventoryByIdUrl}")
    private String inventoryByIdUrl;

    @GetMapping

    public CatalogResponse getCatalog(){
        var serviceInstance =  discoveryClient.getInstances("book-service").getFirst();
       List<BookInfo> books =  webClient.method(HttpMethod.GET)
               .uri(serviceInstance.getUri()+"/book-service/books")
               .retrieve()
               .toEntityList(BookInfo.class)
               .blockOptional()
               .orElseThrow()
               .getBody();
        List<CatalogBook> catalogBooks = books.stream().map(bookInfo -> {
            InventoryInfo inventoryInfo = webClient.method(HttpMethod.GET)
                    .uri(URI.create(inventoryByIdUrl.concat("/"+bookInfo.id())))
                    .retrieve()
                    .toEntity(InventoryInfo.class)
                    .block().getBody();
            return new CatalogBook(bookInfo, null,inventoryInfo);
        }).toList();
       return new CatalogResponse(catalogBooks);
    }
}
