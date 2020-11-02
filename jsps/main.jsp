<html>
    <head>
        <style> <%@ include file="../css/style.css"%> </style>
    </head>
    <body bgcolor="#A9A9A9", class="text">
        <h1> Start page! </h1>
        <h3><a href="/lab13/notebook/All">All</a></h3>
        <h3><a href="/lab13/notebook/Family">Family</a></h3>
        <h3><a href="/lab13/notebook/Friends">Friends</a></h3>
        <h3><a href="/lab13/notebook/Colleagues">Colleagues</a></h3>

        <form method=POST action=/lab13/notebook/add>
            Name: <input type="text" name="name">
            Number: <input type="text" name="number">
            Group: <input type="text" name="group">
            <input type="submit" value="add" class="b1">
        </form>
    </body>
</html>