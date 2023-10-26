package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.JSONObject;
import evoting.dao.CandidateDetails;
import java.util.ArrayList;

public final class adminshowcandidate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

    String userid=(String)session.getAttribute("userid");
    if(userid==null)
    {
        response.sendRedirect("accessdenied.html");
        return;
    }
    String result=(String)request.getAttribute("result");
    System.out.println(result);
    StringBuffer displayBlock=new StringBuffer("");
    if(result.equals("candidateList"))
    {
        ArrayList<String> candidateId=(ArrayList)request.getAttribute("candidateId");
        //displayBlock.append("<option>Chose Id</option>");
        for(String c:candidateId)
        {
            displayBlock.append((char)34+"<option value='"+c+"'>"+c+"</option>");
        }
        displayBlock.append((char)34);
        out.println(displayBlock);
    }
    else if(result.equals("details"))
    {
        CandidateDetails candidate=(CandidateDetails)request.getAttribute("candidate");
        String str="<img src='data:image/jpg;base64,"+candidate.getSymbol()+"' style='width:300px;height:200px;'/>";
        displayBlock.append((char)34+"<table>"
                            +"<tr><th>User Id:</th><td>"+candidate.getUserId()+"</td></tr>"
                            +"<tr><th>Candidate Name:</th><td>"+candidate.getCandidateName()+"</td></tr>"
                            +"<tr><th>City:</th><td>"+candidate.getCity()+"</td></tr>"
                            +"<tr><th>Party:</th><td>"+candidate.getParty()+"</td></tr>"
                            +"<tr><th>Symbol:</th><td id='image'></td></tr>"
                            +"</table>"+(char)34);
        System.out.println(displayBlock);
        JSONObject json=new JSONObject();
        json.put("image", str);
        json.put("subdetails", displayBlock);
        out.println(json);
    }
    System.out.println("in admin show candidate");
    System.out.println(displayBlock);

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
