package perso.abheille.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import perso.abheille.pojos.Article;
import perso.abheille.pojos.Categorie;
import perso.abheille.pojos.Tag;
import perso.abheille.services.ServiceHolder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/projets")
public class ProjetsServlet extends GenericServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request, response, request.getServletContext());

        List<Article> listArticleToDisplay = ServiceHolder.getInstance().getAllArticles();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.equals("idtag")) {
                listArticleToDisplay = ServiceHolder.getInstance().getArticleByTag(Integer.parseInt(request.getParameter("idtag")));
            } else if (paramName.equals("idcategorie")) {
                listArticleToDisplay = ServiceHolder.getInstance().getArticleByCategory(Integer.parseInt(request.getParameter("idcategorie")));
            }
        }
        context.setVariable("listArticleToDisplay", listArticleToDisplay);

        List<Article> listOfArticles = ServiceHolder.getInstance().getAllArticles();
        context.setVariable("listOfArticles",listOfArticles);

        List<Tag> tagList = ServiceHolder.getInstance().getTagList();
        context.setVariable("tagList", tagList);

        List<Categorie> categorieList = ServiceHolder.getInstance().getCategorieList();
        context.setVariable("categorieList", categorieList);

        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        templateEngine.process("projets", context, response.getWriter());
    }
}
