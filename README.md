## CS Event Uploader
**The CS Event Uploader**

This project provides a reactive microservice inside Spring Cloud ecosystem, which contains such the elements like service discovery with Eureka, load balancing and API gateway using Spring Cloud Gateway (also based on WebFlux and Netty).

##### Getting Set Up

Before working on CS Event Uploader, you'll need to ensure you have a few requirements installed; all of which are available across Linux, Mac OS X and Windows.<br> 
You will need Java 21 and Gradle

##### Gradle

[Gradle](https://gradle.org/) is used for building, distributing and running CS Event Uploader.

You should be familiar with working with the Gradle, at least to a basic degree, before beginning work on this project.

#### Running the project

Run the project and verify it's working
Now, you are ready to run CS Event Uploader with the following command. 

1. Inside the discovery-service folder run the code below:

   gradle bootRun

2. Inside the uploader-service folder run the code below:

   gradle bootRun

3. Inside the gateway-service folder run the code below:

   gradle bootRun

[//]: # (From the root folder run the code below:)

[//]: # ()
[//]: # (	gradle bootRun)

#### File Format

```code
{"id":"scsmbstgrd", "state":"FINISHED", "type":"APPLICATION_LOG", "host":"123456", "timestamp":1491377495217} 
{"id":"scsmbstgra", "state":"STARTED", "type":"APPLICATION_LOG", "host":"12345", "timestamp":1491377495212} 
{"id":"scsmbstgrb", "state":"STARTED", "timestamp":1491377495213} 
{"id":"scsmbstgrd", "state":"STARTED", "type":"APPLICATION_LOG", "host":"123456", "timestamp":1491377495202} 
{"id":"scsmbstgrc", "state":"FINISHED", "timestamp":1491377495218} 
{"id":"scsmbstgra", "state":"FINISHED", "type":"APPLICATION_LOG", "host":"12345", "timestamp":1491377495217} 
{"id":"scsmbstgrc", "state":"STARTED", "timestamp":1491377495210} 
{"id":"scsmbstgrb", "state":"FINISHED", "timestamp":1491377495216}
```

If you want to send it by command line it works as well, for example using [cURL](https://curl.haxx.se/), see example below.

	curl -X POST -F file=@URL_FILE http://localhost:8089/uploader/

To fetch all events from database use the command:

	curl http://localhost:8089/uploader/

If you make a get request it will return all events, if you make a post request it will upload your file.

[@maxalencar](https://github.com/maxalencar)

