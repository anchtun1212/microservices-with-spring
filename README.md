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
- In order to install keycloak locally using `docker` open this link: https://www.keycloak.org/getting-started/getting-started-docker but change the port from `8080` to `7080`: `sudo docker run -p 7080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.0 start-dev`

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
- Google Cloud platform (GCP) (Free Tier Products) - https://cloud.google.com/free/
- GCP - https://console.cloud.google.com/
- GConsole -  https://cloud.google.com/sdk
- Helm -  https://helm.sh/
- Keycloak  -  https://www.keycloak.org/
- Istio -  https://istio.io/

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
| "kubectl apply -f filename" | To create a deployment/service/configmap based on a given YAML file |
| "kubectl delete 8_gateway.yml" | To uninstall the microservice gateway|
| "kubectl get all" | To get all the components inside your cluster |
| "kubectl get pods" | To get all the pods details inside your cluster |
| "kubectl get pod pod-id" | To get the details of a given pod id |
| "kubectl describe pod pod-id" | To get more details of a given pod id |
| "kubectl delete pod pod-id" | To delete a given pod from cluster |
| "kubectl get services" | To get all the services details inside your cluster |
| "kubectl get service service-id" | To get the details of a given service id |
| "kubectl describe service service-id" | To get more details of a given service id |
| "kubectl get nodes" | To get all the node details inside your cluster |
| "kubectl get node node-id" | To get the details of a given node |
| "kubectl get replicasets" | To get all the replica sets details inside your cluster |
| "kubectl get replicaset replicaset-id" | To get the details of a given replicaset |
| "kubectl get deployments" | To get all the deployments details inside your cluster |
| "kubectl get deployment deployment-id" | To get the details of a given deployment |
| "kubectl get configmaps" | To get all the configmap details inside your cluster |
| "kubectl get configmap configmap-id" | To get the details of a given configmap |
| "kubectl get events --sort-by=.metadata.creationTimestamp" | To get all the events occured inside your cluster |
| "kubectl scale deployment account-deployment --replicas=3" | To increase the number of replicas for a deployment inside your cluster |
| "kubectl set image deployment account-deployment account=anchtun1212/account:k8s" | To set a new image for a deployment inside your cluster |
| "kubectl rollout history deployment account-deployment" | To know the rollout history for a deployment inside your cluster |
| "kubectl rollout undo deployment account-deployment --to-revision=1" | To rollback to a given revision for a deployment inside your cluster |
| "kubectl get hpa" | To show the current HPA (Horizontal Pod Autoscaling) inside your cluster |
| "kubectl autoscale deployment account-deployment --min=3 --max=10 --cpu-percent=70" | To create automatic scaling using HPA for a deployment inside your cluster |
| "kubectl logs node-id" | To get a logs of a given node inside your cluster |

## Some Helm Commands

|     Helm Command       |     Description          |
| ------------- | ------------- |
| "helm install [NAME] [CHART]" | Install the given helm chart into K8s cluster |
| "helm upgrade [NAME] [CHART]" | Upgrades a specified release to a new version of a chart |
| "helm uninstall [NAME]" | Uninstall all of the resources associated with a given release |
| "helm create [NAME]" | Create a default chart with the given name |
| "helm dependency build" | To compile the given helm chart |
| "helm dependencies build" | To recompile the given helm chart |
| "helm template ." | Get the actual K8s manifest files generated by Helm |
| "helm template [NAME] [CHART]" | Render chart templates locally along with the values |
| "helm history [NAME]" | Display historical revisions for a given release |
| "helm rollback [NAME] [REVISION]" | Roll back a release to a previous revision |
| "helm list" | Lists all of the helm releases inside a K8s cluster |
| "helm ls" | Lists all of the helm releases inside a K8s cluster |
