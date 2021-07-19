package servlet;

import com.google.gson.Gson;
import model.User;
import gsonService.GsonService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private final UserServiceImpl userService = new UserServiceImpl();
    private final Gson gson = GsonService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        if (id == null) {
            List<User> users = userService.getAll();
            printWriter.println(gson.toJson(users));
        } else {
            User user = userService.getById(Long.parseLong(id));
            printWriter.println(gson.toJson(user));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        User user = gson.fromJson(bufferedReader, User.class);
        userService.save(user);

        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        User user = gson.fromJson(bufferedReader, User.class);
        userService.update(user);

        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        User user = gson.fromJson(bufferedReader, User.class);
        userService.deleteById(user.getId());

        doGet(req, resp);
    }
}
