

<%@page import="com.learn.mycart.helper.Helper"%>
<%@page import="com.learn.mycart.entities.Category"%>
<%@page import="com.learn.mycart.dao.CategoryDao"%>
<%@page import="com.learn.mycart.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.learn.mycart.dao.ProductDao"%>
<%@page import="com.learn.mycart.helper.FactoryProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercadona Accueil </title>
        <%@include file="components/common_css_js.jsp" %>

    </head>
    <body>

        <%@include  file="components/navbar.jsp" %>

        <div class="container-fluid">
            <div class="row mt-3 mx-2">

                <% String cat = request.getParameter("category");
                    //out.println(cat);

                    ProductDao dao = new ProductDao(FactoryProvider.getFactory());
                    List<Product> list = null;

                    if (cat == null || cat.trim().equals("all")) {
                        list = dao.getAllProducts();

                    } else {

                        int cid = Integer.parseInt(cat.trim());
                        list = dao.getAllProductsById(cid);

                    }

                    CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
                    List<Category> clist = cdao.getCategories();

                %>



                <!--show categories-->
                <div class="col-md-2">


                    <div class="list-group mt-4">

                        <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
                            Tous les produits
                        </a>




                        <% for (Category c : clist) {
                        %>



                        <a href="index.jsp?category=<%= c.getCategoryId()%>" class="list-group-item list-group-item-action"><%= c.getCategoryTitle()%></a>


                        <%    }
                        %>



                    </div>


                </div>

                <!--show products-->
                <div class="col-md-10">


                    <!--row-->
                    <div class="row mt-4">

                        <!--col:12-->
                        <div class="col-md-12">

                            <div class="card-columns">

                                <!--traversing products-->

                                <%
                                    for (Product p : list) {

                                %>


                                <!--product card-->
                                <div class="card product-card">

                                    <div class="container text-center">
                                        <img src="img/products/<%= p.getpPhoto()%>" style="max-height: 190px;max-width: 100%;width: auto; " class="card-img-top m-2" alt="...">

                                    </div>

                                    <div class="card-body">

                                        <h6 class="card-title"><%= Helper.getSomeFirstWords(p.getpName())%></h6>

                                        <p class="card-text" <%=Helper.getDisplayTooltype(p.getpDesc())? "title="+"'"+p.getpDesc().replaceAll("\'","`")+"'":""%>>
                                       
                                            <%= Helper.getSomeFirstWords(p.getpDesc())%>

                                        </p>
                                        

                                    </div>

                                    <div class="card-footer text-center">
                                        <button class="btn custom-bg text-white" onclick="add_to_cart(`<%= p.getpId()%>`, `<%=p.getpName()%>`, `<%= p.getPriceAfterApplyingDiscount()%>`)">Ajout à la sélection</button><br>
                                        <button class="btn  btn-outline-secondary price-discounted" style="color:<%= p.getpDiscount()==0.0 ? "black" : "red" %>"><%= p.getPriceAfterApplyingDiscount()%>  &#8364;  <span class="discount-label"><%= p.getpDiscount()!=0.0 ? "/ <s>"+p.getpPrice()+"</s> &#8364;, (-"+p.getpDiscount()+"%)" : ""%></span></button>

                                    </div>



                                </div>






                                <%}

                                    if (list.size() == 0) {
                                        out.println("<h3>Aucun produits dans cette catégorie</h3>");
                                    }


                                %>


                            </div>                     



                        </div>                   

                    </div>



                </div>

            </div>
        </div>



        <%@include  file="components/common_modals.jsp" %>

    </body>
</html>
