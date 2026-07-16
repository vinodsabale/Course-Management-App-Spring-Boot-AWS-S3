# 📚 Course Management App — Spring Boot + AWS S3

A simple full-stack web application to manage course details, built with **Spring Boot**, **Thymeleaf**, **MySQL**, and **AWS S3** for image storage.

## 🚀 Features

- Add course details — Name, Duration, Price, and Image
- Course images are uploaded directly to an **AWS S3 bucket**
- Only the **S3 image URL** is stored in the MySQL database (not the file itself)
- View all courses in a clean, tabular UI
- Built using layered architecture — Controller → Service → Repository

## 🛠️ Tech Stack

| Layer         | Technology              |
|---------------|--------------------------|
| Backend        | Spring Boot 3.2.5, Java 17+ |
| Database       | MySQL (Spring Data JPA / Hibernate) |
| Frontend       | Thymeleaf, HTML, CSS |
| File Storage   | AWS S3 (AWS SDK for Java) |
| Build Tool     | Maven |

## 📂 Project Structure

```
Course/
├── src/main/java/com/
│   ├── Config/           → AWS S3 client configuration
│   ├── controller/       → REST/MVC controllers
│   ├── Entity/           → JPA entities
│   ├── Repository/       → Spring Data JPA repositories
│   ├── Service/          → Business logic (Course + S3 upload)
│   └── CourseApplication.java
├── src/main/resources/
│   ├── templates/        → Thymeleaf HTML views
│   └── application.properties.example
└── pom.xml
```

## ⚙️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
```

### 2. Configure the database
Create a MySQL database (or let the app auto-create it):
```sql
CREATE DATABASE practice;
```

### 3. Configure AWS S3
- Create an S3 bucket in your AWS account
- Create an IAM user with `AmazonS3FullAccess` permission
- Generate an Access Key + Secret Key for that IAM user

### 4. Set up application.properties
Copy the example file and fill in your own credentials:
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
Then edit it with your DB and AWS credentials.

> ⚠️ **Never commit your real `application.properties`** — it's excluded via `.gitignore` to keep your AWS/DB credentials safe.

### 5. Run the application
```bash
mvn spring-boot:run
```

The app will be available at:
```
http://localhost:8080/courses/add
```


## 📝 Notes

- Course images are uploaded to S3 and only the resulting URL is persisted in the database.
- IAM permissions should ideally be scoped to a single bucket in production (not `AmazonS3FullAccess`).

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you'd like to change.

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
