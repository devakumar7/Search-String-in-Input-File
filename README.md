# Search-String-in-Input-File

This Spring Boot application provides a REST API for processing an uploaded text file. The API allows you to check if a provided IP address is available in the list of IP addresses extracted from the uploaded file.

In this particular application, we uploaded "ipv4 1.txt" in the src folder and then processed the text file for splitting the IP Addresses and then searching the input string from the HTTP Post Request in the processed file.
   
## Prerequisites

- Java 8 or higher
- Maven

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/devakumar7/Search-String-in-Input-File.git
2. Navigate to the project directory:
   ```bash
   cd Search-String-in-Input-File

3. Build the project:
   ```bash
   mvn clean install
   
4. Run the application:
   ```bash
   java -jar target/Search-String-in-Input-File-1.0.jar

The application will start at http://localhost:8080.

API Endpoints
Check if an IP address is in the provided list
Endpoint:   
   POST /processFile

Request:
```

{
  "file": "multipart file data",
  "ipAddress": "2.56.16.0"
}
```

Upload your text file in the above request with param "file".

Response:
```

Success: "true, it is available in the provided IP addresses"
```
```

Failure: "Error: IP address not found in the provided IP addresses"
```


Example Curl Request
```
curl -X POST -F "file=@/path/to/your/file.txt" -F "ipAddress=2.56.16.0" http://localhost:8080/checkIpAddress
```
Replace /path/to/your/file.txt with the path to your text file.
