<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
 <head>
  <meta charset="UTF-8"> 
  <title>Add Examination</title>	
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
                        <a href="exam">Search</a>
                    </li> 
                    <li>
                        <a href="addUser">Add User</a>
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
    <form method="POST" action="/ExamScheduler/addExam">
       <div class="form-group">
            <label for="courseId">Course</label> 
			<select name="courseId" class="form-control" id="course" required>
               <option>Select Course</option>
               <c:forEach var="course" items="${courseList}" varStatus="status">
               <option value=${course.courseId}>${course.courseName}</option>
               </c:forEach> 
            </select>
       </div>
       <div class="form-group">
            <label for="examName">Exam Name :</label>
            <input name="examName" type="text" class="form-control" id="examName" required>
       </div>
       <div class="form-group">
            <label for="d">Date :</label>
            <input name="d" type="text" class="form-control" id="d" required>
       </div>  
       <div class="form-group">
            <label for="fees">Fees :</label>
            <input name="fees" type="text" class="form-control" id="fees" required>
       </div>
       <div class="form-group">
            <label class="checkbox-inline"><input type="checkbox" name="city" value="Chennai">Chennai</label>
            <label class="checkbox-inline"><input type="checkbox" name="city" value="Mumbai">Mumbai</label>
            <label class="checkbox-inline"><input type="checkbox" name="city" value="Bangalore">Bangalore</label>
            <label class="checkbox-inline"><input type="checkbox" name="city" value="Delhi">Delhi</label>
            <label class="checkbox-inline"><input type="checkbox" name="city" value="Varanasi">Varanasi</label>
       </div>
       <div class="form-group">
            <label for="seats"> Seats For Each City : </label>
            <input name="seats" type="text" class="form-control" id="seats" required>
       </div>
     <button type="submit" class="btn btn-default">Submit</button>
    </form>
   </div>
  </div>	
  
  <jsp:include page="footer.jsp" />
  
  <jsp:include page="javaScript.jsp" />
  
 </body>
</html>