### Project by Timothé PERIER
<br><br>
This project is a **Java spring boot application**. To obtain the weather you need to ping the application with the latitude and longitude.
Example for Efrei Paris : http://localhost:8080/weather?LAT=48.788776871408054&LONG=2.3637585999999997
<br>Note the port of the localhost may be set in the application.properties file (default : 8080).
<br> The application will return the weather in JSON format.<br><br>
# TP1 Create the project and its docker image :
<br><br>1. Build the docker image ( Docker needs to be running).
<br>The target will be automatically create using mvn package (if facing issue try specifying the Dockerfile path).
```bash 
docker build -t devops_weather -f Dockerfile .
``` 
<br>2. Run the docker image :
<br>This command also map the docker port to the computer port 8080, container name and image name can be modified.
```bash 
docker run --rm -p 8080:8080 -e API_TOKEN=YOUR_API_KEY --name devops devops_weather
```

<br>3. You can now ping the application with the URL above or [THIS](http://localhost:8080/weather?LAT=48.788776871408054&LONG=2.3637585999999997)

<br><br>To access the image from dockerHub you can do : 
```bash 
docker pull erebexii/devops_weather:latest
``` 
<br>Here is the docker Hub url : https://hub.docker.com/r/erebexii/repository/tags

# TP2 Create the project and its docker image :
<br> Since I made a project using spring boot, my application is already functioning as a REST API. In our case to 
get the weather you need to ping the application with the latitude and longitude and it is a GET protocol.
<br><br>Auto publish of the latest image on dockerHub.
<br>Using github actions, the image is automatically pushed to dockerHub when a push is made on the main branch.
We first create a target with all the dependencies and then we build the docker image.
<br>
#TP3 Push the image to the cloud (Azure):