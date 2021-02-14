# Running Application

You can run this project with:

#### `mvn spring-boot:run`



## Testing Rest APIs via Postman Client

1. Create New Collection

2. Add Request 

   - Add User 

     HTTP Method: POST

     Request URL: localhost:8080/user

     Insert into the body:

     ```
     {
       "username": "test@gmail.com",
       "password": "abcd1234",
       "fullname": "my name"
     }
     ```

     

   - Authentication

     HTTP Method: POST

     Request URL: localhost:8080/authenticate

     Insert into the body:

     ```
     {
     	"username": "test@gmail.com",
       	"password": "abcd1234"
     }
     ```

     then, you get token. Copy token to used in other request.

     

   - Add Category

     HTTP Method: POST

     Request URL: localhost:8080/categories

     Add Key Authorization in Headers with the value is token that you get before.

     Insert into the body:

     ```
     {
         "name": "comic",
         "shelf_code": "RK-001",
         "fee": "3000"
     }
     ```

     

   - Add Book

     HTTP Method: POST

     Request URL: localhost:8080/books

     Add Key Authorization in Headers with the value is token that you get before.

     Insert into the body:

     ```
     {
         "title": "sinchan",
         "categoryId": 1,
         "author": "yusuke",
         "stock": 10
     }
     ```

     

   - Add Transaction

     HTTP Method: POST

     Request URL: localhost:8080/transactions

     Add Key Authorization in Headers with the value is token that you get before.

     Insert into the body:

     ```
     {
         "userId": 1,
         "bookId": 1,
         "quantity": 3
     }
     ```

   For other request you can try,

   - get all data, use HTTP Method: GET
   - get data by ID, use HTTP Method: GET and add `/{id}` on the request URL
   - update data by ID, use HTTP Method: PUT and add `/{id}` on the request URL, in fill the body box.
   - delete data by ID, use HTTP Method: DELETE and add `/{id}` on the request URL



