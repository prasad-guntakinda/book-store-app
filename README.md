# Online Book Store Management


### Book Data Model:
````json
{
    "_id": 1,
    "title": "Unlocking Android",
    "isbn": "1933988673",
    "pageCount": 416,
    "publishedDate": "2009-04-01T00:00:00.000-0700",
    "thumbnailUrl": "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg",
    "shortDescription": "Unlocking Android: A Developer's Guide provides concise, hands-on instruction for the Android operating system and development tools. This book teaches important architectural concepts in a straightforward writing style and builds on this with practical and useful examples throughout.",
    "authors": ["W. Frank Ableson", "Charlie Collins", "Robi Sen"],
    "categories": ["Open Source", "Mobile"]
}
````

#### Breakdown of key microservices:

__1. Product Catalog:__ Stores product details like name, description, price, images, and variations.

__2. User Management:__ Manages user accounts, logins, addresses, and personal information.

__3. Cart Management:__ Handles adding, removing, updating items in a user's shopping cart, and storing cart data.

__4. Inventory Check:__ Checks real-time product availability in stock before adding to cart.

__5. Order Processing:__ Manages order creation, payment processing, order status updates, and shipping details.

__6. Payment Gateway:__ Integrates with external payment providers to handle secure transactions.

__7. Shipping Calculation:__ Calculates shipping costs based on delivery address and order details.

__8. Promotions:__ Applies relevant discounts and promotional offers to the cart.

__9. Price Calculation:__ Calculates the final price of items in the cart considering promotions and taxes.

__10. Email Notifications:__ Sends order confirmation, shipping updates, and other relevant emails to users.

__11. Product Rating Service:__ Provides the rating information for the product


#### Server Ports:

| Service Name      | Port | Remarks |
|-------------------|------|---------|
| catalog-service   | 8081 |         |
| book-service      | 8082 |         |
| inventory-service | 8083 |         |
| rating-service    | 8084 |         |
|                   |      |         |


Dataset Sources:
1.  https://github.com/dudeonthehorse/datasets/blob/master/amazon.books.json
2.  https://www.kaggle.com/datasets/mohamedbakhet/amazon-books-reviews
3. 
