Step-1 : Create a Dockerfile by right clicking on the project folder
Step-2 : mvn clean // to clean the project before building the jar file
Step-3 : mvn package // to create a jar file
Step-4 : sudo docker build -f Dockerfile -t demodocker .
Step-5 : sudo docker run -p 8080:8080 demodocker
Step-6 : once started, Open the browser and issue the command "http:localhost:8080/home
Step-7 : you get the output on the browser