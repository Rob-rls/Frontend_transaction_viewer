# Transaction Viewer
This app is generates a request to send to the server when you press a button.
The data sent in the request is logged and the response from the server is also displayed on the app.

Example data sent to server
```
{
    "userId" : "bob",
    "transaction" : {
        "type" : "login",
        "time" : "2016-10-14T09:18:26z"
    },
    "location" : {
        "longitude" : -0.1234567890123456,
        "latitude" : 15.1234567890123
    },
    "device" : {
        "type" : "smart_phone",
        "os" : "Android",
        "model" : "Nexus5"
    }
}
```
