

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class addproduct
 */
@WebServlet("/addproduct")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("prname");
		int pr = Integer.parseInt(request.getParameter("price"));
		int quant = Integer.parseInt(request.getParameter("pquan"));
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		int cid = Integer.parseInt(request.getParameter("catid"));
		
         
		try
		{
			PrintWriter out = response.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");

		
		
		PreparedStatement ps = con.prepareStatement("insert into product(pname,pprice,quantity,image,catid) values(?,?,?,?,?)");
		
			ps.setString(1, name);
			ps.setInt(2, pr);
			ps.setInt(3, quant);
			if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(4, inputStream);
            }
			ps.setInt(5, cid);
			int row = ps.executeUpdate();
            if (row > 0) {
                String message = "File uploaded and saved into database";
            }
        } 
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
