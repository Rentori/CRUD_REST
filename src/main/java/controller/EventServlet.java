package controller;

import com.google.gson.Gson;
import model.Event;
import service.EventService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EventServlet", value = "/EventServlet")
public class EventServlet extends HttpServlet {
    private final EventService eventService = new EventService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();

        PrintWriter printWriter = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String id = request.getParameter("id");

        if (id == null) {
            List<Event> events = eventService.getAll();
            printWriter.println(gson.toJson(events));
        }

        else {
            Event event = eventService.getById(Long.parseLong(id));
            printWriter.println(gson.toJson(event));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
