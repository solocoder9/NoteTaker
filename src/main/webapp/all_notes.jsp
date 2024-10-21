<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All notes: Note Taker</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>

    <div class="container">
        <%@include file="navbar.jsp"%>
        <br>
        <h1 class="text-uppercase">All Notes:</h1>

        <div class="row">
            <div class="col-12">
                <%
                // Creating SimpleDateFormat instance to format the date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                
                // Open a new session from the factory
                Session s = FactoryProvider.getFactory().openSession();
                Query q = s.createQuery("FROM Note");
                List<Note> list = q.list(); // Retrieve the list of notes

                // Loop through the list of notes and display them
                for (Note note : list) {
                %>

                <div class="card mt-3">
                    <img class="card-img-top m-4 mx-auto" style="max-width: 100px;" src="img/notes.png" alt="Card image cap">
                    <div class="card-body px-5">
                        <h5 class="card-title"><%= note.getTitle() %></h5>
                        <p class="card-text"><%= note.getContent() %></p>

                        <p>
                            <b><%= dateFormat.format(note.getAddedDate()) %></b> <!-- Formatted date -->
                        </p>

                        <div class="container text-center mt-2">
                            <a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-secondary">Update</a>
                            <a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                </div>

                <%
                }
                s.close(); // Close the session
                %>
            </div>
        </div>
    </div>

</body>
</html>
