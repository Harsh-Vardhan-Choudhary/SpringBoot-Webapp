<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
        <title>Enter Todo Details</title>
    </head>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <div>
                <form:form method="post" modelAttribute="todo">

                    <fieldset class="mb-3">
                        <form:label path="description">Description</form:label>
                        <form:input type="text" path="description" class="form-control" required="required"/>
                        <form:errors path="description" cssClass="text-warning"/>
                    </fieldset>

                    <fieldset class="mb-3">
                        <form:label path="targetDate">Target Date</form:label>
                        <form:input type="text" path="targetDate" class="form-control" required="required"/>
                        <form:errors path="targetDate" cssClass="text-warning"/>
                    </fieldset>
                    
                    <form:input type="hidden" path="id"/>
                    <form:input type="hidden" path="done"/>
                    <button type="submit" class="btn btn-success">Submit</button>
                </form:form>
            </div>
        </div>

        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#targetDate').datepicker({
                    format: 'yyyy/mm/dd'
                });
            });
        </script>
    </body>
</html>
