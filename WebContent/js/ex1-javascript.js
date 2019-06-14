//---------------------------------ex1------------------------------------------------
//window.onload = function(){
    window.addEventListener("load",function(){
    var btnResult = document.getElementById("btn-result");
    
    btnResult.onclick = function(){
        var x_ = document.getElementById("x-input");
        var x = parseInt(x_.value);
        var y_ = document.getElementById("y-input");
        var y = parseInt(y_.value);

        alert(x+y);
    };
});
//---------------------------------------------ex2---------------------------------------------

window.addEventListener("load",function(){
    var cnt = document.getElementById("countdown-button"); 
    var countspan = document.getElementById("count-span");
    var tid;

    cnt.onclick = function(){
        
        
        if(tid == undefined)
            tid = window.setInterval(
                function(){
                    var count = parseInt(countspan.innerText);
                    console.log(count);
                    count--;
                    countspan.innerText = count;
                    if(count==0)
                        window.clearInterval(tid);}
                ,1000);

    };
});

//------------------------------------------------ex3--------------------------------
window.addEventListener("load",function(){
    var bnt = document.getElementById("btn-ex3");
    var view = document.getElementById("view");

    bnt.onclick = function(){
        var fwin = view.contentWindow;
        fwin.document.getElementById("btn-ex3").value="안녕하세요";

        //window.location.href="http://www.newlecture.com";
        console.log(window.location.protocol);
    };
});


//강사님꺼
// window.addEventListener("load",function(){
//     var bnt = document.getElementById("btn-ex3");
//     var view = document.getElementById("view");
    
//     var fwin = view.contentWindow;
//     var fex3btn;

//     view.onload = function(){
//         fex3btn = fwin.document.getElementById("btn-ex3");
//     };
//     bnt.onclick = function(){
//         ex3btn.value="안녕하세요";
//     };
// });
//-----------------------------------ex4---노드 선택 방법1------------------------------
window.addEventListener("load",function(){
    var section = document.getElementById("ex4");
    
    //방법4
    var button = document.querySelector("#ex4>input");
    var ul = section.querySelector("ul");
    var lis = ul.querySelectorAll("li");
    console.log(lis);

    //방법3
    //var button = section.firstChild; //모든 자식 노드들(공백도)
    // var button = section.firstElementChild;
    // var ul = button.nextElementSibling;
    // var lis = ul.children;
    //방법2-1 childNodes->children
    // var button = section.children[0];//엘리먼트 자식 노드들만
    // var ul = section.children[1];
    // var lis = ul.children;

    //방법2 공백도 자식으로 침.
    // var button = section.childNodes[1];//모든 자식 노드들
    // console.log(button.nodeType);
    // var ul = section.childNodes[3];
    // var lis = ul.getElementsByTagName("li");
    
    //방법1
    // var button = section.getElementsByTagName("input")[0];
    // var ul = section.getElementsByTagName("ul")[0];
    // var lis = ul.getElementsByTagName("li");
    
    button.onclick = function(){
        console.log("test");
        lis[3].remove();
        ul.appendChild(lis[3]);
    };
});

//-------------------------------ex5 속성다루기------------------------------------
// window.addEventListener("load",function(){
//     var section = document.querySelector("ex5");
//     var button1 = document.querySelector(".btn1");
//     var button2 = document.querySelector(".btn2");
//     var img = document.querySelector("img");
//     var tid;

//     button1.onclick=function(){
//         img.src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHcvp9F7Vc7Ss4xzfw81nm3trflTOMDnuapTexK7cqGtRVdstF";
//     };

//     button2.onclick=function(){
//         //var width = img.width;
//         //모든 스타일 속성은 문자열
//         //img.style.width = "200px";

//         //img.style["border.bottom"]="3px solid red";
//         img.style.borderBottom ="3px solid red";
//         var f1 = function(){
//             var width = img.width;
//             width--;
//             img.style.width = width+"px";

//             if(width==200)
//                 window.clearInterval(tid);
//         };
//         if(tid==undefined)
//             tid = window.setInterval(f1,100);
//     };
// });

