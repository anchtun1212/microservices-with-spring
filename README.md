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
- Add maven to environment variables: `export PATH=/opt/apache-maven-3.8.7/bin:$PATH`

# Install Docker Desktop on debian
- See this link: https://docs.docker.com/desktop/install/debian

# Important Links
- Docker - https://www.docker.com
- DockerHub - https://hub.docker.com/u/anchtun1212
- Cloud Native Buildpacks - https://buildpacks.io/
- Paketo Buildpacks - https://paketo.io/

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
| "docker logs -f container-id" | To follow log output of a given container id |
