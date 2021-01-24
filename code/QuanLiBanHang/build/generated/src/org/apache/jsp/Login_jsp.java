package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login</title>\n");
      out.write("\n");
      out.write("        <!-- Meta-Tags -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("        <meta name=\"keywords\" content=\"Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design\">\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <!-- //Meta-Tags -->\n");
      out.write("\n");
      out.write("        <link href=\"css/popuo-box.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("\n");
      out.write("        <!-- Style --> <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\">\n");
      out.write("\n");
      out.write("        <!-- Fonts -->\n");
      out.write("        <link href=\"//fonts.googleapis.com/css?family=Quicksand:300,400,500,700\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1></h1>\n");
      out.write("        ");

            if(session.getAttribute("message")!="" && session.getAttribute("message")!=null){
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert(\"");
      out.print( session.getAttribute("message"));
      out.write("\");\n");
      out.write("        </script>\n");
      out.write("        ");
        
            }
        
      out.write("        \n");
      out.write("\t<div class=\"w3layoutscontaineragileits\">\n");
      out.write("\t<h2>ĐĂNG NHẬP</h2>\n");
      out.write("\t\t<form action=\"LoginController\" method=\"post\">\n");
      out.write("\t\t\t<input type=\"text\" Name=\"username\" placeholder=\"ACCOUNT\" required=\"\">\n");
      out.write("\t\t\t<input type=\"password\" Name=\"password\" placeholder=\"PASSWORD\" required=\"\">\n");
      out.write("\t\t\t<ul class=\"agileinfotickwthree\">\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" id=\"brand1\" value=\"\">\n");
      out.write("\t\t\t\t\t<label for=\"brand1\"><span></span>Remember me</label>\n");
      out.write("\t\t\t\t\t<a href=\"#\">Forgot password?</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<div class=\"aitssendbuttonw3ls\">\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"LOGIN\">\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-2.1.4.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- pop-up-box-js-file -->  \n");
      out.write("\t\t<script src=\"js/jquery.magnific-popup.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<!--//pop-up-box-js-file -->\n");
      out.write("\t<script>\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({\n");
      out.write("\t\t\ttype: 'inline',\n");
      out.write("\t\t\tfixedContentPos: false,\n");
      out.write("\t\t\tfixedBgPos: true,\n");
      out.write("\t\t\toverflowY: 'auto',\n");
      out.write("\t\t\tcloseBtnInside: true,\n");
      out.write("\t\t\tpreloader: false,\n");
      out.write("\t\t\tmidClick: true,\n");
      out.write("\t\t\tremovalDelay: 300,\n");
      out.write("\t\t\tmainClass: 'my-mfp-zoom-in'\n");
      out.write("\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
