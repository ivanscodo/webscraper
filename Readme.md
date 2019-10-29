<h3>Webscraper for the Mongo competition</h3>

MongoDB offers a lot of flexibility and due to his schemaless nature it is easier and faster to build an application from the scratch.

<b>Set up</b>
<p>This is a java application so you need a JVM installed on your machine in order to run it.</p>
<p>You can download and install the JRE through this link: https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase11-5116896.html</p>
<p>The application makes use of the google chrome web browser to scrap the websites so you will need to install the latest version of this navigator</p>
<p>This application needs a MongoDB instance running locally with the default port 27017 but in case you can't run Mongo locally you can always change the connection params on the application.yml file. You just need to remove the comments on the last lines to be able to add authentication also.</p>
<p>Since you've installed the JVM, the google chrome web browser and a MongoDB instance is running and configured properly, let's set up the application</p>
<ol>
    <li>Edit the application.yml file</li>
    <li>Replace the line path (which references the path to the google chrome application, changing this value (C:\Program Files (x86)\Google\Chrome\Application\chrome.exe) to the correct path on your machine. Please keep the double bars as it is.</li>
    <li>The google chrome will run on headless mode which means you won't be able to see when it accesses the web page you inputed so if you want to see the browser running just set the value of this parameter to true</li>
    <li>We don't recommend commiting jar files but just to save you some time and effort to configure maven and downloading all the dependencies we added the jar file to this repo.</li>
    <li>Run the command <code>java -jar webscraper-1.0-SNAPSHOT</code> on the main folder and wait until the end of the startup process</li>
    <li>Access the folder webscraper-html under the main folder and run the index.html file</li>
</ol>

<ul>
    <li>Just input the url of website you want to scrap in the format <code>http://www.google.com.br</code> (for example) and after some time (it depends on the performance of the website) you will see the results:</li>
    <ol>
        <li>The title of the page</li>
        <li>The url of the website</li>
        <li>The 50 most common words on the website</li>
    </ol>
</ul>
