<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <head>
  <meta charset="UTF-8"> 
  <title>List Of Theaters</title>	
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
                <%String userName =(String)session.getAttribute("userName");
                     %>
                <a class="navbar-brand" href="userHome">Home Page Of 
                       <% out.print(userName); %>
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right"> 
                    <li>
                        <a href="userSearchMovies">Search For Movie</a>
                    </li> 
                    <li>
                        <a href="userProfile">Profile</a>
                    </li> 
                     <li>
                        <a href="logout">Logout</a>
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
    
    <h2>Theaters Lists</h2>
    
    <table class="table table-striped table-hover">
        <thead>
           <tr>
               <th>Theater ID</th>
               <th>Theater Name</th>
               <th>Show Time</th>
               <th>Price</th> 
               <th>Location</th> 
          </tr>
        </thead>  
        <tbody>
          <c:forEach var="theaterMovie" items="${theatersList}" varStatus="status">
            <tr> 
                <td>${theaterMovie.theaterID}</td>
                <td>${theaterMovie.movieID}</td>
                 <td>${theaterMovie.showTime}</td>
                <td>${theaterMovie.price}</td> 
                <td>${theaterMovie.address}</td>
                <td>
                    <a href="userRegisterforMovie?theaterId=${theaterMovie.theaterID}&movieId=${theaterMovie.movieID}&showTime=${theaterMovie.showTime}&price=${theaterMovie.price}&address=${theaterMovie.address}&date=${date}&userName=${userName}" >Register</a> 
                </td>     
             </tr>
           </c:forEach> 
         </tbody>            
     </table>
   </div>
  </div>
  
  <jsp:include page="footer.jsp" />
  
  <jsp:include page="javaScript.jsp" />
  	
 </body>
</html>