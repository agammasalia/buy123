package buy123;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String insertQuery = "";
	String userid, password, collection, _id, firstname, lastname, email;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			firstname = request.getParameter("firstname");
			lastname = request.getParameter("lastname");
			userid = request.getParameter("userid");
			password = request.getParameter("password");
			email = request.getParameter("email");
			collection = request.getParameter("collection");
			_id = request.getParameter("_id");
			insertQuery = "insert into users (username, password, firstname, lastname, email) values ('" + userid + "', SHA1('" + password + "'), '" + firstname + "', '" + lastname + "', '" + email + "')";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buy123", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(insertQuery);
			HttpSession session = request.getSession(true);
			session.setAttribute("FirstName", firstname);
			session.setAttribute("LastName", lastname);
			session.setAttribute("Collection", collection);
			session.setAttribute("ProductID", _id);
			session.setAttribute("UserID", userid);
			session.setAttribute("Email", email);


			
			int stock=0;
			String searchQuery = "SELECT * FROM `inventory` WHERE `productid`='"+ _id+"';";
			ResultSet rs = stmt.executeQuery(searchQuery);
			while(rs.next()){
				stock = rs.getInt("stock");
			}
			session.setAttribute("Stock", stock);

			
			
			
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("buy123");
			DBCollection table = db.getCollection(collection);
			BasicDBObject searchMongo = new BasicDBObject();
			searchMongo.put("_id", new ObjectId(_id));
			DBCursor cursor = table.find(searchMongo);
			
	        while (cursor.hasNext()) {
	        	DBObject a = cursor.next();
//	        	System.out.println(a);
//	        	System.out.println(a.keySet());
	        	session.setAttribute("Brand", a.get("Brand"));
	        	session.setAttribute("Model", a.get("Model"));
	        	session.setAttribute("Price", a.get("Price"));
//				session.setAttribute("Keys", a.keySet());
//				session.setAttribute("Product", a);
			}
			
			response.sendRedirect("ProductDetail.jsp");
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
