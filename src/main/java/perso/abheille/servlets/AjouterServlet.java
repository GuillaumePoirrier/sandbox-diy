package perso.abheille.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import perso.abheille.pojos.Article;
import perso.abheille.pojos.Author;
import perso.abheille.pojos.Categorie;
import perso.abheille.pojos.Tag;
import perso.abheille.services.ServiceHolder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajouterArticle")
public class AjouterServlet extends GenericServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");
switch (action){
    case "Nouvelle Categorie":
        try {
            String nomcategorie = request.getParameter("nomcategorie");
            ServiceHolder.getInstance().addCategorie(new Categorie(null,nomcategorie));
        } catch (NullPointerException e) {
            response.sendRedirect("home");
        }
        break;
    case"Nouvel Auteur":
        try {
            String nomAuthor = request.getParameter("nomAuthor");
            String bioAuthor = request.getParameter("bioAuthor");
            ServiceHolder.getInstance().addAuthor(new Author(null,nomAuthor,bioAuthor));

        } catch (NullPointerException e) {
            response.sendRedirect("home");
        }
        break;
    case"Nouveau Projet":
        break;

}

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request, response, request.getServletContext());

        List<Article> listOfArticles = ServiceHolder.getInstance().getAllArticles();
        context.setVariable("listOfArticles", listOfArticles);

        List<Tag> tagList = ServiceHolder.getInstance().getTagList();
        context.setVariable("tagList", tagList);

        List<Categorie> categorieList = ServiceHolder.getInstance().getCategorieList();
        context.setVariable("categorieList", categorieList);

        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        templateEngine.process("ajouterArticle", context, response.getWriter());
    }
}
