
# Helidon Quickstart MP Example

This example implements a simple Hello World REST service using MicroProfile

## Prerequisites

1. Maven 3.5 or newer
2. Java SE 8 or newer
3. Docker 17 or newer (if you want to build and run docker images)
4. Kubernetes minikube v0.24 or newer (if you want to deploy to Kubernetes)
   or access to a Kubernetes 1.7.4 or newer cluster
5. Kubectl 1.7.4 or newer for deploying to Kubernetes

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
curl -X GET http://localhost:8080/movies

```

## Try health and metrics
## You need to expose them  in VirtualService section of the app.yaml to use the below APIs 
## Leaving this as an exercise for you ;)
```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...
. . .

# Prometheus Format
curl -s -X GET http://localhost:8080/metrics
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
kubectl create -f app.yaml               # Deploy application
export INGRESS_HOST=$(minikube ip)
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')
export GATEWAY_URL=$INGRESS_HOST:$INGRESS_PORT
printenv GATEWAY_URL
```
You can use the GATEWAY_URL printed on the console to access the service.
For e.g: http://192.168.99.113:31380/movies