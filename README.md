This is a Library Management System API developed using Spring Boot. The system allows librarians to manage books, patrons, and borrowing records.
The application uses Caching, Transaction Management, Spring Security, etc

API Endpoints:
● Book management endpoints:
● GET /api/books: Retrieve a list of all books.
● GET /api/books/{id}: Retrieve details of a specific book by ID.
● POST /api/books: Add a new book to the library.
● PUT /api/books/{id}: Update an existing book's information.
● DELETE /api/books/{id}: Remove a book from the library.
● Patron management endpoints:
● GET /api/patrons: Retrieve a list of all patrons.
● GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
● POST /api/patrons: Add a new patron to the system.
● PUT /api/patrons/{id}: Update an existing patron's information.
● DELETE /api/patrons/{id}: Remove a patron from the system.
● Borrowing endpoints:
● POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book.
● PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.


How To Run : The application is protected using Spring Security.
● The application is running on "http://localhost:8080". 
● You will be directed to a login page. 
  ● Username : user
  ● Password is always generated everytime when application runs on your IDE. You will find the password in terminal when you run the application.
● Use the api endpoints mentioned above.

  
