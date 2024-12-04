package com.dg.bsm.catalog.domain;

public record CatalogBook(BookInfo bookInfo,
                          RatingInfo ratingInfo,
                          InventoryInfo inventoryInfo) {
}
