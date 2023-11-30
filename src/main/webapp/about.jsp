<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="components/common_css_js.jsp" %>

    </head>
    <body>

        <%@include  file="components/navbar.jsp" %>

       
        <div class="jumbotron">
            <h1>A propos de Mercadona</h1>
            <p>Ce site est un exercice de programmation d'application Java Web d'un site promotionnel pour la chaîne de magasins Mercadona</p>
        </div>

        <div class="container text-center">
                                    
                                    <a href="index.jsp">
                                    <button class="btn btn-outline-primary">Continuez la chasse aux promotions</button>
                                    </a>
        </div>
        
    </body>
</html>
