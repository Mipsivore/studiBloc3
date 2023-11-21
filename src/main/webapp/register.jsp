<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouvel utilisateur</title>

        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>

        <%@include  file="components/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row mt-3">
                <div class="col-md-4 offset-md-4">                  

                    <div class="card">                        
                        <%@include  file="components/message.jsp" %>                        
                        <div class="card-body px-5">
                            <div class="container text-center">
                                <img src="img/add-friend.png"  style="max-width: 100px;" class="img-fluid" alt="">
                            </div>


                            <h3 class="text-center my-3">Création de compte</h3>

                            <form action="RegisterServlet" method="post">

                                <div class="form-group">
                                    <label for="name">Nom d'utilisateur</label>
                                    <input name="user_name" type="text" class="form-control" id="name" placeholder="Votre nom" aria-describedby="emailHelp">
                                </div>

                                <div class="form-group">
                                    <label for="email">Email utilisateur</label>
                                    <input name="user_email" type="email" class="form-control" id="email" placeholder="Votre email" aria-describedby="emailHelp">
                                </div>

                                <div class="form-group">
                                    <label for="password">Mot de passe utilisateur</label>
                                    <input name="user_password" type="password" class="form-control" id="password" placeholder="Votre mot de passe" aria-describedby="emailHelp">
                                </div>

                                <div class="form-group">
                                    <label for="phone">Téléphone utilisateur</label>
                                    <input name="user_phone" type="number" class="form-control" id="phone" placeholder="Votre téléphone" aria-describedby="emailHelp">
                                </div>

                                <div class="form-group">
                                    <label for="adress">Adresse utilisateur</label>
                                    <textarea name="user_address" style="height: 200px;" class="form-control" placeholder="Votre adresse"></textarea>


                                </div>

                                <div class="container text-center"> 
                                    <button class="btn btn-outline-success">Enregistrer</button>
                                    <button class="btn btn-outline-warning">Effacer</button>

                                </div>


                            </form>


                        </div>

                    </div>

                </div>
            </div>



        </div>
    </body>
</html>
