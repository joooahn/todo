package todo.joooahn;

import java.io.IOException;
import java.util.ArrayList;
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

		
		// type별로 tag 만들
		String todoTag = "<div class=\"type\">TODO</div>";
		for(int i = 0; i < todo.size(); i++)
		{
			todoTag += "<div class=\"item\">"+
				      		 "<div id=\"title\">"+todo.get(i).getTitle()+"</div>"+
			      			 "<div id=\"info\">"+
					      		 "등록날짜:"+todo.get(i).getRegDate()+", "+
					      		 todo.get(i).getName()+", "+
					      		 todo.get(i).getSequence()+
				      		 "</div>"+
		    				 "</div>"	
		    				 ;
		}
		
		String doingTag = "<div class=\"type\">DOING</div>";
		for(int i = 0; i < doing.size(); i++)
		{
			doingTag += "<div class=\"item\">"+
				      		 "<div id=\"title\">"+doing.get(i).getTitle()+"</div>"+
			      			 "<div id=\"info\">"+
					      		 "등록날짜:"+doing.get(i).getRegDate()+", "+
					      			doing.get(i).getName()+", "+
					      			doing.get(i).getSequence()+
				      		 "</div>"+
		    				 "</div>"	
		    				 ;
		}
		
		String doneTag = "<div class=\"type\">DONE</div>";
		for(int i = 0; i < done.size(); i++)
		{
			doneTag += "<div class=\"item\">"+
				      		 "<div id=\"title\">"+done.get(i).getTitle()+"</div>"+
			      			 "<div id=\"info\">"+
					      		 "등록날짜:"+done.get(i).getRegDate()+", "+
					      		 done.get(i).getName()+", "+
					   				 done.get(i).getSequence()+
				      		 "</div>"+
		    				 "</div>"	
		    				 ;
		}
		
		request.setAttribute("todoTag", todoTag);
		request.setAttribute("doingTag", doingTag);
		request.setAttribute("doneTag", doneTag);
        
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
