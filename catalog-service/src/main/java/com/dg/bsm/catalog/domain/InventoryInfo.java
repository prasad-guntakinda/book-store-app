package com.dg.bsm.catalog.domain;

public record InventoryInfo(String itemId, boolean inStock, int stockCount) {
}
