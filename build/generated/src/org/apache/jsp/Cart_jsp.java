package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"icon\" href=\"https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png\"\n");
      out.write("              type =\"image/x-icon\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cart | Apple Store</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <script>\n");
      out.write("            function checkReceiver() {\n");
      out.write("                var name = document.getElementById(\"name\").value;\n");
      out.write("                var phone = document.getElementById(\"phone\").value;\n");
      out.write("                var address = document.getElementById(\"address\").value;\n");
      out.write("                var mail = document.getElementById(\"mail\").value;\n");
      out.write("                if (name === \"\" || phone === \"\" || address === \"\") {\n");
      out.write("                    alert(\"Please Login Before Buy!!\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                window.location = \"buy?name=\" + name + \"&address=\" + address + \"&phone=\" + phone + \"&mail=\" +mail;\n");
      out.write("            }\n");
      out.write("            function check() {\n");
      out.write("                var name = document.getElementById(\"name\").value;\n");
      out.write("                var phone = document.getElementById(\"phone\").value;\n");
      out.write("                var address = document.getElementById(\"address\").value;\n");
      out.write("                var authcode = document.getElementById(\"authcode\").value;\n");
      out.write("//                if (name === \"\" || phone === \"\" || address === \"\") {\n");
      out.write("//                    alert(\"Please Login Before Buy!!\");\n");
      out.write("//                    return;\n");
      out.write("//                }\n");
      out.write("                if (authcode === \"\") {\n");
      out.write("                    alert(\"Please Input Code!!\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                window.location = \"addOrder?name=\" + name + \"&address=\" + address + \"&phone=\" + phone + \"&=authcode\" + authcode;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"shopping-cart\">\n");
      out.write("                <div class=\"px-4 px-lg-0\">\n");
      out.write("\n");
      out.write("                    <div class=\"pb-5\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-12 p-5 bg-white rounded shadow-sm mb-5\">\n");
      out.write("\n");
      out.write("                                    <!-- Shopping cart table -->\n");
      out.write("                                    <div class=\"table-responsive\">\n");
      out.write("                                        <table class=\"table\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                        <div class=\"p-2 px-3 text-uppercase\">Product</div>\n");
      out.write("                                                    </th>\n");
      out.write("                                                    <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                        <div class=\"py-2 text-uppercase\">Price</div>\n");
      out.write("                                                    </th>\n");
      out.write("                                                    <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                        <div class=\"py-2 text-uppercase\">Amount</div>\n");
      out.write("                                                    </th>\n");
      out.write("                                                    <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                        <div class=\"py-2 text-uppercase\">Into Money</div>\n");
      out.write("                                                    </th>\n");
      out.write("                                                    <th scope=\"col\" class=\"border-0 bg-light\">\n");
      out.write("                                                        <div class=\"py-2 text-uppercase\">Delete</div>\n");
      out.write("                                                    </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- End -->\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row py-5 p-4 bg-white rounded shadow-sm\">\n");
      out.write("                            <div class=\"col-lg-6\">\n");
      out.write("                                <div class=\"bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold\">Check Out</div>\n");
      out.write("                                <div class=\"p-4\">\n");
      out.write("                                    <div class=\"input-group mb-4 border rounded-pill p-2\">\n");
      out.write("                                        <!--                                        <input type=\"text\" placeholder=\"Nhập Voucher\" aria-describedby=\"button-addon3\" class=\"form-control border-0\">\n");
      out.write("                                                                                <div class=\"input-group-append border-0\">\n");
      out.write("                                                                                    <button id=\"button-addon3\" type=\"button\" class=\"btn btn-dark px-4 rounded-pill\"><i class=\"fa fa-gift mr-2\"></i>Sử dụng</button>\n");
      out.write("                                                                                </div>-->\n");
      out.write("                                        <p>Full Name<input type=\"text\" id=\"name\" aria-describedby=\"button-addon3\" class=\"form-control border-0\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly ></p>\n");
      out.write("                                        <p>Phone<input type=\"text\" id=\"phone\" aria-describedby=\"button-addon3\" class=\"form-control border-0\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode != null ? \"readonly\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" ></p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"input-group mb-4 border rounded-pill p-2\">\n");
      out.write("                                        <p>Address<input type=\"text\" id=\"address\" aria-describedby=\"button-addon3\" class=\"form-control border-0\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode != null ? \"readonly\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" ></p>\n");
      out.write("                                        <p>Mail<input type=\"text\" id=\"mail\" aria-describedby=\"button-addon3\" class=\"form-control border-0\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.mail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode != null ? \"readonly\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" ></p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                            ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("o");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                <tr>\n");
          out.write("                                                    <th scope=\"row\">\n");
          out.write("                                                        <div class=\"p-2\">\n");
          out.write("                                                            <img src=\"Img/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.img}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"Image\" width=\"70\" class=\"img-fluid rounded shadow-sm\">\n");
          out.write("                                                            <div class=\"ml-3 d-inline-block align-middle\">\n");
          out.write("                                                                <h5 class=\"mb-0\"> <a href=\"#\" class=\"text-dark d-inline-block\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h5><span class=\"text-muted font-weight-normal font-italic\"></span>\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </div>\n");
          out.write("                                                    </th>\n");
          out.write("                                                    <td class=\"align-middle\"><strong>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("$</strong></td>\n");
          out.write("                                                    <td class=\"align-middle\">\n");
          out.write("                                                        ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                        ");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                    </td>\n");
          out.write("                                                    <td class=\"align-middle\"><strong>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.price * o.amount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("$</strong></td>\n");
          out.write("                                                    <td class=\"align-middle\"><a href=\"deleteCart?pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"text-dark\">\n");
          out.write("                                                            <button type=\"button\" class=\"btn btn-danger\">Delete</button>\n");
          out.write("                                                        </a>\n");
          out.write("                                                    </td>\n");
          out.write("\n");
          out.write("                                                </tr>\n");
          out.write("                                                ");
          if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("\n");
          out.write("                                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                            ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.amount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                                                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                            <a href=\"buydown?pid=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><button class=\"btnSub\">-</button></a> \n");
        out.write("                                                            <strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.amount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</strong>\n");
        out.write("                                                            <a href=\"buyup?pid=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><button class=\"btnAdd\">+</button></a>\n");
        out.write("                                                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.pup == o.pid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    <tr>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.result}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</tr>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <div class=\"col-lg-6\">\n");
        out.write("                                    <div class=\"bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold\">Into Money</div>\n");
        out.write("                                    <div class=\"p-4\">\n");
        out.write("                                        <ul class=\"list-unstyled mb-4\">\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">TOTAL</strong><strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allTotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" $</strong></li>\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Transport Fee</strong><strong>Free ship</strong></li>\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 $</strong></li>\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">TOTAL ALL</strong>\n");
        out.write("                                                <h5 name =\"all\" class=\"font-weight-bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allTotal+10}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" $</h5>\n");
        out.write("                                            </li>\n");
        out.write("                                        </ul><a href=\"#\" onclick=\"checkReceiver()\" class=\"btn btn-dark rounded-pill py-2 btn-block\">BUY</a>\n");
        out.write("                                    </div>\n");
        out.write("                                </div>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <div class=\"col-lg-6\">\n");
        out.write("                                    <div class=\"bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold\">Into Money</div>\n");
        out.write("                                    <div class=\"p-4\">\n");
        out.write("                                        <ul class=\"list-unstyled mb-4\">\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">TOTAL</strong><strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allTotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" $</strong></li>\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Transport Fee</strong><strong>Free ship</strong></li>\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 $</strong></li>\n");
        out.write("                                            <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">TOTAL ALL</strong>\n");
        out.write("                                                <h5 name =\"all\" class=\"font-weight-bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allTotal+10}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" $</h5>\n");
        out.write("                                            </li>\n");
        out.write("                                        </ul>\n");
        out.write("                                        <!--<a href=\"#\" onclick=\"checkReceiver()\" class=\"btn btn-dark rounded-pill py-2 btn-block\">BUY</a>-->\n");
        out.write("                                    </div>\n");
        out.write("                                </div>\n");
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_if_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_4, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_if_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_4, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_4);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ver == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_if_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_5, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                    ");
        out.write("\n");
        out.write("                                        <!--<p class=\"text-danger\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>-->\n");
        out.write("                                    ");
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_5);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.authcode != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <p class=\"text-danger\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${suc}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                                        \n");
        out.write("                                        <form action=\"addOrder\" method=\"post\">\n");
        out.write("                                            <input type=\"text\" name=\"authcode\" placeholder=\"Enter Code\">\n");
        out.write("                                            <!--<a href=\"#\" onclick=\"check()\" class=\"btn btn-dark\">Submit</a>-->\n");
        out.write("                                            <input type=\"submit\" value=\"Submit\" />\n");
        out.write("                                        </form>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_4);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ver != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <p class=\"text-danger\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ver}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                                    <!--<a class=\"nav-link\" href=\"LoginRegister.jsp\">Login Now</a>-->\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
    return false;
  }
}
