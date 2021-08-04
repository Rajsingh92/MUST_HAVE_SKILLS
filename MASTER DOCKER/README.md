Docker is an open source paltform to build ,ship and run application. It is an containerization platform,which enables developers to package application into containers (executable component that combine application source code with all the dependencies required to run the application ).Docker enables you to seperate your application from your infrastructure and reduce the delay between writing code and running it in production.Containers are light weight , portable , reusable  and have great resource efficiency and versioning(docker can track version of a container image and can roll back to previous version).


## Docker Engine:
![Docker Engine](https://docs.docker.com/engine/images/engine-components-flow.png)
Docker Engine is a  client server application.It consist of three components DOCKER DAEMON,REST API and DOCKER CLI.Docker daemon is a server , REST API provides interface and CLI use this interface  to control or interact with the  daemon through scripting or CLI commands.The daemon creates and manages Docker objects such as images, containers, networks, plugins and volumes. The docker daemon constantly listens for docker api requests and process them.

## Docker Architecture: 
![Docker Architecture](https://docs.docker.com/engine/images/architecture.svg)\


<br/>
Docker client can communicate with docker daemon on same machine or remote docker daemon.The Docker client can communicate with more than one daemon.

docker host provides a environment to execute and run applications.It consist of Docker daemon, images
,containers,networks and storage .

docker registry stores docker images and it can be private or pubic registry(Docker Hub).By default docker look for images in Docker hub you can use your private registry.

When you use commands such as docker run, the client sends these commands to docker daemon using REST API and search for images in host machine if image is not present in machine it pulls it from configured registry and create container using image.


### Image
Images are nothing but a read only binary template that can build containers.You can share images across team with the help of registry.You can also craete your own images by creating Dockerfile.Each instruction in Dockerfile is a layer and when you change Dockerfile only those layers which have changed are rebuilt.

### Container
Container is a running instance of a image.It is an encapsulated environoment in which you can run application.Container have access to resources that are defined in image. You can create, start, stop, move, or delete a container using the Docker API or CLI.

### Network
Docker network is a passage through which all isolated conatiner communicate.(Network drivers: Bridge,Host,Overlay,None,macvlan)

### Storage
Docker Storage where you can store data.Docker offers Data Volumes,Volume Container,Directory Mounts,Storage Plugins.



## Important Docker Commands

## A. docker container command
1.  create: create container from image
2.  start : start an existing container
3.  stop : stop running container
4.  run : create and run container  (-it,--rm,-p)
5.  rm : delete stopped conatiner
6.  kill : to kill an existing Docker container
7.  pause : to pause an existing Docker container
8.  unpause : to unpause the processes in a running container
9.  top : see the top processes within a container
10. stats : to provide the statistics of a running container.
11. ls : list running container  (-a,-s)
12. inspect : info about a conatiner


## B. docker image command
1.  build : build in a image
2.  push : push an image to registry
3.  ls : list available images
4.  rm : delete an image
5.  inspect : info about a image
6.  pull : pull image from registry

## C. docker version
## D. docker login
## E. docker logout
## F. docker build -f Dockerfile





# Create Dockerfile
1.  FROM : specifies the base image
2.  LABEL : provide metedata ,image maintainers info
3.  ENV : persistent environment variable that is available at container run time
4.  RUN : creates layer at build time
5.  COPY : take your file and folder in your build context
6.  ADD : move files from remote to container and extract tar file
7.  CMD : when container is stacked
8.  WORKDIR : create dir if not exist
9.  ARG : defines a variable to pass to docker at build time
10. ENTRYPOINT : provides commands and arguments for an existing container
11. EXPOSE : expose a port
12. VOLUME : specifies where will store data


