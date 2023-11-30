function add_to_cart(pid, pname, price)
{

    let cart = localStorage.getItem("cart");
    if (cart === null)
    {
        //no cart yet  
        let products = [];
        let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: price};
        products.push(product);
        localStorage.setItem("cart", JSON.stringify(products));
        console.log("Produit ajouté pour la première fois "+pid+" "+pname+" "+price);
        showToast("Le produit est ajouté à votre sélection");
    } else
    {
        //cart is already present
        let pcart = JSON.parse(cart);

        let oldProduct = pcart.find((item) => item.productId === pid);
        console.log(oldProduct);
        if (oldProduct)
        {
            //we have to increase the quantity
            oldProduct.productQuantity = oldProduct.productQuantity + 1;
            pcart.map((item) => {

                if (item.productId === oldProduct.productId)
                {
                    item.productQuantity = oldProduct.productQuantity;
                }

            });
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("La quantité de produit a été augmentée");
            showToast(oldProduct.productName + " La quantité à été augmentée , Quantité = " + oldProduct.productQuantity);

        } else
        {
            //we have add the product
            let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: price};
            pcart.push(product);
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("Le produit a été ajouté");
            showToast("Le produit a été ajouté à votre sélection");
        }


    }


    updateCart();

}

//update cart:

function updateCart()
{
    let cartString = localStorage.getItem("cart");
    let cart = JSON.parse(cartString);
    if (cart === null || cart.length === 0)
    {
        console.log("Votre sélection est vide !!");
        $(".cart-items").html("( 0 )");
        $(".cart-body").html("<h3>Votre selection ne contient aucun produit !</h3>");
        $(".checkout-btn").attr('disabled', true);
    } else
    {


        //there is some in cart to show
        console.log(cart);
        $(".cart-items").html(`( ${cart.length} )`);
        let table = `
            <table class='table'>
            <thead class='thread-light'>
                <tr>
                <th>Nom des produits </th>
                <th>Prix </th>
                <th>Quantité </th>
                <th>Prix total </th>
                <th>Action</th>
                
        
                </tr>
        
            </thead>

        


            `;

        let totalPrice = 0;
        cart.map((item) => {


            table += `
                    <tr>
                        <td> ${item.productName} </td>
                        <td> ${item.productPrice} </td>
                        <td> ${item.productQuantity} </td>
                        <td> ${Math.round(item.productQuantity * item.productPrice * 100)/100} </td>
                        <td> <button onclick='deleteItemFromCart(${item.productId})' class='btn btn-danger btn-sm'>Supprimer</button> </td>    
                     </tr>
                 `;

            totalPrice += item.productPrice * item.productQuantity;

        });
            //Set format with two decimal places
            totalPrice=Math.round(totalPrice*100)/100;


            table += `
                    <tr>
                        <td colspan='5' class='text-right font-weight-bold m-5'> Prix total : ${totalPrice} </td>
                    </tr>
             </table>`;
        
        $(".cart-body").html(table);
        $(".checkout-btn").attr('disabled', false);
        console.log("removed");

    }

}


//delete item 
function deleteItemFromCart(pid)
{
    let cart = JSON.parse(localStorage.getItem('cart'));

    let newcart = cart.filter((item) => item.productId != pid);

    localStorage.setItem('cart', JSON.stringify(newcart));

    updateCart();

    showToast("Le produit a été supprimé de votre sélection ");

}


$(document).ready(function () {

    updateCart();
});


function showToast(content) {
    $("#toast").addClass("display");
    $("#toast").html(content);
    setTimeout(() => {
        $("#toast").removeClass("display");
    }, 2000);
}


function goToCheckout() {

    window.location = "checkout.jsp";

}