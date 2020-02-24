package todo.joooahn;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class TodoTypeServlet
 */
@WebServlet("/TodoTypeServlet")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//JSON Parsing
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {/* report an error */ }
				
		JsonParser parser = new JsonParser();
 		JsonElement element = parser.parse(jb.toString());
		long id = element.getAsJsonObject().get("id").getAsLong();
		String type = element.getAsJsonObject().get("type").getAsString();
		
		String nextType = "";
		 
		if(type.compareTo("todo") == 0)
		{
			nextType = "DOING";
		}
		else if(type.compareTo("doing") == 0)
		{
			nextType = "DONE";
		}	
		// type 잘못 들어왔을 경우 
		else 
		{
			response.getWriter().append("fail");
			return;
		}
		
		TodoDao todoDao = new TodoDao();
		int result = todoDao.updateTodo(nextType, id);		
				
		// DB update 잘못됐을 경우 
		if(result > 0)
		{
			response.getWriter().append("success");
		}
		else
		{
			response.getWriter().append("fail");
		}
	}

}
