## AWS EC2 Container Service ECS

* AWS EC2 Container Service \(ECS\) is a highly scalable, high performance container management service that supports Docker containers and allows running applications on a managed cluster of EC2 instances
* ECS eliminates the need to install, operate, and scale the cluster management infrastructure.
* ECS is a **regional **service that simplifies running application containers in a highly available manner across multiple AZs within a region
* ECS helps schedule the placement of containers across the cluster based on the resource needs and availability requirements.
* ECS allows integration of your own custom scheduler or third-party schedulers to meet business or application specific requirements.

## ECS Elements

### ECS with EC2 launch type

![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2017/08/ECS-Overview-Standard.png?resize=656%2C737 "ECS Overview Standard")

### ECS with AWS Fargate

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2017/08/overview-ecs.png?resize=656%2C737 "ECS Overview")

### Containers and Images {#w2ab1b5c11b9}

* Applications deployed on ECS must be architected to run in \_**docker containers**, \_which is a standardized unit of software development, containing everything that the software application needs to run: code, runtime, system tools, system libraries, etc.
* Containers are created from a read-only template called an _**image**_
* Images are typically built from a Dockerfile, and stored in a _**registry**_ from which they can be downloaded and run on your container instances.
* ECS can be configured to access a private Docker image registry within a VPC, Docker Hub or is integrated with EC2 Container Registry \(ECR\)

### Clusters {#w2ab1b5c11c15}

* Cluster is a logical grouping of EC2 container instances to run tasks using ECS
* ECS downloads the container images from the specified registry, and runs those images on the container instances within your cluster.

![](https://i2.wp.com/docs.aws.amazon.com/AmazonECS/latest/developerguide/images/overview-containers.png?zoom=1.25&w=656)

### Task Definitions {#w2ab1b5c11c11}

* Task definition is a description of an application that contains one or more docker containers
* Task definition is needed to prepare application to run on ECS
* Task definition is a text file in JSON format that describes one or more containers that form your application.
* Task definitions specify various parameters for the application, such as containers to use, their repositories, ports to be opened, and data volumes

### **Tasks and Scheduling**

* A task is the instantiation of a task definition on a container instance within the cluster.
* After a task definition is created for the application within ECS, you can specify the number of tasks that will run on the cluster.
* ECS task scheduler is responsible for placing tasks on container instances, with several different scheduling options available

![](https://i2.wp.com/docs.aws.amazon.com/AmazonECS/latest/developerguide/images/overview-service.png?zoom=1.25&w=656)

### ECS Service

* ECS Service helps to run and maintain a specified number of instances of a task definition simultaneously.

### Container Agent {#w2ab1b5c11c17}

* Container agent runs on each instance within an ECS cluster
* Container Agent sends information about the instance’s current running tasks and resource utilization to ECS, and starts and stops tasks whenever it receives a request from ECS

![](https://i2.wp.com/docs.aws.amazon.com/AmazonECS/latest/developerguide/images/overview-clusteragent.png?zoom=1.25&w=656)

## ECS vs Elastic Beanstalk

* ECS helps in having a more fine-grained control for custom application architectures.
* Elastic Beanstalk is ideal to leverage the benefits of containers but just want the simplicity of deploying applications from development to production by uploading a container image.
* Elastic Beanstalk is more of an application management platform that helps customers easily deploy and scale web applications and services.
* With Elastic Beanstalk, specify container images to be deployed, with the CPU & memory requirements, port mappings and container links.
* Elastic Beanstalk abstracts the finer details and automatically handles all the details such as provisioning an ECS cluster, balancing load, auto-scaling, monitoring, and placing the containers across the cluster.

## ECS vs Lambda

* EC2 Container Service is a highly scalable Docker container management service that allows running and managing distributed applications in Docker containers.
* AWS Lambda is an event-driven task compute service that runs code \(Lambda functions\) in response to “events” from event sources like SES, SNS, DynamoDB & Kinesis Streams, CloudWatch etc.

## 



