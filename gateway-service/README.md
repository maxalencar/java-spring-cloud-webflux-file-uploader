## CS Event Uploader
**The CS Event Uploader API.**

##### Getting Set Up

Before working on CS Event Uploader, you'll need to ensure you have a few requirements installed; all of which are available across Linux, Mac OS X and Windows.<br> 
You will need Java 8 and Gradle installed before configuring the project.

##### Gradle

As is the case for all of our components, [Gradle](https://gradle.org/) is used for building, distributing and running CS Event Uploader.

You should be familiar with working with the Gradle, at least to a basic degree, before beginning work on this project.


#### Configure your HSQLDB database

Look it up for <code> /api/src/main/resources/application.properties </code> which contains the database configuration.

Update these lines below to your database configuration:

<code> spring.datasource.url=jdbc:hsqldb:file:db/csdb <br> spring.datasource.username=sa <br> spring.datasource.password= </code>


#### Running the project

Run the project and verify it's working
Now, you are ready to run CS Event Uploader with the following command. Inside the root folder run the code below:

<code> gradle bootRun </code>

Make sure you are on root folder.

[@maxalencar](https://github.com/maxalencar)

