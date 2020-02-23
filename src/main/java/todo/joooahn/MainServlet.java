package todo.joooahn;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TodoDao todoDao = new TodoDao();
		
		List<TodoDto> getList = new ArrayList<TodoDto>();
		List<TodoDto> todo = new ArrayList<TodoDto>();
		List<TodoDto> doing = new ArrayList<TodoDto>();
		List<TodoDto> done = new ArrayList<TodoDto>();
		
		getList = todoDao.getTodo();
		
		// type별로 분리 
		for(TodoDto item : getList)
		{
	    	//String to Date
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	Date to = null;
	    	
			try {
				to = format.parse(item.regDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	//Date to String
	    	format = new SimpleDateFormat("yyyy.MM.dd");
	    	item.regDate = format.format(to);
	    	
			if(item.getType().compareTo("TODO") == 0)
			{
				todo.add(item);
			}
			else if(item.getType().compareTo("DOING") == 0)
			{
				doing.add(item);
			}
			else if(item.getType().compareTo("DONE") == 0)
			{
				done.add(item);
			}
		}
		
		Collections.sort(todo);
		Collections.sort(doing);
		Collections.sort(done);
		
			
		request.setAttribute("todo", todo);
		request.setAttribute("doing", doing);
		request.setAttribute("done", done);
        
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
