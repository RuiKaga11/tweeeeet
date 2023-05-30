package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tweet;
import model.TweetLogic;

/**
 * Servlet implementation class TweetController
 */
@WebServlet("/TweetController")
public class TweetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//フォワード先を振り分ける
		String forwardPath = null;
		//振り分けに必要な値をリクエストパラメータから取得
		String action = request.getParameter("action");
		//最初のフォワード先
		if(action == null) {
			forwardPath = "/WEB-INF/jsp/etsuran.jsp";
		}
		else if(action.equals("done")) {
			//セッションスコープに保存されたツイート内容を取得
			HttpSession session = request.getSession();
			Tweet tweet = (Tweet) session.getAttribute("tweet");
			//"tweet処理（空）の呼び出し"
			TweetLogic logic = new TweetLogic();
			logic.execute(tweet);
			//いらないセッションスコープ内のインスタンスを削除
			session.removeAttribute("tweet");
			//ツイート後のフォワード先を設定
			forwardPath = "/WEB-INF/jsp/tweet.jsp";
		}

		//振られたフォワード先にアクセス
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/etsuran.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String tweets = request.getParameter("tweet");

		//ツイートの内容を設定
		Tweet tweet = new Tweet(tweets);

		//セッションスコープにツイートを保存
		HttpSession session = request.getSession();
		session.setAttribute("tweet", tweet);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
