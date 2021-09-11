

build:
	mvn -f ./cartao/pom.xml clean package -DskipTests

build-docker:
	docker build ./cartao -t cartao:latest

compile: build build-docker
