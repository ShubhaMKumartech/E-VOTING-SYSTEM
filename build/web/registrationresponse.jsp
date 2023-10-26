<%
    boolean result=(boolean)request.getAttribute("result");
    boolean userfound=(boolean)request.getAttribute("userfound");
   if(userfound==true)
   {
       out.println("uap");
   }
   else if(result==true)
   {
       out.println("success");
   }
   else
   {
       out.println("error");
   }
%>