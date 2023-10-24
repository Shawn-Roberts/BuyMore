package com.BuyMore.CartService.Entity

class Product {

    private BigInteger id
    private UUID productID
    private String name
    private String description
    private BigDecimal price
    private double rating

    //CONSTRUCTOR
    Product() {}

    //GETTERS
    BigInteger getId() { return id }
    UUID getProductID() { return productID}
    String getName() { return name }
    String getDescription() { return description }
    BigDecimal getPrice() { return price }
    double getRating() { return rating }

    //SETTERS
    void setId(BigInteger id) { this.id = id }
    void setProductID(UUID productID) { this.productID = productID }
    void setName(String name) { this.name = name }
    void setDescription(String description) { this.description = description }
    void setPrice(BigDecimal price) { this.price = price }
    void setRating(double rating) { this.rating = rating }
}
