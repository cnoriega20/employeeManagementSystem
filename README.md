# basicRestApi
Spring.io complete Rest API project

# Test with Curl and Docker:

  - Run following docker commands after cloninf the project:
    - docker build -t springbootrestapi-docker .
    - docker run --publish 8080:8080 --name sprinbootrestapi-docker springbootrestapi-docker
  - Run the REST Api with container ip:
    - docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' sprinbootrestapi-docker
  - Test the API with CURL:
    - curl -v http://127.17.0.2:8080/employees<br>
      Response:
      ```json

      VERBOSE: GET http://127.17.0.2:8080/employees with 0-byte payload
      VERBOSE: received -1-byte response of content type application/json


      StatusCode        : 200
      StatusDescription :
      Content           : [{"id":1,"name":"Karim Benzema","role":"Real Madrid ST"},{"id":2,"name":"Edison Kavani","role":"Paris Saint Germain ST"}]
      RawContent        : HTTP/1.1 200
                          Transfer-Encoding: chunked
                          Keep-Alive: timeout=60
                          Connection: keep-alive
                          Content-Type: application/json
                          Date: Mon, 07 Sep 2020 01:28:16 GMT

                          [{"id":1,"name":"Karim Benzema","role"...
      Forms             : {}
      Headers           : {[Transfer-Encoding, chunked], [Keep-Alive, timeout=60], [Connection, keep-alive], [Content-Type, application/json]...}
      Images            : {}
      InputFields       : {}
      Links             : {}
      ParsedHtml        : mshtml.HTMLDocumentClass
      RawContentLength  : 12

```
    
