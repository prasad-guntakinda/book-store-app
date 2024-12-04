package com.dg.bsm.inventory.domain;

public record InventoryInfo(String itemId, boolean inStock, int stockCount) {
}
