<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Notes</title>
    <%@ include file="all_js_css.jsp" %>
</head>
<body>
    <div class="container">
        <%@ include file="navbar.jsp" %>
        <br>
        
        <h1>Please fill in your note details</h1>
        <br>

        <!-- Note addition form -->
        <form action="SaveNoteServlet" method="post">
            <div class="form-group">
                <label for="title">Note Title</label>
                <input name="title" required type="text" class="form-control" id="title" 
                       aria-describedby="emailHelp" placeholder="Enter here" />
            </div>

            <div class="form-group">
                <label for="content">Note Content</label>
                <textarea name="content" required id="content" placeholder="Enter your text here" 
                          class="form-control" style="height:300px;"></textarea>
            </div>

            <div class="container text-center">
                <button type="submit" class="btn btn-info">Add</button>
            </div>
        </form>
    </div>
</body>
</html>
