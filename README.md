# Swagger 
### http://localhost:8080/swagger-ui/index.html

# Docker
## Build image
```bash
$ gradle jibDockerBuild
```
## Run
```bash
$ docker run -d -p 80:8080 --name [CONTAINER_NAME] stock-history-api:latest
``` 
