the sql url jdbc:mysql://mysqldb/User

# Docker commands

1. To build the docker image
    - docker build -t <imagename> .
2. To run the docker image
    - docker run -p 8080:8080 <image name>
3.  To run the docker-component
    - docker-compose up
4. to stop the container 
    - docker-compose down
    
## Gernal commands
 - docker									# List Docker CLI commands
 - docker --version				# Display Docker version number
 - docker version					# Display Docker client & server version and info
 - docker info								# Display Docker detailed info
 - docker run hello-world			# Execute Docker image
 - docker image List 				# List Docker images
 - docker container List 			# List Docker containers (running, all, all in quiet mode)
 - docker container ls --all	
 - docker container ls -aq
 - docker build -t friendlyhello .  # Create image using this directory's Dockerfile
 - docker run -p 4000:80 friendlyhello  # Run "friendlyname" mapping port 4000 to 80
 - docker run -d -p 4000:80 friendlyhello         # Same thing, but in detached mode
 - docker container ls                                # List all running containers
 - docker container ls -a             # List all containers, even those not running
 - docker container stop <hash>           # Gracefully stop the specified container
 - docker container kill <hash>         # Force shutdown of the specified container
 - docker container rm <hash>        # Remove specified container from this machine
 - docker container rm $(docker container ls -a -q)         # Remove all containers
 - docker image ls -a                             # List all images on this machine
 - docker image rm <image id>            # Remove specified image from this machine
 - docker rmi <image id>            # Shot command to remove specified image from this machine
 - docker image rm $(docker image ls -a -q)   # Remove all images from this machine
 - docker login             # Log in this CLI session using your Docker credentials
 - docker tag <image> username/repository:tag  # Tag <image> for upload to registry
 - docker push username/repository:tag            # Upload tagged image to registry
 - docker run username/repository:tag                   # Run image from a registry
 - docker-compose --version				# Display version number of docker-compose binary
 - docker-compose build					# Build images from the docker-compose file
 - docker-compose build --no-cache			# Build images without using cached image layers & libraries, force builds
 - docker-compose up			# Run instances of services from docker-compose, runs in foreground
 - docker-compose up -d				# Run instances of services in the background
 - docker-compose up --build -d 			# Run the instances of services by rebuilding the image in the background
 - docker-compose down 		# shutdown all the services started from docker-compose
 - docker-compose ps 		# View current status of the services containers started from docker-compose
 - docker-compose scale <service name>=<number of instances to scale>	# scale a specific service to specified number of instances
 - docker-compose logs -f 			# view the logs of the containers started from the docker and keep it tailed from beginning
 - docker-compose logs -f --tail=10 		# view the logs of the containers started from the docker and keep it tailed for last 10 line
 