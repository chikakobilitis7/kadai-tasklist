package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//DBUtilの設定にもとづいたEntityManagerを作る
		EntityManager em = DBUtil.createEntityManager();
		List<Task> tasks = em.createNamedQuery("getAllTasks",Task.class).getResultList();

		em.close();
		/*DBから取得したタスク一覧(tasks)をリクエストスコープに入れて
		 *"tasks"という名前にする。*/
		request.setAttribute("tasks", tasks);

		/*ServletからJSPを表示させる
		 * requestの内容を指定のJSPに転送させるオブジェクトを作って・・・*/
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
		//指定のJSPへとばす
		rd.forward(request, response);

	}

}
