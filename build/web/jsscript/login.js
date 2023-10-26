var userid,password;
function connectUser()
{
    userid=$("#username").val();
    password=$("#password").val();
    if(validate()===false)
    {
        swal("Error!", "please enter userid/password!", "error");
        return;
    }
    var data={userid:userid,password:password};
    var xhr=$.post("LoginControllerServlet",data ,processResponse);
    xhr.fail(handleError);
}
function processResponse(responseText)
{
//    responseText=responseText.trim();
    if(responseText.trim()==='error')
    {
        swal("Error!", "please enter valid userid/password!", "error");
    }
    else if(responseText.trim().indexOf("jsessionid")!==-1)
    {
        swal("success!", "Login Accepted!", "success").then((value)=>{
               window:location=responseText.trim()
        });
    }
    else 
    {
        swal("Error!", "An error occured during your request!"+responseText, "error");
    }
}

function handleError(xhr)
{
    swal("Error","Problem in server communication:"+xhr.statusText,"Error");
}
function validate()
{
    if(userid===""||password==="")
        return false;
    return true;
}

