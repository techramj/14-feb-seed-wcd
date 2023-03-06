import javafx.scene.control.IndexedCellBuilder;

.jsp  ->  .Java (Translation)
.java -> .class (compilation)
load the .class
instantiation
Init
Service
Destroy


html comment vs jsp comment
html comment will take part in Translation
Jsp comment will not take part in Translation
<!-- HTML  comment -->
<%-- Jsp comment -->
<%!  Declaration Tag   %>
<%   scriptlet tag        %>
<%="EXPRESION TAG" %>


====================================================
<% int num1=1000; %>
<%! int num1 = 1111; %>
<%= "num1="+num1 %>

<% void display(){} %>  => ERROR
<%! void display(){} %>
-------------------------------
class Sample1_jsp{

    int num1 = 1111;

    _jspService(){

        int num1 = 1000;
        out.println("num1= "+num1);

        //inside method can't declare another method
        /*void display(){

        }*/
    }

}

interview question:
can we declare any method in the jsp? if yes then which tag.


DIRECTIVE
page Directive:
isErrorPage="true" => object of Throwable will be created
errorPage="errorPagename.jsp"

include


implicit Object

out         JspWriter
request     HttpServletRequest
response    HttpServletResponse
session     HttpSession
config      ServletConfig
application ServletContext
pageContext PageContext
page        Object
exception   Throwable


el attribute
pageScope			   it maps the given attribute name with the value set in the page scope
requestScope		it maps the given attribute name with the value set in the request scope
sessionScope		it maps the given attribute name with the value set in the session scope
applicationScope	it maps the given attribute name with the value set in the application scope
param				it maps the request parameter to the single value


paramValues			it maps the request parameter to an array of values
header				it maps the request header name to the single value
headerValues		it maps the request header name to an array of values
cookie				it maps the given cookie name to the cookie value
initParam			it maps the initialization parameter
pageContext			it provides access to many objects request, session etc.




jsp action tag
-------------
jsp:useBean
jsp:setProperty
jsp:getProperty 
jsp:Include 
jsp:forward 



mvc pattern
---------------