//-------------------------------ex5 속성다루기 1-1------------------------------------
window.addEventListener("load",function(){
    var section = document.querySelector("#ex5");
    var sl = section.querySelector(".img-select");
    var button1 = section.querySelector(".btn1");
    var input = section.querySelector(".input");
    var img = section.querySelector("img");
    var tid;
    
    button1.onclick=function(){
        img.src = sl.options[sl.selectedIndex].value; 
        img.style.border=input.value;
        //alert(img);
    };

    // input.onclick=function(){
    //     //var width = img.width;
    //     //모든 스타일 속성은 문자열
    //     //img.style.width = "200px";

    //     //img.style["border.bottom"]="3px solid red";
    //     img.style.borderBottom ="3px solid red";
    //     var f1 = function(){
    //         var width = img.width;
    //         width--;
    //         img.style.width = width+"px";

    //         if(width==200)
    //             window.clearInterval(tid);
    //     };
    //     if(tid==undefined)
    //         tid = window.setInterval(f1,100);
    // };
});
//-------------------------------ex6 노드 조작하기------------------------------------
window.addEventListener("load",function(){
    var section = document.querySelector("#ex6");
    var btntext = section.querySelector(".btn-add-text");
    var btnelment = section.querySelector(".btn-add-elment");
    var contain = section.querySelector(".container");

    btntext.onclick=function(){
       var textNode = document.createTextNode("안녕하세요");
       contain.appendChild(textNode);
    };

    btnelment.onclick=function(){
        var el = document.createElement("div");
        el.className = "box";
        contain.appendChild(el);
    };

});
//-------------------------------ex7 공지사항 조작하기------------------------------------
window.addEventListener("load",function(){
    var section = document.querySelector("#ex7");
    var btnload = section.querySelector(".btn-load");
    var noticeTbody =  section.querySelector(".notice tbody");
    var notices = [
        {
            id:"6",
            title:"뉴렉쌤 9월 초 국기과정 모집 안내",
            writerId:"newlec",
            regDate:"2019-06-11",
            hit:30
        },
        {
            id:"5",
            title:"뉴렉처 강의 수강 방식 안내",
            writerId:"newlec",
            regDate:"2019-05-24",
            hit:120
        },
        {
            id:"4",
            title:"자바 구조적인 프로그래밍 강의 예제 파일",
            writerId:"newlec",
            regDate:"2019-04-24",
            hit:231
        },
    ];

    //var string="";
    btnload.onclick=function(){
        //데이터 요청하기
        var request = new XMLHttpRequest();
        request.open("GET","data.txt", false);
        request.send();

        alert(request.responseText);
        //방법3: 템플릿 문자열을 이용한 DOM조작
        var keys = Object.keys(notices[0]);
        var html =[];
        for(var j=0; j<notices.length; j++){
            html.push("<tr>");
            for(var i=0; i<5; i++)
                html.push("<td>"+notices[j][keys[i]]+"</td>");
            html.push("</tr>");
            }
            //noticeTbody.innerHTML = html.toString();
            noticeTbody.innerHTML = html.join("");//문자열을 더해주는것 join

            //진협방법3
            // var str="";
            // for(var i=0; i<html.length; i++)
            //     str += html[i];
            //     noticeTbody.innerHTML +=str;
        //방법2: 템플릿을 이용한 DOM조작
        // for(var i=0; i<notices.length; i++){
        //     string+="<tr><td>"+notices[i].id+"</td>"
        //             +"<td>"+notices[i].title+"</td>"
        //             +"<td>"+notices[i].writerId+"</td>"
        //             +"<td>"+notices[i].regDate+"</td>"
        //             +"<td>"+notices[i].hit+"</td></tr>";

        //         }
        //     noticeTbody.innerHTML = string;

        //강사님꺼 방법2
        // var keys = Object.keys(notices[0]);
        // for(var j=0; j<notices.length; j++){
        //     noticeTbody.innerHTML +="<tr>";
        //     for(var i=0; i<5; i++)
        //         noticeTbody.innerHTML +="<td>"+notices[j][keys[i]]+"</td>";
        //     noticeTbody.innerHTML +="</tr>";
        // }

        //진협 방법2
        // var keys = Object.keys(notices[0]);
        // for(var j=0; j<notices.length; j++){
        //     var tds="";
        //     for(var i=0; i<5; i++)
        //         tds += "<td>"+notices[j][keys[i]]+"</td>";
        //     noticeTbody.innerHTML +="<tr>"+tds+"</tr>";
        // }
        //방법1: 맨땅의 DOM조작 appendchild
    //     var keys = Object.keys(notices[0]);//["id", "title", "writerId", "regDate", "hit"];
    //    for(var j=0; j<notices.length; j++){
    //     var tr = document.createElement("tr");
    //     for(var i=0; i<5; i++){
    //         var td = document.createElement("td");
    //         var txt = document.createTextNode(notices[j][keys[i]]);
    //         td.appendChild(txt);
    //         tr.appendChild(td);
    //     }
    //     noticeTbody.appendChild(tr);}

     //       방법1: 맨땅의 DOM조작 append
    //     var keys = Object.keys(notices[0]);//["id", "title", "writerId", "regDate", "hit"];
    //    for(var j=0; j<notices.length; j++){
    //     var tr = document.createElement("tr");
    //     for(var i=0; i<5; i++){
    //         var td = document.createElement("td");
    //         var key = keys[i];
    //         //var txt = document.createTextNode(notices[j][keys[i]]);
    //         //td.appendChild(txt);
    //         td.append(notices[j][keys[i]]);
    //         tr.append(td);
    //     }
    //     noticeTbody.append(tr);}
        };
    
});
