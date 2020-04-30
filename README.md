```
# Generate config for host
sed 's/__host__/192.168.150.129/g' etc/realm.tpl.json > etc/realm.json
sed 's/__host__/192.168.150.129/g' src/main/resources/application.tpl.yml > src/main/resources/application.yml

# Create SprintBoot application
mvn clean install

# Build docker image
docker build -t cocoradora/spring-oidc-webapp-demo .

# Startup docker compose
docker-compose up -d
```


* Public area, `http://192.168.150.129:5410`
* Protected area `http://192.168.150.129:5410/customers`
* Calls to `http://192.168.150.129:5410/customers` will get redirected to `http://192.168.150.129:5420/auth`
* After a successful login, user will get redirected back to `http://192.168.150.129:5410/customers`
