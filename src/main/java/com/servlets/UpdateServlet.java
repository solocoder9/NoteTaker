package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public UpdateServlet() {
        super();
    }

    // Handles POST requests for updating a note
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Fetch title, content, and note ID from the request
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int noteId = Integer.parseInt(request.getParameter("noteId").trim());

            // Open a Hibernate session and start a transaction
            Session session = FactoryProvider.getFactory().openSession();
            Transaction tx = session.beginTransaction();

            // Retrieve the existing Note object from the database
            Note note = session.get(Note.class, noteId);
            if (note != null) {
                // Update note properties
                note.setTitle(title);
                note.setContent(content);
                note.setAddedDate(new Date()); // Update the date to current

                // Commit the transaction
                tx.commit();
            }

            // Close the session
            session.close();

            // Redirect to the page showing all notes
            response.sendRedirect("all_notes.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            // Optionally, handle the error response here
        }
    }
}
