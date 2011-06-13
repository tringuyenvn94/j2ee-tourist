function print_date()
{
var mydate=new Date()   
var year=mydate.getYear()   
var day=mydate.getDay()   
var month=mydate.getMonth() 
var daym=mydate.getDate() 
var hour = mydate.getHours();
var minute = mydate.getMinutes();
var second = mydate.getSeconds();

if (hour < 10) 
	hour = "0"+hour 
if (minute < 10) 
	minute = "0"+minute
if (second < 10)
	second = "0"+second
if (year < 1000) 
	year+=1900   
if (daym<10)  

	daym="0"+daym  

var dayarray=new Array("Sunday","Monday","Tuesday","Wednesday","Tuesday","Friday","Saturday")  
var montharray=new Array("January ","February ","March ","April ","May ","June ","July ","August ","September ","October ", "November ","December ")

document.write(dayarray[day] + ", " + montharray[month] + daym +  ", " + year);
}
function print_hour()
{
var mydate=new Date()   
var year=mydate.getYear()   
var day=mydate.getDay()   
var month=mydate.getMonth() 
var daym=mydate.getDate() 
var hour = mydate.getHours();
var minute = mydate.getMinutes();
var second = mydate.getSeconds();

if (hour < 10) 
	hour = "0"+hour 
if (minute < 10) 
	minute = "0"+minute
if (second < 10)
	second = "0"+second
if (year < 1000) 
	year+=1900   
if (daym<10)  

	daym="0"+daym  

var dayarray=new Array("Sunday","Monday","Tuesday","Wednesday","Tuesday","Friday","Saturday")  
var montharray=new Array("January ","February ","March ","April ","May ","June ","July ","August ","September ","October ", "November ","December ")

document.write(hour +  " : " + minute +  " : " + second);
}