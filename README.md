# Creating three microservices: Account, Loan and Card by taking a Bank application as an example

# Create new Database and new user

sudo -u postgres psql

postgres=# create database springdb;

postgres=# create user springuser with encrypted password 'springpass';

postgres=# grant all privileges on database springdb to springuser;

postgres=# alter database springdb owner to springuser;

# Tips
- To set up tables, columns, data needed inside the H2 database, create a `data.sql` file under `src\main\resources\` folder. Please note that these scripts will be executed everytime you start the microservice and the moment you stop/restart your service all your data present inside your H2 database will be lost. So please make sure not to use internal memory H2 database inside production applications.
- To access the URLs of H2 databases and to make sure tables, columns, data are created inside them successfully. Please check `http://localhost:8080/h2-console` where 8080 is the runnig port of your microservice.
- If you get error: `/var/run/docker.sock: connect: permission denied`, so try this command: `sudo setfacl --modify user:<user name or ID>:rw /var/run/docker.sock`
- Install Maven (`sudo apt install maven`) then patch any version: Add maven to environment variables: `export PATH=/opt/apache-maven-3.8.7/bin:$PATH`
  then you can use `sudo mvn ...`
- Use Env. variables in spring boot's appliaction properties: `spring.property=${ENV_VARIABLE}` then export the Env. variable into your server:
  `export ENV_VARIABLE=value`
- You can set Env. variable when running docker: `docker run ... -e ENV_VARIABLE=value`
- When you encryt values inside application properties file should prefix with: `{cipher}encrypted_value`
- To run Zipkin server run this command: `sudo docker run -d -p 9411:9411 openzipkin/zipkin`
- To setup a Rabbit MQ server, run the docker command `docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management`
- You can Install Minikube on Ubuntu: https://phoenixnap.com/kb/install-minikube-on-ubuntu
- In order to connect to your cluster in GCP you need to install: `Google Cloud SDK` so please flow this: https://techviewleo.com/install-google-cloud-sdk-on-linux-mint-ubuntu/  then run this command: `sudo apt-get install google-cloud-sdk-gke-gcloud-auth-plugin` and finally go to cluster and get the command line from `connect` button and run it; it should be like this: `gcloud container clusters get-credentials cluster-1 --zone us-central1-c --project microservices-377510`

