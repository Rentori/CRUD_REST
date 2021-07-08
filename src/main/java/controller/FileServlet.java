package controller;

import com.google.gson.Gson;
import model.Event;
import model.File;
import repository.hibernateImpl.FileRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FileServlet", value = "/FileServlet")
public class FileServlet extends HttpServlet {
    private final FileRepositoryImpl fileRepository = FileRepositoryImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();

        PrintWriter printWriter = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String id = request.getParameter("id");

        if (id == null) {
            List<File> events = fileRepository.getAll();
            printWriter.println(gson.toJson(events));
        }

        else {
            File file = fileRepository.getById(Long.parseLong(id));
            printWriter.println(gson.toJson(file));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
