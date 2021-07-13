package controller;

import com.google.gson.Gson;
import model.File;
import gsonService.GsonService;
import service.impl.FileServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FileServlet", urlPatterns = "/FileServlet")
public class FileServlet extends HttpServlet {
    private final FileServiceImpl fileService = new FileServiceImpl();
    private final Gson gson = GsonService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        if (id == null) {
            List<File> files = fileService.getAll();
            printWriter.println(gson.toJson(files));
        } else {
            File file = fileService.getById(Long.parseLong(id));
            printWriter.println(gson.toJson(file));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        File file = gson.fromJson(bufferedReader, File.class);
        fileService.save(new File(file.getName()));

        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        File file = gson.fromJson(bufferedReader, File.class);
        fileService.update(file);

        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        File file = gson.fromJson(bufferedReader, File.class);
        fileService.deleteById(file.getId());

        doGet(req, resp);
    }
}
