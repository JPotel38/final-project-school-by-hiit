# portail-suivi-formation

## Démarrer l'application :
 - Avec Maven :
    `mvn spring-boot:run`
 - Avec l'IDE , lancer la classe PortailDeSuiviDeFormationApplication 

## Démarrer l'application avec un profile
 - Avec Maven :
    `mvn spring-boot:run -Dspring-boot.run.profiles={profile_name}`
 - Avec l'IDE, avec les options de la VM dans la conf du runner : `-Dspring.profiles.active={profile_name}`
 
 - Actuellement nous avons les profiles :
    - par default : avec la base h2
    - server : pour la base postgres

## installation postgres :
- ex avec docker :
    - `docker run -p 5432:5432 --name fil-rouge-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres`
    - `docker ps` : pour avoir la liste des containers 
    - `docker exec -it <contener-id> psql -U postgres`
- create la table users, insert into ...

## start mysql in docker
```bash
docker run --name mysql -p 127.0.0.1:3306:3306/tcp -e MYSQL_ROOT_PASSWORD=yoursecretpassword -e MYSQL_DATABASE=portail-suivi-formation -d mysql
```
