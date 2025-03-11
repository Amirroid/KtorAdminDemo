# KtorAdminDemo 🚀

A simple demo of **[KtorAdmin](https://github.com/Amirroid/KtorAdmin)** – a powerful admin panel generator for **Ktor** applications. For an online demo, visit [this link](https://ktoradmindemo-production.up.railway.app/admin).

## 🚀 Running the Demo

Clone the repository:
```sh
git clone https://github.com/Amirroid/KtorAdminDemo.git
cd KtorAdminDemo
```  
Update the database configuration in [`application.yaml`](./src/main/resources/application.yaml) by replacing the following values:
```yaml
db:
  username: "${POSTGRES_USER}:amirreza"
  password: "${POSTGRES_PASSWORD}:your_password"
  url: "${DATABASE_URL}:jdbc:postgresql://localhost:5432/postgres"
  driver: "org.postgresql.Driver"
```  
Then, build and run the project:
```sh
./gradlew run
```  
Access the admin panel at `http://localhost:8080/admin`.

## 📖 More Information

Check out the full documentation and latest updates in the **[KtorAdmin repository](https://github.com/Amirroid/KtorAdmin)**.