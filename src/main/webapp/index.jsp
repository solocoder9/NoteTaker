<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title>Note Taker: Home Page</title>
    
    <%@include file="all_js_css.jsp"%>
</head>
<body>

    <div class="container">
        <%@include file="navbar.jsp"%>
        <br>

        <div class="card shadow bg-white my-5 p-3">
            <img alt="Notes" class="img-fluid mx-auto" style="max-width: 400px;" src="img/notes.png">
            <h1 class="text-info text-uppercase text-center mt-3">Start taking your notes</h1>

            <div class="container text-center">
                <a href="add_notes.jsp" class="btn btn-outline-info">Start here</a>
            </div>
        </div>
    </div>

</body>
</html>
