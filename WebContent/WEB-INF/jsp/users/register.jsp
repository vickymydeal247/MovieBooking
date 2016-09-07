<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
 
 <head>
  <meta charset="UTF-8"> 
  <title>Register For Examination</title>	
   <jsp:include page="css.jsp" />
 </head>
 
 <body>
 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">Home Page</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right"> 
                    <li>
                        <a href="exam">Search</a>
                    </li>  
                    <li>
                        <a href="login">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 
  <div class="container">
   <div class="bs-example">
    <br><br><br> 
    <form method="POST" action="/MovieBooking/registerUser">
     <div class="form-group">
       <label for="name">Name:</label>
       <input name="name" type="text" class="form-control" id="name"> 
     </div>
     <div class="form-group">
       <label for="email">Email:</label>
       <input name="email" type="email" class="form-control" id="email"> 
     </div>
     <div class="form-group">
       <label for="password">Password:</label>
       <input name="password" type="password" class="form-control" id="password">
     </div>  
     <div class="form-group">
       <label for="phoneNumber">Phone Number</label>
       <input name="phoneNumber" type="number" class="form-control" id="phoneNumber">
     </div>
     <button type="submit" class="btn btn-default">Submit</button>
    </form>
   </div>
  </div>
  
  <jsp:include page="footer.jsp" />
  
  <jsp:include page="javaScript.jsp" />
  	
 </body>
</html>