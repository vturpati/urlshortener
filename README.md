## URL Shortening 

This project is developed using spring boot and h2 db.

# How to build the project

mvn clean install 

java -jar target/urlshortener-0.0.1-SNAPSHOT.jar


# how to use the application 

Open http://localhost:8080/index.html

It has form where URL can be either shortened or unshortened 


#Api developed

Post api /api/v1/urls/ with body 
{
	"actualUrl": "https://www.apple.com/" 
}

Response with hash value 

Get api value api/v1/urls/{hash value}

Response as {
    "id": 1,
    "actualUrl": "http://apple.com/",
    "hashValue": "7134832"
}


## License

[CC0-1.0](./LICENSE).
