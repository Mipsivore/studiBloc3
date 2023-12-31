<%@page import="com.learn.mycart.entities.UserP"%>
<%
    UserP user1 = (UserP) session.getAttribute("current-user");

%>


<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Mercadona</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Accueil <span class="sr-only">(current)</span></a>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Info</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="about.jsp">A propos...</a>
                    </div>
                </li>
                
                <li class="nav-link" style="color:darkgray; width:520px; font-style:italic; vertical-align: middle;">
                     <MARQUEE BEHAVIOR="scroll" DIRECTION="left" SCROLLAMOUNT="5">Pour tester la console d'administration, veuillez utiliser le compte dont le login est "admin@studi.fr" et le mot de passe "JAVA2023"             </MARQUEE>
                </li>
                

            </ul>

            <ul class="navbar-nav ml-auto">


                <li class="nav-item active">
                    <a class="nav-link" href="#!" data-toggle="modal" data-target="#cart">  <i class="fa fa-cart-plus"  style="font-size: 20px;"></i> <span class="ml-0 cart-items">( 0 )</span>  </a>
                </li>



                <%                    if (user1 == null) {

                %>

                <li class="nav-item active">
                    <a class="nav-link" href="login.jsp">Identification </a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="register.jsp">Enregistrement </a>
                </li>


                <%                        } else {


                %>
                <li class="nav-item active">
                    <a class="nav-link" href="<%=  user1.getUserType().equals("admin") ? "admin.jsp" : "normal.jsp"%>"><%= user1.getUserName()%> </a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="LogoutServlet">Déconnexion </a>
                </li>



                <%    }

                %>




            </ul>

        </div>

    </div>
</nav>