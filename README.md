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
docker run --rm -p 8080:8080 -e API_WEATHER_TOKEN=YOUR_API_KEY --name devops devops_weather
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

<br><br>

# TP3 Push the image to the cloud (Azure):
<br>
For this TP the goal was to push our API image (tag:latest) to the cloud on the azure ressource group of the class. 
<br><br>

You can then access the API on this link : http://devops-20200332.francecentral.azurecontainer.io:8080/?lat=5.902785&lon=102.754175
<br>Note the port is specified to 8080 since it's the port of the application (defined in the properties).
<br><br>

A "home" route has been added to correspond to the requirements of the TP. Such that you can execute (on **linux**) the following command:

```bash
curl "http://devops-<identifiant-efrei>.francecentral.azurecontainer.io:8080/?
lat=5.902785&lon=102.754175"
``` 
The "old" route are still working you can try this link to see them : <a href="http://devops-20200332.francecentral.azurecontainer.io:8080/weather?LAT=5.902785&LONG=102.754175">HERE</a>
<br><br>The difficulty here was to add the new steps to our github actions in our YAML file. We also had to deal with several different secrets github to specify the azure credentials, api key and the azure container registry... 
Some debugging was needed to understand the error messages and to fix them as we dit in the last TP.
<br><br>
# TP4 Azure & Terraform :
<br>
This TP is about using terraform to create a VM on azure. All resources for the TP are in the terraform folder because it is different from the others TPs as we are no deploying an API.
<br>
To create the VM you need to have terraform installed on your computer (added as a global environment), and have an azure subscription. Here we are using the class subscription.
<br>
To create the VM you need to execute the following commands in the terraform folder :
```bash
terraform init
terraform apply
```
You will now have a VM on azure with the name "devops-20200332" and the public IP will be displayed in the output of the terraform apply command (for example for me it was : 52.143.134.126).
<br>
To connect to the VM you can use the following command :
```bash
ssh -i id_rsa devops@{YOUR_PUBLIC_ID} cat /etc/os-release
```
If everything is working you should see the OS of the VM : 
```bash
PRETTY_NAME="Ubuntu 22.04.4 LTS"
NAME="Ubuntu"
VERSION_ID="22.04"
VERSION="22.04.4 LTS (Jammy Jellyfish)"
VERSION_CODENAME=jammy
ID=ubuntu
ID_LIKE=debian
HOME_URL="https://www.ubuntu.com/"
SUPPORT_URL="https://help.ubuntu.com/"
BUG_REPORT_URL="https://bugs.launchpad.net/ubuntu/"
PRIVACY_POLICY_URL="https://www.ubuntu.com/legal/terms-and-policies/privacy-policy"
UBUNTU_CODENAME=jammy
```
<br>
The main difficulty here was to understand the terraform syntax and the different resources that we can use. The terraform documentation was very useful to understand the different resources and how to use them.
<br>
The connection via ssh was also a bit tricky because we had to use the private key that we generated with the terraform script. And we needed to specify the creation of a local file (id_rsa) to store the private key to establish the connection.
<br>
Once finished you can destroy the VM with the following command :
```bash
terraform destroy
```

