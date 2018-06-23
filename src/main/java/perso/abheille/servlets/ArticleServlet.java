package perso.abheille.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import perso.abheille.daos.ArticleDao;
import perso.abheille.pojos.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import perso.abheille.pojos.Categorie;
import perso.abheille.pojos.Tag;
import perso.abheille.services.ServiceHolder;

import static java.lang.System.out;

@WebServlet("/article")
public class ArticleServlet extends GenericServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request, response, request.getServletContext());

        Article article = ServiceHolder.getInstance().getArticleById(Integer.parseInt(request.getParameter("idarticle")));

        List<Article> listOfArticles = ServiceHolder.getInstance().getAllArticles();
        context.setVariable("listOfArticles",listOfArticles);

        List<Tag> tagList = ServiceHolder.getInstance().getTagList();
        context.setVariable("tagList",tagList);

        List<Categorie> categorieList = ServiceHolder.getInstance().getCategorieList();
        context.setVariable("categorieList",categorieList);

        Parser parser = Parser.builder().build();
        Node document = parser.parse(article.getContenu());
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(document);
        context.setVariable("contenu",html);

        context.setVariable("article",article);

        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        templateEngine.process("article", context, response.getWriter());
    }
}
