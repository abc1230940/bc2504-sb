# ! Step 0: shut down all docker container
docker compose down

# ! (Optional) Remove old container
docker rm coin-app
docker rm crypto-app

# ! Step 1: maven install and docker build
cd demo-coingecko
mvn clean install
docker build -t demo-coingecko:0.0.1 -f Dockerfile .
cd ..
cd demo-crypto
mvn clean install
docker build -t demo-crypto:0.0.1 -f Dockerfile .
cd ..

# ! Step 2: docker run (docker-compose is shortcut for docker run)
docker compose up -d