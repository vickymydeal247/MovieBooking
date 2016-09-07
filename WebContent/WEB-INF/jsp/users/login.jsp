<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
 
 <head>
  <meta charset="UTF-8"> 
  <title>Login</title>	
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
                        <a href="addUser">Add User</a>
                    </li> 
                     <li>
                        <a href="logout1">Logout</a>
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
    <form method="POST" action="/MovieBooking/login">
     <div class="form-group">
       <label for="login">Login as</label>
       <select name="login" class="form-control" id="loginas" required>
               <option >Login as</option>
               <option value="Admin">Admin</option>
               <option value="Theater Admin">Theater Admin</option>
               <option value="User">User</option>
       </select>
     </div>
     <div class="form-group">
       <label for="email">Email address:</label>
       <input name="userName" type="email" class="form-control" id="email">
     </div>  
     <div class="form-group">
       <label for="pwd">Password </label>
       <input type="password" name="password"class="form-control" id="password">
     </div>
     <button type="submit" class="btn btn-default">Submit</button>
    </form>
   </div>
  </div>
  
  <jsp:include page="footer.jsp" />
  
  <jsp:include page="javaScript.jsp" />
  	
 </body>
</html>