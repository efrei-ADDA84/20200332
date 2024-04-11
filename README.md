Project by Timothé PERIER
<br><br>
This project is a Java spring boot application. To obtain the weather you need to ping the application with the lattitude and longitude.
Example for Efrei Paris : http://localhost:8080/weather?LAT=48.788776871408054&LONG=2.3637585999999997
<br>Note the port of the localhost may be set in the application.properties file (default : 8080).
<br> The application will return the weather in JSON format.
<br><br>To use the application with docker :
<br>1. Build the application with the command : mvn package
<br>2. Build the docker image with the command : docker build -t devops_weather -f "C:\path\to\Dockerfile" .
<br>3. Run the docker image with the command : docker run --rm -p 8080:8080 -e API_TOKEN=YOUR_API_KEY --name devops devops_weather
<br>4. You can now ping the application with the same URL as before.
<br><br>To access the image from dockerHub you can do : docker pull erebexii/repository:tag
<br>Here is the docker Hub url : https://hub.docker.com/r/erebexii/repository/tags
test