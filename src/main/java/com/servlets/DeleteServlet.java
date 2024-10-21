package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
        // Default constructor
    }

    // Handles GET requests for deleting a note
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Fetch the note ID from the request
            int noteId = Integer.parseInt(request.getParameter("note_id").trim());

            // Open a Hibernate session and start a transaction
            Session session = FactoryProvider.getFactory().openSession();
            Transaction tx = session.beginTransaction();

            // Retrieve the Note object from the database
            Note note = (Note) session.get(Note.class, noteId);
            if (note != null) {
                // Delete the note if it exists
                session.delete(note);
            }

            // Commit the transaction
            tx.commit();
            session.close();

            // Redirect to the page showing all notes
            response.sendRedirect("all_notes.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            // Optionally, handle the error response here
        }
    }
}
