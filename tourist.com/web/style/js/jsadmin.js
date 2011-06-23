/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function loadXMLDoc(url,cfunc){
    if (window.XMLHttpRequest){
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
    }else{
            // code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=cfunc;
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);
}

function submitform(objid)
{
    var myform=document.getElementById(objid);
    myform.submit();
}

function selectOption(obj,val){
    var objselect=document.getElementById(obj);
    var i=0;
    for(i=0;i<objselect.options.length;i++){
        if(objselect.options[i].value==val)
            objselect.options[i].selected=true;
    }
}
function selectRadio(obj,val){
    
    var objselect=document.getElementsByName(obj);
    var i=0;
    for(i=0;i<objselect.length;i++){
        if(objselect[i].value==val)
            objselect[i].checked="checked";
    }
}

function renderPaging(currpage,totalpage,numdisplay,url)
{
    var paging="",next="",pre="";

    var pos_start,pos_end;

    if(numdisplay>=totalpage)
    {
        pos_start=1;
        pos_end=totalpage;
    }
    else
    {

    	var half=parseInt(numdisplay/2);
        if(currpage<=half)
        {
            pos_start=1;
        }
        else
        {
        	if(currpage+half>totalpage){
        		pos_start=totalpage-numdisplay+1;
        	}else{
        		pos_start=currpage-half+1;
        	}

        }
        pos_end=numdisplay;
    }
    if(currpage-1>0){
        pre="<a class='pre' href='"+url+"'>Trước</a>";
    }
    if(currpage+1<=totalpage)
    {
        next="<a href='"+url+"' class='next'>Sau</a>";
    }
    for(var i=0;i<pos_end;i++)
    {
        if(i!=0)
        {
            paging+=" - ";
        }
        if(pos_start==currpage)
        {
            paging+="<strong class='current'>"+pos_start+"</strong>";
        }
        else{
            paging+="<a class='page_next' href='"+url+"' >"+pos_start+"</a>";
	}
        pos_start++;
    }

    paging=pre+paging+next;
    document.getElementById("paging").innerHTML=paging;
    
}

///////////////////
/// Article
///////////////////

function postArticle(formid){
    var title=document.getElementById("title");
    var date=document.getElementById("date");
    var category=document.getElementById("category");

    var flag=true;

    if(title.value==''){
        alert("Bạn chưa nhập tiêu đề");
        return;
    }
    if(category.value==0){
         alert("Bạn chưa chọn chủ đề");
         return;
    }
    if(date.value==''){
         alert("Bạn chưa chọn ngày đăng");
         return;
    }
    if(flag == true)
        submitform(formid);
}
function removeObject(formid,id){
    var answer = confirm('Bạn muốn xóa?');
    if(answer){
        var objid=document.getElementById("id");
        objid.value=id;
        submitform(formid);
    }
}

/////////////////////
/// Tourist
////////////////////

function postTourist(formid){
    var title=document.getElementById("title");
    var date=document.getElementById("date");
    var category=document.getElementById("category");
    var price=document.getElementById("price");
    var numday=document.getElementById("numday");
    var numnight=document.getElementById("numnight");
    var flag=true;
    
    if(title.value==''){
        alert("Bạn chưa nhập tiêu đề");
        return;
    }
    if(category.value==0 ){
        alert("Bạn chưa chọn chủ đề");
        return;
    }
    if(date.value==''){
        alert("Bạn chưa chọn ngày đăng");
        return;
    }
    if(isNaN(parseInt(price.value))){
        alert("Giá không đúng");
        return;
    }
    if(isNaN(parseInt(numday.value))){
        alert("Số ngày không đúng");
                return;
    }
    if(numnight.value=='')
        numnight.value=0;
    else{
        if(isNaN(parseInt(numnight.value))){
            alert("Số đêm không đúng");
            return;
        }
    }
    
    if(flag == true)
        submitform(formid);
}

////////////////////
/// Category
////////////////////

function postCategory(formid){
    var title=document.getElementById("title");
    var categorytype=document.getElementById("categorytype");
    var flag=true;

    if(title.value==''){
        alert("Bạn chưa nhập tiêu đề");
        return;
    }
    if(categorytype.value==0){
        alert("Bạn chưa chọn loại chủ đề");
        return;
    }
    if(flag == true)
        submitform(formid);
}

////////////////////
/// Destination
////////////////////

function postDestination(formid){
    var title=document.getElementById("title");
    var town=document.getElementById("town");
    var flag=true;

    if(title.value==''){
        alert("Bạn chưa nhập tiêu đề");
        return;
    }
    if(town.value==0){
        alert("Bạn chưa chọn tỉnh/tp");
        return;
    }
    if(flag == true)
        submitform(formid);
}

function getTown(obj){
    var nationid=document.getElementById(obj).value;
    var url="/tourist.com/ajaxadmin?action=gettowns&nationid="+nationid;
    loadXMLDoc(url,rs_getTown);
}
function rs_getTown(){        
    if (xmlhttp.readyState==4 && xmlhttp.status==200){        
        var selectbox=document.getElementById("town");
        selectbox.innerHTML=xmlhttp.responseText;
    }
}

////////////////////
/// Registration
////////////////////
function postRegister(formid){    
    submitform(formid);
}

