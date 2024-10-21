package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class SaveNoteServlet
 */
@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
        // Default constructor
    }

    // Handles POST requests for saving a note
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Fetch title and content from the request
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            // Create a Note object
            Note note = new Note(title, content, new Date());

            // Open a Hibernate session and start a transaction
            Session session = FactoryProvider.getFactory().openSession();
            Transaction tx = session.beginTransaction();

            // Save the note to the database
            session.save(note);
            tx.commit();
            session.close();

            // Prepare response
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1 style='text-align:center;'>Note is added successfully</h1>");
            out.println("<h1 style='text-align:center;'> <a href='all_notes.jsp'>View all notes</a> </h1>");

        } catch (Exception e) {
            e.printStackTrace();
            // Optionally, you can handle the error response here
        }
    }
}
