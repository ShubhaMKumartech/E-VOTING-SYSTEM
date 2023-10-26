package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.JSONObject;
import evoting.dao.CandidateDetails;
import java.util.ArrayList;

public final class updatecandidate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    StringBuffer displayBlock=new StringBuffer("");
    if(result.equals("cid"))
    {
        ArrayList<String> id=(ArrayList)request.getAttribute("id");
         for(String s:id)
                {
                    displayBlock.append((char)34+"<option value='"+s+"'>"+s+"</option>");
                }
                displayBlock.append((char)34+"");
                out.println(displayBlock);
    }
    else if(result.equals("details"))
    {
        ArrayList<String> city=(ArrayList)request.getAttribute("city");
        CandidateDetails candidate=(CandidateDetails)request.getAttribute("candidate");
        for(String s:city)
         {
            displayBlock.append((char)34+"<option value='"+s+"'>"+s+"</option>");
         }
            displayBlock.append((char)34+"");
            JSONObject json=new JSONObject();
            json.put("city", displayBlock);
            json.put("username", candidate.getCandidateName());
            json.put("userid", candidate.getUserId());
            String str=(char)34+"<img src='data:image/jpg;base64,"+candidate.getSymbol()+"' style='width:300px;height:200px;'/>"+(char)34;
            json.put("image", str);
            json.put("candidateid", candidate.getCandidateId());
            json.put("party", candidate.getParty());
            out.println(json);       
    }

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
