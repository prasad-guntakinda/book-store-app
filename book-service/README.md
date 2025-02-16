
This service exposes REST APIs to add, get, update and search books information.

- [X] Add Book
- [X] Find All Books
- [ ] Get Book by Id
- [ ] Update Book Details
- [ ] Search Book by title/author/tag


## Book Model:

```json
{
    
    "title": "Unlocking Android",
    "isbn": "1933988673",
    "pageCount": 416,
    "publishedDate": "2024-04-19T13:29:56.370013400Z",
    "thumbnailUrl": "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg",
    "shortDescription": "Unlocking Android: A Developer's Guide provides concise, hands-on instruction for the Android operating system and development tools. This book teaches important architectural concepts in a straightforward writing style and builds on this with practical and useful examples throughout.",
    "authors": ["W. Frank Ableson", "Charlie Collins", "Robi Sen"],
    "categories": ["Open Source", "Mobile"]
}
```

### How to Build and Run on localhost?
- Clone the repository
- Goto parent directory(where pom.xml) exists.
- execute build command
```shell
 ./mvnw clean install
```

- After a successful build, you can run your application by using bootJar
```shell
  ./mvnw spring-boot:run
```
**OR**
- you can run bootJar by using `java` command
- bootJar filename: `book-service-${project.version}.jar`

````shell
  java -jar ./target/book-service-${project.version}.jar
````

- Check your application is successfully started or not.

- Once your application is up and running test with url:http://localhost:8082/book-service/swagger-ui/index.html on any browser. 