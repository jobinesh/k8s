
# Helidon Istio MP Example

This example implements a simple REST service using MicroProfile that is proxied by Istio Service Mesh at runtime
See this post to learn more: https://www.jobinesh.com/2019/09/setting-up-istio-service-mesh-for.html
## Prerequisites

1. Maven 3.5 or newer
2. Java SE 8 or newer
3. Docker 17 or newer (if you want to build and run docker images)
4. Kubernetes minikube v0.24 or newer (if you want to deploy to Kubernetes)
   or access to a Kubernetes 1.7.4 or newer cluster
5. Kubectl 1.7.4 or newer for deploying to Kubernetes
6. Minikube
7. Istio
Verify prerequisites
```
java -version
mvn --version
docker --version
minikube version
kubectl version --short
```

## Build

```
mvn package
```

## Start the application

```
java -jar target/helidon-istio-movies-mp.jar
```

## Exercise the application

```
curl -X GET http://ipaddress:port/movies

url -X GET http://ipaddress:port/greet
{"message":"Hello World!"}

curl -X GET http://ipaddress:port/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting

curl -X GET http://ipaddress:port/greet/Jose
{"message":"Hola Jose!"}
```

## Try health and metrics
```
curl -s -X GET http://ipaddress:port/health
{"outcome":"UP",...
. . .

# Prometheus Format
curl -s -X GET http://ipaddress:port/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
{"base":...
. . .

```

## To use the local docker env for minikube 

eval $(minikube docker-env)

## Build the Docker Image

```
docker build -t helidon-istio-movies-mp .
```

Exercise the application as described above

## Deploy the application to Kubernetes

```
kubectl cluster-info                      # Verify which cluster
kubectl get pods                             # Verify connectivity to cluster
kubectl create -f app.yaml               # Create all resources 
export INGRESS_HOST=$(minikube ip)
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')
export GATEWAY_URL=$INGRESS_HOST:$INGRESS_PORT
printenv GATEWAY_URL
```
You can use the GATEWAY_URL printed on the console to access the service.
For e.g: http://192.168.99.113:31380/movies