# Use SSH `microservices-config` URL
- Execute: `cd /home/mohammedayman/.ssh`
- Execute: `ssh-keygen -m PEM -t rsa -b 4096`
- Execute: `ls`
- You will see: `id_rsa` and `id_rsa.pub`
- Execute: `cat id_rsa.pub`
- Copy the value from the Begin until `==`
- Go to private repository (`microservices-config`)
- Go to `settings`
- Go `Deploy keys`
- Click on `Add deploy Key` and paste the `id_rsa.pub` value
- Go to Config server and add those properties:
 * `spring.cloud.config.server.git.uri=git@github.com:anchtun1212/microservices-config.git` ==> this the SSH URL
 * `spring.cloud.config.server.git.ignore-local-ssh-settings=true`
 * `spring.cloud.config.server.git.private-key=\` ==> then copy the value inside `id_rsa` and `add at the end of each line \n\`

# Notes
- anchtun/account: image name

# Install Docker Desktop on debian
- See this link: https://docs.docker.com/desktop/install/debian

# Important Links
- Docker - https://www.docker.com
- DockerHub - https://hub.docker.com/u/anchtun1212
- Compatibility matrix - https://docs.docker.com/compose/compose-file/compose-versioning
- Cloud Native Buildpacks - https://buildpacks.io/
- Paketo Buildpacks - https://paketo.io/
- Reference documentation - https://docs.docker.com/reference/
- Free sql DB online - https://www.freesqldatabase.com/
- The Twelve Factors - https://12factor.net/
- Logstash - https://www.elastic.co/logstash/
- Spring Cloud Project - https://spring.io/projects/spring-cloud
- Spring Cloud Config - https://spring.io/projects/spring-cloud-config
- Spring Cloud Netflix - https://spring.io/projects/spring-cloud-netflix
- Spring Cloud Gateway - https://spring.io/projects/spring-cloud-gateway
- Spring Cloud Sleuth - https://spring.io/projects/spring-cloud-sleuth
- Resilience4j - https://resilience4j.readme.io/docs/getting-started
- Zipkin - https://zipkin.io/
- RabbitMQ - https://www.rabbitmq.com/
- Micrometer - https://micrometer.io/
- Prometheus - https://prometheus.io/
- Grafana - https://grafana.com/
- Grafana Dashboards - https://grafana.com/grafana/dashboards/
- Google Cloud platform (Free Tier Products) - https://cloud.google.com/free/
- Google Cloud platform (SDK) - https://cloud.google.com/sdk

## Some Maven Commands

|     Maven Command       |     Description          |
| ------------- | ------------- |
| "mvn --version" | To check maven version installed in your machine |
| "mvn clean install -Dmaven.test.skip=true" | To generate a jar inside target folder |
| "mvn spring-boot:run" | To start a springboot maven project |
| "mvn spring-boot:build-image -Dmaven.test.skip=true" | To generate a docker image using Buildpacks. No need of Dockerfile |


## Some Docker Commands

|     Docker Command       |     Description          |
| ------------- | ------------- |
| "docker build . -t anchtun/account" | To generate a docker image based on a Dockerfile |
| "docker run  -p 8010:8010 anchtun/account" | To start a docker container based on a given image |
| "docker run  -p 8011:8010 anchtun/account" | To start another docker container based on a given image |
| "docker images" | To list all the docker images present in the Docker server |
| "docker image inspect image-id" | To display detailed image information for a given image id |
| "docker image rm image-id" | To remove one or more images for a given image ids |
| "docker rmi -f image-id" | Untags and removes all images that match the specified ID |
| "docker ps" | To show all running containers |
| "docker ps -a" | To show all containers including running and stopped |
| "docker container start container-id" | To start one or more stopped containers |
| "docker container pause container-id" | To pause all processes within one or more containers |
| "docker container unpause container-id" | To unpause all processes within one or more containers |
| "docker container stop container-id" | To stop one or more running containers |
| "docker container kill container-id" | To kill one or more running containers instantly |
| "docker container restart container-id" | To restart one or more containers |
| "docker container inspect container-id" | To inspect all the details for a given container id |
| "docker container rm container-id" | To remove one or more containers based on container ids |
| "docker container logs container-id" | To fetch the logs of a given container id |
| "docker container logs -f container-id" | To follow log output of a given container id |
| "docker logs container-id" | To fetch the logs of a given container id |
| "docker login -u anchtun1212" | Log in to a Docker registry |
| "docker logout" | Log out from a Docker registry |
| "docker tag anchtun/account:latest anchtun1212/account:latest" | An alias and tag for an image |
| "docker push anchtun1212/account" | To push an image or a repository to a registry after create tag |
| "docker image tag anchtun/account:latest docker.io/anchtun1212/account:latest" | An alias and tag for an image |
| "docker image push docker.io/anchtun1212/account:latest" | To push an image or a repository to a registry after create tag |
| "docker  pull anchtun1212/account" | To pull an image or a repository from a registry |
| "docker container prune" | To remove all stopped containers |
| "docker compose up" | To create and start containers based on given docker compose file |
| "docker compose stop" | To stop services |

## Some Kubernetes Commands

|     Kubernetes Command       |     Description          |
| ------------- | ------------- |
| "kubectl get all" | To get all the components inside your cluster |
| "kubectl get nodes" | To get all the nodes details inside your cluster |
| "kubectl get pods" | To get all the pods details inside your cluster |
| "kubectl get deployments" | To get all the deployments details inside your cluster |

