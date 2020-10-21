minikube start --cpus=4

minikube addons enable ingress

kubectl apply -f fitnesszone-configmap.yaml

kubectl apply -f fitnesszone-secret.yaml

kubectl apply -f mysql-deployment.yaml

kubectl apply -f mongo-deployment.yaml

kubectl apply -f userservice-deployment.yaml

kubectl apply -f productservice-deployment.yaml

kubectl apply -f apigateway-deployment.yaml

# run after few minutes of starting of minikube
# kubectl apply -f ingress-service.yaml

minikube dashboard