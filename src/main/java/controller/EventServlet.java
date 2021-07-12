package controller;

import com.google.gson.*;
import model.Event;

import service.impl.EventServiceImpl;
import gsonService.GsonService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EventServlet", value = "/EventServlet")
public class EventServlet extends HttpServlet {
    private final EventServiceImpl eventService = new EventServiceImpl();
    private final Gson gson = GsonService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        if (id == null) {
            List<Event> events = eventService.getAll();
            printWriter.println(gson.toJson(events));
        } else {
            Event event = eventService.getById(Long.parseLong(id));
            printWriter.println(gson.toJson(event));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        Event event = gson.fromJson(bufferedReader, Event.class);
        eventService.save(new Event(event.getName(), event.getFile()));

        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        Event event = gson.fromJson(bufferedReader, Event.class);
        eventService.update(event);

        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        Event event = gson.fromJson(bufferedReader, Event.class);
        eventService.deleteById(event.getId());

        doGet(req, resp);
    }
}
