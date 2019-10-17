//1. 获取路径上的请求参数
var keyWords = window.location.search;
//2. 判断是否获取到
if (keyWords == null || keyWords == "") {
    // 此时都需要跳转到index.html
    window.location.href = "/index.html";
}
//3. 将内容写入到搜索框中
$(".inputSeach").val(decodeURI(keyWords.split("=")[1]));

//3. 异步请求,获取结果
ajaxQuery(1,10);

function ajaxQuery(currentPage,pageSize) {
    //清空数据
    $(".itemList").html("");
    // 获取关键字
    var keyword = $(".inputSeach").val();

    if(keyword == ''){
        window.location.href="/index.html";
        return;
    }

    // 获取日期范围
    var dateStart = $("input[name=dateStart]").val();
    var dateEnd = $("input[name=dateEnd]").val();
    var source = $("input[name=source]").val();

    //与controller中参数一直
    var params = {"keyword": keyword, "currentPage": currentPage, "pageSize": pageSize};

    $.get("/consumer/search",params , function (data) {

        $("#totalCount").html(data.recordCount);

        //1. 将响应回来的数据写入页面即可
        //
        $(data.recordList).each(function (index,item) {

            var content = item.intro;
            if(content.length>30){
                content = content.substring(0,200) +"...";
            }
            var html = "<div class=\"item\">\n" +
                "    <div class=\"title\"><a href='" + item.url + "'>" + this.title + "</a></div>\n" +
                "    <div class=\"contentInfo_src\">\n" +
                "        <a href=\"#\"><img src=\"./img/item.jpeg\" alt=\"\" class=\"imgSrc\" width=\"121px\" height=\"75px\"></a>\n" +
                "        <div class=\"infoBox\">\n" +
                "            <p class=\"describe\">\n"+resolvingDate(item.update_time) +" - "+ content +
                "            </p>" +
                "            <p><a class=\"showurl\" href='" + item.url + "'>" + item.url +  " </a> <span class='lab'><a" +
                "                    href=\"\">"+item.source+" </a></span></p>\n" +
                "        </div>" +
                "    </div>" +
                "</div>"

            $(".itemList").append(html);


        })



        //2. 处理分页条

        var ul = "<ul>"
        //2.1 处理上一页
        if(data.endPageIndex>1 && data.currentPage >1){

            ul += " <li><a href='javascript:void(0)' onclick = 'ajaxQuery("+(data.currentPage-1) +",10)'>< 上一页</a></li>";
        }
        //2.1 处理中间页码

        //每次只遍历当前页的前2 后2
        if( data.currentPage >2){


            if(data.endPageIndex>2 && data.currentPage<data.endPageIndex-2){
                for(var i = data.currentPage-2 ; i <=data.currentPage+2; i++){
                    if(data.currentPage == i){
                        ul += "<li class='on' onclick='ajaxQuery("+i+",10)' >"+i+"</li>";
                    }else{
                        ul += "<li onclick='ajaxQuery("+i+",10)'>"+i+"</li>";
                    }
                }
            }

            if(data.currentPage+2 >= data.endPageIndex){


                for(var i =data.endPageIndex-4; i <=data.endPageIndex ; i++){

                    if(data.currentPage == i){
                        ul += "<li class='on' onclick='ajaxQuery("+i+",10)' >"+i+"</li>";
                    }else{
                        ul += "<li onclick='ajaxQuery("+i+",10)'>"+i+"</li>";
                    }
                }
            }

        }else{
                for(var i = 1 ; i <= 5; i++){
                    if(data.currentPage == i){
                        ul += "<li class='on' onclick='ajaxQuery("+i+",10)' >"+i+"</li>";
                    }else{
                        ul += "<li onclick='ajaxQuery("+i+",10)'>"+i+"</li>";
                    }
                }


        }


        //2.3 处理下一页
        if(data.endPageIndex>1 && data.currentPage<data.endPageIndex){
            ul += " <li><a href='javascript:void(0)' onclick = 'ajaxQuery("+(data.currentPage+1)+",10)'>下一页 ></a></li>";
        }

        ul += "</ul>";

        $(".pageList").html(ul)
    }, "json")
}

//格式化时间函数 2019-09-01T03:10:40.000Z 2019-09-02 10:17:50
function resolvingDate(date){
//date是传入的时间
    var d = new Date(date);
    var month = (d.getMonth() + 1) < 10 ? '0'+(d.getMonth() + 1) : (d.getMonth() + 1);
    var day = d.getDate()<10 ? '0'+d.getDate() : d.getDate();
    var hours = d.getHours()<10 ? '0'+d.getHours() : d.getHours();
    var min = d.getMinutes()<10 ? '0'+d.getMinutes() : d.getMinutes();
    var sec = d.getSeconds()<10 ? '0'+d.getSeconds() : d.getSeconds();
    var times=d.getFullYear() + '-' + month + '-' + day + ' ' + hours + ':' + min + ':' + sec;
    return times
}