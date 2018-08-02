## CS Event Uploader
**The CS Event Uploader**

This project provides a reactive microservice inside Spring Cloud ecosystem, which contains such the elements like service discovery with Eureka, load balancing and API gateway using Spring Cloud Gateway (also based on WebFlux and Netty).

##### Getting Set Up

Before working on CS Event Uploader, you'll need to ensure you have a few requirements installed; all of which are available across Linux, Mac OS X and Windows.<br> 
You will need Java 8, Gradle and NPM (Optional if you would like to use the client designed with angular to test the upload service, also Angular CLI, otherwise you can use any rest client such as postman) installed before configuring the project.

##### Gradle

[Gradle](https://gradle.org/) is used for building, distributing and running CS Event Uploader.

You should be familiar with working with the Gradle, at least to a basic degree, before beginning work on this project.

##### NPM

[NPM](https://www.npmjs.com/) is the package manager for JavaScript and the world’s largest software registry. Discover packages of reusable code — and assemble them in powerful new ways.

##### Angular CLI

[Angular CLI](https://cli.angular.io/) a command line interface for Angular that makes it easy to create an application that already works, right out of the box.


#### Configure your HSQLDB database

Look it up for <code> /api/src/main/resources/application.properties </code> which contains the database configuration.

Update these lines below to your database configuration:

	spring.datasource.url=jdbc:hsqldb:file:db/db
	spring.datasource.username=sa 
	spring.datasource.password=


#### Running the project

Run the project and verify it's working
Now, you are ready to run CS Event Uploader with the following command. 

1. Inside the discover-service folder run the code below:

	gradle bootRun

2. Inside the upload-service folder run the code below:

	gradle bootRun

3. Inside the gateway-service folder run the code below:

	gradle bootRun

4. Inside the upload-client folder run the code below: (Optional)

	npm start

If you are using the upload client for test, Angular Live Development Server is listening on localhost:4200, open your browser on <code> http://localhost:4200/ </code>.

If you are using another client, please use the URL <code> http://localhost:8089/upload </code>.

If you make a get request it will return all events, if you make a post request it will upload your file.

[@maxalencar](https://github.com/maxalencar)

