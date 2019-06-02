﻿/* http://keith-wood.name/calendars.html
   Julian calendar for jQuery v1.1.4.
   Written by Keith Wood (kbwood{at}iinet.com.au) August 2009.
   Dual licensed under the GPL (http://dev.jquery.com/browser/trunk/jquery/GPL-LICENSE.txt) and 
   MIT (http://dev.jquery.com/browser/trunk/jquery/MIT-LICENSE.txt) licenses. 
   Please attribute the author if you use it. */
(function($){function JulianCalendar(a){this.local=this.regional[a||'']||this.regional['']}JulianCalendar.prototype=new $.calendars.baseCalendar;$.extend(JulianCalendar.prototype,{name:'Julian',jdEpoch:1721423.5,daysPerMonth:[31,28,31,30,31,30,31,31,30,31,30,31],hasYearZero:false,minMonth:1,firstMonth:1,minDay:1,regional:{'':{name:'Julian',epochs:['BC','AD'],monthNames:['January','February','March','April','May','June','July','August','September','October','November','December'],monthNamesShort:['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],dayNames:['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'],dayNamesShort:['Sun','Mon','Tue','Wed','Thu','Fri','Sat'],dayNamesMin:['Su','Mo','Tu','We','Th','Fr','Sa'],dateFormat:'mm/dd/yyyy',firstDay:0,isRTL:false}},leapYear:function(a){var b=this._validate(a,this.minMonth,this.minDay,$.calendars.local.invalidYear);var a=(b.year()<0?b.year()+1:b.year());return(a%4)==0},weekOfYear:function(a,b,c){var d=this.newDate(a,b,c);d.add(4-(d.dayOfWeek()||7),'d');return Math.floor((d.dayOfYear()-1)/7)+1},daysInMonth:function(a,b){var c=this._validate(a,b,this.minDay,$.calendars.local.invalidMonth);return this.daysPerMonth[c.month()-1]+(c.month()==2&&this.leapYear(c.year())?1:0)},weekDay:function(a,b,c){return(this.dayOfWeek(a,b,c)||7)<6},toJD:function(a,b,c){var d=this._validate(a,b,c,$.calendars.local.invalidDate);a=d.year();b=d.month();c=d.day();if(a<0){a++}if(b<=2){a--;b+=12}return Math.floor(365.25*(a+4716))+Math.floor(30.6001*(b+1))+c-1524.5},fromJD:function(f){var a=Math.floor(f+0.5);var b=a+1524;var c=Math.floor((b-122.1)/365.25);var d=Math.floor(365.25*c);var e=Math.floor((b-d)/30.6001);var g=e-Math.floor(e<14?1:13);var h=c-Math.floor(g>2?4716:4715);var i=b-d-Math.floor(30.6001*e);if(h<=0){h--}return this.newDate(h,g,i)}});$.calendars.calendars.julian=JulianCalendar})(jQuery);