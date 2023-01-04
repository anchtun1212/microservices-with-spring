# Creating three microservices: Account, Loan and Card by taking a Bank application as an example

# Tips
- To set up tables, columns, data needed inside the H2 database, create a `data.sql` file under `src\main\resources\` folder. Please note that these scripts will be executed everytime you start the microservice and the moment you stop/restart your service all your data present inside your H2 database will be lost. So please make sure not to use internal memory H2 database inside production applications.
- To access the URLs of H2 databases and to make sure tables, columns, data are created inside them successfully. Please check `http://localhost:8080/h2-console` where 8080 is the runnig port of your microservice.

# Important Links
- Docker - https://www.docker.com/
