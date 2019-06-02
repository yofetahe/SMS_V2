﻿/* http://keith-wood.name/calendars.html
   Ethiopian calendar for jQuery v1.1.4.
   Written by Keith Wood (kbwood{at}iinet.com.au) February 2010.
   Dual licensed under the GPL (http://dev.jquery.com/browser/trunk/jquery/GPL-LICENSE.txt) and 
   MIT (http://dev.jquery.com/browser/trunk/jquery/MIT-LICENSE.txt) licenses. 
   Please attribute the author if you use it. */
eval(function(p,a,c,k,e,r){
    e=function(c){
        return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))
    };
        
    if(!''.replace(/^/,String)){
        while(c--)r[e(c)]=k[c]||e(c);
        k=[function(e){
            return r[e]
        }];
        e=function(){
            return'\\w+'
        };
            
        c=1
    };
    while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);
    return p
}('(9($){9 l(a){2.k=2.m[a||\'\']||2.m[\'\']}l.v=I $.g.J;$.K(l.v,{w:\'x\',q:L.5,y:[8,8,8,8,8,8,8,8,8,8,8,8,5],M:z,r:1,N:1,n:1,m:{\'\':{w:\'x\',O:[\'P\',\'Q\'],R:[\'S\',\'T\',\'U\',\'V\',\'A\',\'W\',\'X\',\'Y\',\'Z\',\'10\',\'11\',\'12\',\'14\'],15:[\'16\',\'17\',\'18\',\'19\',\'A\',\'1a\',\'1b\',\'1c\',\'1d\',\'1e\',\'B\',\'1f\',\'1g\'],1h:[\'1i\',\'1j\',\'1k\',\'1l\',\'1m\',\'C\',\'1n\'],1o:[\'1p\',\'1q\',\'1r\',\'1s\',\'B\',\'C\',\'1t\'],1u:[\'1v\',\'1w\',\'1x\',\'1y\',\'1z\',\'1A\',\'1B\'],1C:\'1D/1E/1F\',1G:0,1H:z}},D:9(a){f b=2.o(a,2.r,2.n,$.g.k.s);f a=b.p()+(b.p()<0?1:0);h a%4==3||a%4==-1},1I:9(a){2.o(a,2.r,2.n,$.g.k.s||$.g.m[\'\'].s);h 13},1J:9(a,b,c){f d=2.t(a,b,c);d.1K(-d.E(),\'d\');h i.j((d.1L()-1)/7)+1},1M:9(a,b){f c=2.o(a,b,2.n,$.g.k.1N);h 2.y[c.u()-1]+(c.u()==13&&2.D(c.p())?1:0)},1O:9(a,b,c){h(2.E(a,b,c)||7)<6},F:9(a,b,c){f d=2.o(a,b,c,$.g.k.1P);a=d.p();G(a<0){a++}h d.1Q()+(d.u()-1)*8+(a-1)*H+i.j(a/4)+2.q-1},1R:9(a){f c=i.j(a)+0.5-2.q;f b=i.j((c-i.j((c+1S)/1T))/H)+1;G(b<=0){b--}c=i.j(a)+0.5-2.t(b,1,1).F();f d=i.j(c/8)+1;f e=c-(d-1)*8+1;h 2.t(b,d,e)}});$.g.g.1U=l})(1V);',62,120,'||this||||||30|function||||||var|calendars|return|Math|floor|local|EthiopianCalendar|regional|minDay|_validate|year|jdEpoch|minMonth|invalidYear|newDate|month|prototype|name|Ethiopian|daysPerMonth|false|Tir|Ham|Arb|leapYear|dayOfWeek|toJD|if|365|new|baseCalendar|extend|1724220|hasYearZero|firstMonth|epochs|BEE|EE|monthNames|Meskerem|Tikemet|Hidar|Tahesas|Yekatit|Megabit|Miazia|Genbot|Sene|Hamle|Nehase||Pagume|monthNamesShort|Mes|Tik|Hid|Tah|Yek|Meg|Mia|Gen|Sen|Neh|Pag|dayNames|Ehud|Segno|Maksegno|Irob|Hamus|Kidame|dayNamesShort|Ehu|Seg|Mak|Iro|Kid|dayNamesMin|Eh|Se|Ma|Ir|Ha|Ar|Ki|dateFormat|dd|mm|yyyy|firstDay|isRTL|monthsInYear|weekOfYear|add|dayOfYear|daysInMonth|invalidMonth|weekDay|invalidDate|day|fromJD|366|1461|ethiopian|jQuery'.split('|'),0,{}))