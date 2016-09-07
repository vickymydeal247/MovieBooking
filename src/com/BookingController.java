package com;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {
	
	@Autowired
	private MovieBookingDAOImpl movieBookingDAOImpl;
	
	// flow for non login users
	
	// index page
	@RequestMapping(value = {"/" ,"/index"}, method = RequestMethod.GET)
	public String exam(ModelMap model) {
		
		  List<Movie> movieList = new ArrayList<Movie>();
		
          movieList = movieBookingDAOImpl.showMovie();

          model.addAttribute("movieList", movieList);
		
	      return "users/index";
	   }
	
	// search movie for non login user
	@RequestMapping(value = "/searchMovies", method = RequestMethod.GET)
	public String student(ModelMap model) {
		 
	      return "users/searchMovies";
	   }
	
	// mapping for movie showing on home page
		@RequestMapping(value = "/movieDescription", method = RequestMethod.GET)
		public String movieDescription(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			  String movieId = request.getParameter("id"); 
			  
			  Movie  movie   = new Movie();
			  
			  List<City> cityList = new ArrayList<City>();
			  
			         movie   = movieBookingDAOImpl.movieDetails(movieId);
			         
			         cityList = movieBookingDAOImpl.getCity(movieId);
				
				     model.addAttribute("movieDescription", movie);
				     
				     model.addAttribute("cityList", cityList);
			  
		      return "users/movieDescription";
		   }
	
	// search for movie asynchronous call
	   @RequestMapping(value = "/searchMovie", method = RequestMethod.GET)
	   public String searchMovie(@ModelAttribute("SpringWeb")User user, 
			   ModelMap model, HttpServletRequest request) {
		
		      String city     = request.getParameter("city");
		      String language = request.getParameter("language");
		      
		      System.out.println("city" + city + "language" + language);
		  
		      List<Movie> movieList  = new ArrayList<Movie>();
			 
			          movieList  = movieBookingDAOImpl.showMovie(city, language);
			          
			          System.out.println("hiiiiiiiii");
			
			  model.addAttribute("movieList", movieList);
		  
	          return"users/ajaxSearchResult";
	   }
	
	// search for theaters for a movie in a city
		@RequestMapping(value = "/searchTheaters", method = RequestMethod.POST)
		public String searchTheaters(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			   String movieId = request.getParameter("movieId");
			   String city    = request.getParameter("city");
			   String date    = request.getParameter("date");
			  
			   System.out.println("movieId" + movieId + "city" + city + "date" + date);
			  
			   List<TheaterMovie> theatersList  = new ArrayList<TheaterMovie>();
				 
				             theatersList  = movieBookingDAOImpl.getTheaters(movieId, city, date);
				             
				model.addAttribute("date", date);             
				
				model.addAttribute("theatersList", theatersList);
			  
		       return"users/searchTheaters";
		   }
		
	// book movie for non login users
		@RequestMapping(value = "/registerforMovie", method = RequestMethod.GET)
		public String bookMovie(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			   String theaterId = request.getParameter("theaterId");
			   String movieId    = request.getParameter("movieId");
			   System.out.println(request.getParameter("showTime"));
			   int showTime    =  Integer.parseInt(request.getParameter("showTime"));
			   int price    =    Integer.parseInt(request.getParameter("price"));
			   String address    = request.getParameter("address");
			   String date    = request.getParameter("date");
			  
			   System.out.println("theaterId" + theaterId + "movieId" + movieId + "showTime" + showTime + "price" + price + "address" + address + "date" + date);
			  
			   TheaterMovie theaterMovie = new TheaterMovie();
			   
			                theaterMovie.setTheaterID(theaterId);
			                theaterMovie.setMovieID(movieId);
			                theaterMovie.setShowTime(showTime);
			                theaterMovie.setPrice(price);
			                theaterMovie.setAddress(address);
				 
				model.addAttribute("date", date);             
				
				model.addAttribute("theaterMovie", theaterMovie);
			  
		       return"users/registerforMovie";
			   
		   }
		
	// book movie for non login users
		@RequestMapping(value = "/registerforMovie", method = RequestMethod.POST)
		public String bookingMovie(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			   String theaterId = request.getParameter("theaterId");
			   String movieId    = request.getParameter("movieId");
			   int showTime    =  Integer.parseInt(request.getParameter("showTime"));
			   int price    =    Integer.parseInt(request.getParameter("price"));
			   String address    = request.getParameter("address");
			   String date    = request.getParameter("date");
			   String email    = request.getParameter("email");
			   long mobile   = Long.parseLong(request.getParameter("mobile"));
			  
			   System.out.println("theaterId" + theaterId + "movieId" + movieId + "showTime" + showTime + "price" + price + "address" + address + "date" + date);
			  
			   TheaterMovie theaterMovie = new TheaterMovie();
			   
			                theaterMovie.setTheaterID(theaterId);
			                theaterMovie.setMovieID(movieId);
			                theaterMovie.setShowTime(showTime);
			                theaterMovie.setPrice(price);
			                theaterMovie.setAddress(address);
			                
			    UserMovieTheaterShowTiming userMovieTheaterShowTiming = new UserMovieTheaterShowTiming();            
			                
			                               userMovieTheaterShowTiming = movieBookingDAOImpl.bookTickets(email, theaterMovie, mobile, date);
			                               
			     String movieName = movieBookingDAOImpl.getMovieName(movieId);                          
				
			    /*model.addAttribute("email", email);             
							
				model.addAttribute("mobile", mobile);            
			                
				model.addAttribute("date", date);*/             
				
			    model.addAttribute("movieName", movieName);
			    
			    model.addAttribute("address", address);
			     
				model.addAttribute("userMovieTheaterShowTiming", userMovieTheaterShowTiming);
			  
		       return"users/showTicket";
			   
		   }
		
	
	// login page
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login() {
	          return "users/login";
	    }
	
	// login
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String login(@ModelAttribute("SpringWeb")User user, 
			   ModelMap model, HttpServletRequest request) {   
		
		     String loginas  = request.getParameter("login");
		     String userName = request.getParameter("userName");
		     String password = request.getParameter("password");
		
		     /*System.out.println(loginas + " " + userName + " " + password);*/
		
		     int v = movieBookingDAOImpl.login(loginas, userName, password);
		
		     if(v>0 && loginas.equalsIgnoreCase("Admin"))
		     {
		           List<Movie> courseList = new ArrayList<Movie>();
			
                        courseList = movieBookingDAOImpl.showMovie(); 
                        
                        HttpSession session=request.getSession();  
                        session.setAttribute("userName",userName);

                   model.addAttribute("courseList", courseList);
			       return("admin/adminHome");
		     }
		
		     if(v>0 && loginas.equalsIgnoreCase("Theater Admin"))
		     {
		           List<Movie> courseList = new ArrayList<Movie>();
			
                        courseList = movieBookingDAOImpl.showMovie(); 
                        
                        HttpSession session=request.getSession();  
                        session.setAttribute("userName",userName);

                   model.addAttribute("courseList", courseList);
			       return("theaterAdmin/theaterAdminHome");
		     }
		
		     if(v>0 && loginas.equalsIgnoreCase("User"))
		     {
		           List<Movie> movieList = new ArrayList<Movie>();
			
                        movieList = movieBookingDAOImpl.showMovie(); 
                        
                        HttpSession session=request.getSession();  
                        session.setAttribute("userName",userName);

                   model.addAttribute("movieList", movieList);
			       return("loginUsers/userHome");
		     }
		
			 return("users/login");
			
	    }
	
	// register page
	    @RequestMapping(value = "/register", method = RequestMethod.GET)
	    public String register() {
	      return "users/register";
	    }
	
	// register user
	    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	    public String addUser(@ModelAttribute("SpringWeb")User user, 
			   ModelMap model, HttpServletRequest request) {   
		
		String name = request.getParameter("name");
		String userName = request.getParameter("email");
		String password  = request.getParameter("password");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		
		/*System.out.println(phoneNumber);*/
		
		movieBookingDAOImpl.registerUser(name, userName, password, phoneNumber); 
		
		List<Movie> movieList = new ArrayList<Movie>();
		
        movieList = movieBookingDAOImpl.showMovie(); 
        
        HttpSession session=request.getSession();  
        session.setAttribute("userName",userName);

        model.addAttribute("movieList", movieList);
        return("userHome");
		
	    }
	
	// mapping movie from user home page 
	    @RequestMapping(value = "/userMovieDescription", method = RequestMethod.GET)
		public String userMovieDescription(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			  String movieId = request.getParameter("id"); 
			  
			  Movie  movie   = new Movie();
			  
			  List<City> cityList = new ArrayList<City>();
			  
			         movie   = movieBookingDAOImpl.movieDetails(movieId);
			         
			         cityList = movieBookingDAOImpl.getCity(movieId);
				
				     model.addAttribute("movieDescription", movie);
				     
				     model.addAttribute("cityList", cityList);
			  
		      return "loginUsers/userMovieDescription";
		   }
	    
	// search for theaters for a movie in a city
	    @RequestMapping(value = "/userSearchTheaters", method = RequestMethod.POST)
		public String usersSearchTheaters(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			   String movieId = request.getParameter("movieId");
			   String city    = request.getParameter("city");
			   String date    = request.getParameter("date");
			  
			   System.out.println("movieId" + movieId + "city" + city + "date" + date);
			  
			   List<TheaterMovie> theatersList  = new ArrayList<TheaterMovie>();
				 
				             theatersList  = movieBookingDAOImpl.getTheaters(movieId, city, date);
				             
				model.addAttribute("date", date);             
				
				model.addAttribute("theatersList", theatersList);
			  
		       return"loginUsers/userSearchTheaters";
		   }
	    
	// register for movie
	    @RequestMapping(value = "/userRegisterforMovie", method = RequestMethod.GET)
		public String userBookMovie(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			   String theaterId = request.getParameter("theaterId");
			   String movieId    = request.getParameter("movieId");
			   System.out.println(request.getParameter("showTime"));
			   int showTime    =  Integer.parseInt(request.getParameter("showTime"));
			   int price    =    Integer.parseInt(request.getParameter("price"));
			   String address    = request.getParameter("address");
			   String userName   = request.getParameter("userName");
			   String date    = request.getParameter("date");
			  
			   System.out.println("theaterId" + theaterId + "movieId" + movieId + "showTime" + showTime + "price" + price + "address" + address + "userName" + userName +  "date" + date);
			  
			   TheaterMovie theaterMovie = new TheaterMovie();
			   
			                theaterMovie.setTheaterID(theaterId);
			                theaterMovie.setMovieID(movieId);
			                theaterMovie.setShowTime(showTime);
			                theaterMovie.setPrice(price);
			                theaterMovie.setAddress(address);
			                
			    long mobile = movieBookingDAOImpl.mobile(userName);
			    
			    model.addAttribute("mobile", mobile);
				 
				model.addAttribute("date", date);             
				
				model.addAttribute("theaterMovie", theaterMovie);
			  
		       return"loginUsers/userRegisterforMovie";
			   
		   }
	    
	// book movie for register users
	    @RequestMapping(value = "/userRegisterforMovie", method = RequestMethod.POST)
		public String usersBookingMovie(@ModelAttribute("SpringWeb")User user, 
				   ModelMap model, HttpServletRequest request) {
			
			   String theaterId = request.getParameter("theaterId");
			   String movieId    = request.getParameter("movieId");
			   int showTime    =  Integer.parseInt(request.getParameter("showTime"));
			   int price    =    Integer.parseInt(request.getParameter("price"));
			   String address    = request.getParameter("address");
			   String date    = request.getParameter("date");
			   String email    = request.getParameter("email");
			   long mobile   = Long.parseLong(request.getParameter("mobile"));
			  
			   System.out.println("theaterId" + theaterId + "movieId" + movieId + "showTime" + showTime + "price" + price + "address" + address + "date" + date);
			  
			   TheaterMovie theaterMovie = new TheaterMovie();
			   
			                theaterMovie.setTheaterID(theaterId);
			                theaterMovie.setMovieID(movieId);
			                theaterMovie.setShowTime(showTime);
			                theaterMovie.setPrice(price);
			                theaterMovie.setAddress(address);
			                
			    UserMovieTheaterShowTiming userMovieTheaterShowTiming = new UserMovieTheaterShowTiming();            
			                
			                               userMovieTheaterShowTiming = movieBookingDAOImpl.bookTickets(email, theaterMovie, mobile, date);
			                               
			     String movieName = movieBookingDAOImpl.getMovieName(movieId);                          
				
			    /*model.addAttribute("email", email);             
							
				model.addAttribute("mobile", mobile);            
			                
				model.addAttribute("date", date);*/
			     
			    System.out.println("address" +  address); 
				
			    model.addAttribute("movieName", movieName);
			    
			    model.addAttribute("address", address);
			     
				model.addAttribute("userMovieTheaterShowTiming", userMovieTheaterShowTiming);
			  
		       return"loginUsers/userShowTicket";
			   
		   }
	
}
