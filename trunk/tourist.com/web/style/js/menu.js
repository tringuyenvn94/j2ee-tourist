var mastertabvar=new Object()
mastertabvar.baseopacity=0
mastertabvar.browserdetect=""

function showsubmenu(masterid, id){
	if (typeof highlighting!="undefined")
		clearInterval(highlighting)
	submenuobject=document.getElementById(id)
	mastertabvar.browserdetect=submenuobject.filters? "ie" : typeof submenuobject.style.MozOpacity=="string"? "mozilla" : ""
	//hidesubmenus(mastertabvar[masterid])
	//document.write(mastertabvar[masterid]);
	//alert(mastertabvar[masterid]);
	parent=document.getElementById("menu_"+id);
	var currleft=parent.offsetLeft;
	var currtop=parent.offsetTop;
	submenuobject.style.display="block"
	submenuobject.style.left=currleft+"px";
	submenuobject.style.top=currtop+"px";
	instantset(mastertabvar.baseopacity)
	highlighting=setInterval("gradualfade(submenuobject)",50)
}

function showsubmenu1(id){
	if (typeof highlighting!="undefined")
		clearInterval(highlighting)
	submenuobject=document.getElementById(id)
	mastertabvar.browserdetect=submenuobject.filters? "ie" : typeof submenuobject.style.MozOpacity=="string"? "mozilla" : ""
	//hidesubmenus(mastertabvar[masterid])
	//document.write(mastertabvar[masterid]);
	//alert(mastertabvar[masterid]);
	parent=document.getElementById("menu_"+id);
	var currleft=parent.offsetLeft;
	var currtop=parent.offsetTop;
	submenuobject.style.display="block"
	submenuobject.style.left=currleft+"px";
	submenuobject.style.top=currtop+"px";
	instantset(mastertabvar.baseopacity)
	highlighting=setInterval("gradualfade(submenuobject)",50)

}

function subMenu(show,id) {
//alert(id);
    
    if (show){
        submenuobject=document.getElementById(id);
        
        parent=document.getElementById("menu_"+id);
	    var currleft=parent.offsetLeft+200;
	    var currtop=parent.offsetTop;	    
	    
	    submenuobject.style.display="block";	    
	    submenuobject.style.left=currleft+"px";
	    submenuobject.style.top=currtop+"px";
    } else {
        
        document.getElementById(id).style.display = 'none';
    }
}

function distancetag()
{
	
}

function hidesubmenus(submenuarray){
    //alert("asdfsd");
	for (var i=0; i<submenuarray.length; i++)
		document.getElementById(submenuarray[i]).style.display="none"
}

function instantset(degree){
	if (mastertabvar.browserdetect=="mozilla")
		submenuobject.style.MozOpacity=degree/100
	else if (mastertabvar.browserdetect=="ie")
		submenuobject.filters.alpha.opacity=degree
}


function gradualfade(cur2){
	if (mastertabvar.browserdetect=="mozilla" && cur2.style.MozOpacity<1)
		cur2.style.MozOpacity=Math.min(parseFloat(cur2.style.MozOpacity)+0.1, 0.99)
	else if (mastertabvar.browserdetect=="ie" && cur2.filters.alpha.opacity<100)
		cur2.filters.alpha.opacity+=10
	else if (typeof highlighting!="undefined") //fading animation over
		clearInterval(highlighting)
}

function initalizetab(tabid){
	mastertabvar[tabid]=new Array()
	var menuitems=document.getElementById(tabid).getElementsByTagName("li")
	for (var i=0; i<menuitems.length; i++){
		if (menuitems[i].getAttribute("rel")){
			menuitems[i].setAttribute("rev", tabid) //associate this submenu with main tab
			mastertabvar[tabid][mastertabvar[tabid].length]=menuitems[i].getAttribute("rel") //store ids of submenus of tab menu
			
			menuitems[i].onmouseover=function(){
				subMenu(true,this.getAttribute("rel"))
			}
			menuitems[i].onmouseout=function(){
				subMenu(false,this.getAttribute("rel"))
			}
			document.getElementById(menuitems[i].getAttribute("rel")).onmouseover=function(){
				subMenu(true,this.parentNode.getAttribute("rel"))
			}
			document.getElementById(menuitems[i].getAttribute("rel")).onmouseout=function(){
				subMenu(false,this.parentNode.getAttribute("rel"))
			}
		}
	}
}