﻿/* http://keith-wood.name/calendars.html
   Ethiopian calendar for jQuery v1.1.4.
   Written by Keith Wood (kbwood{at}iinet.com.au) February 2010.
   Dual licensed under the GPL (http://dev.jquery.com/browser/trunk/jquery/GPL-LICENSE.txt) and 
   MIT (http://dev.jquery.com/browser/trunk/jquery/MIT-LICENSE.txt) licenses. 
   Please attribute the author if you use it. */
(function($){
    function EthiopianCalendar(a){
        this.local=this.regional[a||'']||this.regional['']
        }
        EthiopianCalendar.prototype=new $.calendars.baseCalendar;
    $.extend(EthiopianCalendar.prototype,{
        name:'Ethiopian',
        jdEpoch:1724220.5,
        daysPerMonth:[30,30,30,30,30,30,30,30,30,30,30,30,5],
        hasYearZero:false,
        minMonth:1,
        firstMonth:1,
        minDay:1,
        regional:{
            '':{
                name:'Ethiopian',
                epochs:['BEE','EE'],
                monthNames:['Meskerem','Tikemet','Hidar','Tahesas','Tir','Yekatit','Megabit','Miazia','Genbot','Sene','Hamle','Nehase','Pagume'],
                monthNamesShort:['Mes','Tik','Hid','Tah','Tir','Yek','Meg','Mia','Gen','Sen','Ham','Neh','Pag'],
                dayNames:['Ehud','Segno','Maksegno','Irob','Hamus','Arb','Kidame'],
                dayNamesShort:['Ehu','Seg','Mak','Iro','Ham','Arb','Kid'],
                dayNamesMin:['Eh','Se','Ma','Ir','Ha','Ar','Ki'],
                dateFormat:'DD, MM d, yyyy',
                firstDay:0,
                isRTL:false
            }
        },
    leapYear:function(a){
        var b=this._validate(a,this.minMonth,this.minDay,$.calendars.local.invalidYear);
        var a=b.year()+(b.year()<0?1:0);
        return a%4==3||a%4==-1
        },
    monthsInYear:function(a){
        this._validate(a,this.minMonth,this.minDay,$.calendars.local.invalidYear||$.calendars.regional[''].invalidYear);
        return 13
        },
    weekOfYear:function(a,b,c){
        var d=this.newDate(a,b,c);
        d.add(-d.dayOfWeek(),'d');
        return Math.floor((d.dayOfYear()-1)/7)+1
        },
    daysInMonth:function(a,b){
        var c=this._validate(a,b,this.minDay,$.calendars.local.invalidMonth);
        return this.daysPerMonth[c.month()-1]+(c.month()==13&&this.leapYear(c.year())?1:0)
        },
    weekDay:function(a,b,c){
        return(this.dayOfWeek(a,b,c)||7)<6
        },
    toJD:function(a,b,c){
        var d=this._validate(a,b,c,$.calendars.local.invalidDate);
        a=d.year();
        if(a<0){
            a++
        }
        return d.day()+(d.month()-1)*30+(a-1)*365+Math.floor(a/4)+this.jdEpoch-1
        },
    fromJD:function(a){
        var c=Math.floor(a)+0.5-this.jdEpoch;
        var b=Math.floor((c-Math.floor((c+366)/1461))/365)+1;
        if(b<=0){
            b--
        }
        c=Math.floor(a)+0.5-this.newDate(b,1,1).toJD();
        var d=Math.floor(c/30)+1;
        var e=c-(d-1)*30+1;
        return this.newDate(b,d,e)
        }
    });
$.calendars.calendars.ethiopian=EthiopianCalendar
})(jQuery);