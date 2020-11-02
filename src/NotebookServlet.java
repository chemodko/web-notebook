import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/notebook/*")
public class NotebookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Notebook notebook;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            notebook = new Notebook("/home/artem/tplabs/apache-tomcat-9.0.39/webapps/lab13/src/notebook.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        notebook.add(request.getParameter("name"), request.getParameter("number"), "@" + request.getParameter("group"));
        getServletContext().getRequestDispatcher("/jsps/main.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String uri = request.getRequestURI();
        if (uri.equals("/lab13/notebook")) {
            getServletContext().getRequestDispatcher("/jsps/main.jsp").forward(request, response);
        }
        else {
            String[] data = uri.split("/");
            request.setAttribute("group", data[3]);
            request.setAttribute("map", notebook.getMap());
            request.setAttribute("groups", notebook.getGroups());
            getServletContext().getRequestDispatcher("/jsps/somebody.jsp").forward(request, response);
        }
    }
}