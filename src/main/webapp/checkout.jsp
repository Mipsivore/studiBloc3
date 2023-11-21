<%@page import="com.learn.mycart.entities.UserP"%>
<%

    UserP user = (UserP) session.getAttribute("current-user");
    if (user == null) {

        session.setAttribute("message", "Vous n'êtes pas connecté ! Veuillez vous identifier pour accéder à votre sélection");
        response.sendRedirect("login.jsp");
        return;

    }

%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votre sélection</title>
        <%@include file="components/common_css_js.jsp" %>

    </head>
    <body>
        <%@include  file="components/navbar.jsp" %>

        <div class="container">
            <div class="row mt-5">                

                <div class="col-md-6">
                    <!--card-->
                    <div class="card">
                        <div class="card-body">

                            <h3 class="text-center mb-5">Votre sélection de produits</h3>

                            <div class="cart-body">

                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-md-6">
                    <!--form details-->
                    <!--card-->
                    <div class="card">
                        <div class="card-body">

                            <h3 class="text-center mb-5">Vos informations de commande</h3>
                            <form action="#!">
                                <div class="form-group">
                                    <label for="email">Adresse Email</label>
                                    <input value="<%= user.getUserEmail()%>" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">Nous ne partagerons pas votre email avec d'autres entreprises</small>
                                </div>
                                <div class="form-group">
                                    <label for="name">Votre nom</label>
                                    <input value="<%= user.getUserName()%>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
                                </div>


                                <div class="form-group">
                                    <label for="phone">Votre téléphone</label>
                                    <input value="<%= user.getUserPhone() %>" type="text" class="form-control" id="phone" aria-describedby="emailHelp" placeholder="Votre téléphone">
                                </div>


                                <div class="form-group">
                                    <label for="adress" >Votre adresse de livraison</label>
                                    <textarea value="<%= user.getUserAddress()%>" class="form-control" id="adress" placeholder="Votre adresse" rows="3"></textarea>
                                </div>

                                <div class="container text-center">
                                    <button class="btn btn-outline-success">Imprimer votre sélection</button>
                                    <button class="btn btn-outline-primary">Continuez la chasse aux promotions</button>
                                </div>

                            </form>    

                        </div>
                    </div>
                </div>
            </div>

        </div>


        <%@include  file="components/common_modals.jsp" %>
    </body>
</html>
