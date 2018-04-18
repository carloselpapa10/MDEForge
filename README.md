# MDEForge Application
### Installation

- Configure DOCKER_HOST_IP variable [see](http://eventuate.io/docs/usingdocker.html).
- Eventuate Diagnostic [see](https://github.com/eventuate-local-docker-images/eventuateio-docker-networking-diagnostics).
- Install Jenkins BlueOcean [see](https://github.com/carloselpapa10/MDEForge/blob/master/docker%20commands.txt).
- Pull MDEForge Application code from [GitHub](https://github.com/carloselpapa10/MDEForge). 

### Building and Running (2 ways)

- Jenkins Pipelines
	- Run Enviroment - [pipeline](https://github.com/carloselpapa10/MDEForge/blob/master/JenkinsfileRunEnv)
	- Run Services - [pipeline](https://github.com/carloselpapa10/MDEForge/blob/master/JenkinsfileRunServ)
- Docker Compose
```sh
$ mvn clean package -s settings.xml docker:build
```
```sh
$ docker-compose up
```

### Swagger UI
- Artifact Service
```sh
http://localhost:5005/swagger-ui.html
```
- User Service
```sh
http://localhost:5003/swagger-ui.html
```
- Project Service
```sh
http://localhost:5004/swagger-ui.html
```
- WorkspaceService
```sh
http://localhost:5002/swagger-ui.html
```
- MDEForge View Service
```sh
http://localhost:5001/swagger-ui.html
```