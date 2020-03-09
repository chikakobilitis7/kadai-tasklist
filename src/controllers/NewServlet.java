
package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DBUTilで設定したEntityManagerを作る
		EntityManager em = DBUtil.createEntityManager();

		/*処理をしている間は外部からデータにアクセスできないようにする処理
		*beginで処理開始
		*/
		em.getTransaction().begin();

		//Taskのインスタンスを作成
		Task t = new Task();

		/*Taskの各プロパティを代入
		 * created_at, updated_at, content */

		/*created_at, updated_at
		 * 現在の時刻を取得する*/
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		t.setCreted_at(currentTime);
		t.setUpdated_at(currentTime);

		String content = "明日でいい";
		t.setContent(content);

		//DBに保存
		em.persist(t);
		em.getTransaction().commit();

		//自動採番されたIDの値を表示
		response.getWriter().append(Integer.valueOf(t.getId()).toString());

		em.close();



	}

}
