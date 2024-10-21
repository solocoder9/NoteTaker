
# 📝 NoteTaker

NoteTaker is a Java-based web application that allows users to create, edit, view, and delete notes. It utilizes JSP, Servlets, Hibernate, MySQL, and Bootstrap for an intuitive and efficient note management system.

## Table of Contents

- [🌟 Features](#features)
- [💻 Technologies Used](#technologies-used)
- [🛠️ Setup Instructions](#setup-instructions)
- [🚀 Usage](#usage)
- [🤝 Contributing](#contributing)
- [📝 License](#license)

## 🌟 Features

1. **Note Management:**
   - **Create Note:** Allows users to create notes with a title and content.
   - **View Notes:** Users can view all their created notes.
   - **Edit Notes:** Users can update their notes.
   - **Delete Notes:** Enables users to delete notes they no longer need.

2. **Database Integration:**
   - Uses Hibernate ORM to map Java objects to a MySQL database (`notetaker_db`).
   - Automatically manages the persistence of note entities in the database.

3. **User Interface:**
   - Simple and user-friendly interface using JSP and Bootstrap for responsive design.

## 💻 Technologies Used

- Java
- JSP (JavaServer Pages)
- Servlets
- Hibernate
- MySQL
- Apache Tomcat
- Maven
- Bootstrap (for UI styling)

## 🛠️ Setup Instructions

Follow these steps to set up the **NoteTaker** project on your local environment:

1. **Prerequisites:**
   - JDK (Java Development Kit) installed.
   - MySQL installed with a database named `notetaker_db`.
   - Eclipse IDE (or any Java IDE) installed.
   - Apache Tomcat installed.

2. **Clone the Repository:**
   ```bash
   git clone https://github.com/solocoder9/NoteTaker.git
   ```

3. **Import the Project into Eclipse:**
   - Open Eclipse IDE.
   - Select `File` > `Import` > `Existing Maven Projects`.
   - Browse to the cloned repository and select the project.

4. **Configure MySQL Database:**
   - Make sure MySQL server is running.
   - Create a database named `notetaker_db`:
     ```sql
     CREATE DATABASE notetaker_db;
     ```

5. **Modify Hibernate Configuration:**
   - Open the `hibernate.cfg.xml` file located in the project directory.
   - Update the database connection details (URL, username, password) according to your MySQL setup.

6. **Deploy the Application:**
   - Right-click the project in Eclipse and select `Run As` > `Run on Server`.
   - Deploy the project to Apache Tomcat.
   - Access the application via `http://localhost:8080/NoteTaker`.

## 🚀 Usage

1. **Home Page:**
   - Visit `http://localhost:8080/NoteTaker` to access the homepage.
   - Use the navigation bar to create, view, edit, or delete notes.

2. **Add a New Note:**
   - Click on "Add Note" to create a new note.
   - Fill in the note title and content, then submit the form.

3. **Edit or Delete Notes:**
   - View your notes and click "Edit" to modify an existing note or "Delete" to remove it from the list.

## 🤝 Contributing

Contributions are welcome to improve the NoteTaker project! To contribute:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
