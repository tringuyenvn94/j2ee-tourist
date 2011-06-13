/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

function renderPaging(currpage,pagesize,totalrecord,numdisplay,url)
{
    if(totalrecord==0)
        return;
    var totalpage=parseInt(totalrecord/pagesize);
    if(totalrecord%pagesize>0)
        totalpage+=1
    if(currpage>totalpage)
        currpage=totalpage;
    document.getElementById('totalpage').innerHTML="Tổng cộng " +totalpage+" trang";

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
            pos_start=currpage-half+1;
        }
        pos_end=numdisplay;
    }
    if(currpage-1>0)
    {
        pre="<a href='"+url+"&page="+(currpage-1)+"' class='next'>Trước</a>";
    }
    if(currpage+1<=totalpage)
    {
        next="<a href='"+url+"&page="+(currpage+1)+"' class='next'>Sau</a>";
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
        else
        {
            paging+="<a href='"+url+"&page="+pos_start+"'>"+pos_start+"</a>";
        }
        pos_start++;
    }

    paging=pre+paging+next;
    document.getElementById('paging').innerHTML=paging;
}
