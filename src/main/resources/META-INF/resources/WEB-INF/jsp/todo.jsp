<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <title>List ToDo Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</details></h1>
        </div>
        <div>
            <form method="post">
                <!--Any validation provided within html or javascript file (FrontEnd Validation) can be overwritten easily by hacker-->
                Description : <input type="text" name="description" required="required">
                <button type="submit" class="btn btn-success">Submit</button>
            </form>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>