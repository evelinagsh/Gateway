# It's a Gateway app 
This application fetches data from fixer.io and serves the data back using json and xml controllers.
### To start the project
- rename the `example.application.properties` to `application.properties` and fill in your values.
- run the project in your IDE 
- make a POST request to http://localhost:8080/json_api/current 
- request body:

```
{
"requestId": "b89577fe-8c37-4962-8af3-7cb89a245160",
"timestamp": 1586335186721, // UTC 
"client": "1234",
“currency”:”EUR”
}
```
