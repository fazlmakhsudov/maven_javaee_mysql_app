package corp.fazsoft.app.app1.controller;

import corp.fazsoft.app.app1.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * it processes login service requests
 */
@WebServlet(urlPatterns = "/main-servlet", initParams = {
        @WebInitParam(name = "Fazliddin", value = "1234"),
        @WebInitParam(name = "Depine", value = "1234"),
        @WebInitParam(name = "Maxudov", value = "1234")})

public class MainServlet extends HttpServlet {
    private static final Map<String, User> users = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        Enumeration<String> initParams = config.getInitParameterNames();
        while (initParams.hasMoreElements()) {
            String login = initParams.nextElement();
            users.put(login, new User(login, config.getInitParameter(login)));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean actionFlag = doAction(req);
        req.getRequestDispatcher("/WEB-INF/jsp/mainpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean actionFlag = doAction(req);
        req.getRequestDispatcher("/WEB-INF/jsp/mainpage.jsp").forward(req, resp);
    }

    private boolean doAction(HttpServletRequest request) {
        boolean actionFlag = false;
        String action = request.getParameter("action");
        switch (action) {
            case "registration":
                actionFlag = doRegister(request);
                break;
            case "login":
                actionFlag = doLogin(request);
                break;
        }
        return actionFlag;
    }

    private boolean doRegister(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        request.removeAttribute("actionResult");
        if (login.isEmpty() || login == null || password == null || users.containsKey(login)) {
            request.setAttribute("actionResult", "register is unsuccessful");
            return false;
        }
        users.put(login, new User(login, password));
        request.setAttribute("actionResult", "register is successful, " + login);
        return true;
    }

    private boolean doLogin(HttpServletRequest request) {
        System.out.println("do Login method I am in");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        request.removeAttribute("actionResult");
        request.setAttribute("actionResult", "login is unsuccessful");
        if (login.isEmpty() || login == null || password == null || !users.containsKey(login)) {
            return false;
        }
        if (users.get(login).getmPassword().equals(password.trim())) {
            request.setAttribute("actionResult", "login is successful, " + login);
            return true;
        }
        return false;
    }
}
