<%@page import="com.gyt.mycart.entities.UserP"%>
<%

    UserP user = (UserP) session.getAttribute("current-user");
    if (user == null) {

        session.setAttribute("message", "Vous n'êtes pas connecté !! Connectez-vous d'abord pour accéder à la page d'impression");
        response.sendRedirect("login.jsp");
        return;

    }

%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation</title>
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

                            <h3 class="text-center mb-5">Votre selection de produits</h3>

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

                            <h3 class="text-center mb-5">Le détail de votre selection</h3>
                            <form action="#!">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Adresse email</label>
                                    <input value="<%= user.getUserEmail()%>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais votre email avec des entreprises.</small>
                                </div>
                                <div class="form-group">
                                    <label for="name">Votre nom</label>
                                    <input value="<%= user.getUserName()%>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
                                </div>


                                <div class="form-group">
                                    <label for="name">Votre téléphone</label>
                                    <input value="<%= user.getUserPhone() %>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter contact number">
                                </div>


                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1" >Votre adresse</label>
                                    <textarea value="<%= user.getUserAddress()%>" class="form-control" id="exampleFormControlTextarea1" placeholder="Enter your address" rows="3"></textarea>
                                </div>

                                <div class="container text-center">
                                    <button class="btn btn-outline-success">Valider votre selection</button>
                                    <button class="btn btn-outline-primary">Continuer votre selection d'offres</button>
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
