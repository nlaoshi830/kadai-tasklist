package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

import javax.persistence.EntityManager;

import models.validators.TaskValidator;

import java.util.List;
/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = (String)request.getParameter("_token");

		if (_token != null && _token.equals(request.getSession().getId())){
		    EntityManager em = DBUtil.createEntityManager();

		    // 登録するタスクのせてい
		    Task t = new Task();

		    String title = request.getParameter("title");
		    t.setTitle(title);

		    String content = request.getParameter("content");
		    t.setContent(content);

		    Timestamp currnetTime = new Timestamp(System.currentTimeMillis());
		    t.setCreated_at(currnetTime);
		    t.setUpdated_at(currnetTime);

		    // Validation
		    List<String> errors = TaskValidator.validate(t);

		    if(errors.size()>0){  // エラーがある場合
		        em.close();

		        request.setAttribute("_token", request.getSession().getId());
		        request.setAttribute("task", t);
		        request.setAttribute("errors", errors);

		        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
		        rd.forward(request, response);

		    }else { // エラーがない場合
    		    em.getTransaction().begin();
    		    em.persist(t);
    		    em.getTransaction().commit();
    		    request.getSession().setAttribute("flush", "登録が完了しました");
    		    em.close();

    		    response.sendRedirect(request.getContextPath() + "/index");

		    }


		}

	}

}
