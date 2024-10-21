<%@page import="com.entities.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Note</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>

    <div class="container">
        <%@include file="navbar.jsp"%>
        <br>
        <h1>Edit your note</h1>
        <br>

        <%
        // Retrieve the note ID from the request parameters
        int noteId = Integer.parseInt(request.getParameter("note_id").trim());

        // Open a new session from the factory and retrieve the note
        Session s = FactoryProvider.getFactory().openSession();
        Note note = (Note) s.get(Note.class, noteId);
        %>

        <!-- Update form for editing the note -->
        <form action="UpdateServlet" method="post">
            <input value="<%= note.getId() %>" name="noteId" type="hidden" />

            <div class="form-group">
                <label for="title">Note Title</label>
                <input name="title" required type="text" class="form-control" id="title" 
                       aria-describedby="emailHelp" placeholder="Enter here" 
                       value="<%= note.getTitle() %>" />
            </div>

            <div class="form-group">
                <label for="content">Note Content</label>
                <textarea name="content" required id="content" 
                          placeholder="Enter your text here" class="form-control" 
                          style="height: 300px;"><%= note.getContent() %>
                </textarea>
            </div>

            <div class="container text-center">
                <button type="submit" class="btn btn-success">Save note</button>
            </div>
        </form>

    </div>

</body>
</html>
