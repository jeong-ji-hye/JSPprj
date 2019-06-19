window.addEventListener("load",function(){
    var notice = document.querySelector("#notice");
    var pager = document.querySelector("#pager");
    var tbody = notice.querySelector("tbody");
    var ul = pager.querySelector("ul");

    //a 엘리먼트 객체배열
    var nums =pager.querySelectorAll("ul a");

    nums[2].onclick = function(e){
        e.target.style.background = "blue";
       // e.preventDefault(); //태그가 가지고있는 기본 행위를 막는거
       // e.stopPropagation(); //전파를 막아라.
    };

    //for(var i=0; i<nums.length; i++){
        //nums[i].onclick = function(e){
        //ul.onclick = function(e){
        ul.addEventListener("click", function(e){//실행순서 바꾸기
            //alert(e.target.nodeName);//엘리먼트 포함한 모든 이름 
            //alert(e.target.tagName);//엘리먼트 이름
            if(e.target.tagName !="A")
                return;
            
            e.preventDefault();
            e.target.style.background = "pink";
            var page = e.target.innerText;

                //데이터 요청하기
        var request = new XMLHttpRequest();
        request.open("GET","/notice/list1-ajax?p="+page,false);
        request.send();

        var notices = JSON.parse(request.responseText);
        //복제방법2: 템플릿을 이용한 복제
        var template = notice.querySelector(".notice-template");

        //복제방법1: 기존 노드를 복제하기
        //var tr = tbody.children()[0];//첫번째 tr
        //var tr = tbody.firstElementChild;
        //var tr = tbody.querySelector("tr:first-child");
        tbody.innerHTML ="";
        
        for(var i=0; i<notices.length; i++)
        {
            //var cloneTr = tr.cloneNode(true);방법1의 클론
            var cloneTr = document.importNode(template.content,true);//template.content-> 템플릿안에 tr, true-> 모든내용 다가져옴 false하면 tr하나만 가져옴.

            var idEl = cloneTr.querySelector(".num");
            var titleEl = cloneTr.querySelector(".title a");
            var writerEl = cloneTr.querySelector(".writer");
            var dateEl = cloneTr.querySelector(".date");
            var hitEl = cloneTr.querySelector(".hit");

            idEl.innerText = notices[i].id;
            titleEl.innerText = notices[i].title;
            writerEl.innerText = notices[i].writerId;
            dateEl.innerText = notices[i].regDate;
            hitEl.innerText = notices[i].hit;


            tbody.append(cloneTr);
    }
        },true);//false->b>p true->p>b
//    }
});


window.addEventListener("load", function(){
    var notice = document.querySelector("#notice");
    var testRemove = document.querySelector("#test-remove");
    var txt1 = testRemove.querySelector("input[type=text]");
    var btn1 = testRemove.querySelector("input[type=button]");
    var tbody = notice.querySelector("tbody");

    btn1.onclick=function(e){
        alert(e.clientX);
        

        var id = txt1.value;

        var request = new XMLHttpRequest();
        request.open("GET","/notice/del-ajax?id="+id,false);
        request.send();

        if(request.responseText == "ok"){
            var request = new XMLHttpRequest();
            request.open("GET","/notice/list1-ajax?p=1",false);
            request.send();
        
            var notices = JSON.parse(request.responseText);
            var template = notice.querySelector(".notice-template");
            tbody.innerHTML ="";
            
            for(var i=0; i<notices.length; i++)
            {
                var cloneTr = document.importNode(template.content,true);
        
                var idEl = cloneTr.querySelector(".num");
                var titleEl = cloneTr.querySelector(".title a");
                var writerEl = cloneTr.querySelector(".writer");
                var dateEl = cloneTr.querySelector(".date");
                var hitEl = cloneTr.querySelector(".hit");
        
                idEl.innerText = notices[i].id;
                titleEl.innerText = notices[i].title;
                writerEl.innerText = notices[i].writerId;
                dateEl.innerText = notices[i].regDate;
                hitEl.innerText = notices[i].hit;
        
        
                tbody.append(cloneTr);
            }
            //화면에서도 해당 게시글을 지운다.
            alert("삭제 되었습니다.");
        }
    };
});




window.addEventListener("load",function(){
// var tb = document.querySelector("#notice tbody");
// var txt = document.querySelector("#test-paper .txt");
// var btn = document.querySelector("#test-paper .btn");

var notice = document.querySelector("#notice");
var testPaper = document.querySelector("#test-paper");
var txt1 = testPaper.querySelector("input[type=text]");
var btn1 = testPaper.querySelector("input[type=button]");
var tbody = notice.querySelector("tbody");

btn1.onclick = function(){
    var page = 1;
    if(txt1.value != null && txt1.value !="")
        page= txt1.value;

    //데이터 요청하기
    var request = new XMLHttpRequest();
    request.open("GET","/notice/list1-ajax?p="+page,false);
    request.send();

    var notices = JSON.parse(request.responseText);
    //복제방법2: 템플릿을 이용한 복제
    var template = notice.querySelector(".notice-template");

    //복제방법1: 기존 노드를 복제하기
    //var tr = tbody.children()[0];//첫번째 tr
    //var tr = tbody.firstElementChild;
    //var tr = tbody.querySelector("tr:first-child");
    tbody.innerHTML ="";
    
    for(var i=0; i<notices.length; i++)
    {
        //var cloneTr = tr.cloneNode(true);방법1의 클론
        var cloneTr = document.importNode(template.content,true);//template.content-> 템플릿안에 tr, true-> 모든내용 다가져옴 false하면 tr하나만 가져옴.

        var idEl = cloneTr.querySelector(".num");
        var titleEl = cloneTr.querySelector(".title a");
        var writerEl = cloneTr.querySelector(".writer");
        var dateEl = cloneTr.querySelector(".date");
        var hitEl = cloneTr.querySelector(".hit");

        idEl.innerText = notices[i].id;
        titleEl.innerText = notices[i].title;
        writerEl.innerText = notices[i].writerId;
        dateEl.innerText = notices[i].regDate;
        hitEl.innerText = notices[i].hit;


        tbody.append(cloneTr);
    }
}
});