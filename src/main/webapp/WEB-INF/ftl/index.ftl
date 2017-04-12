<html>
<title>test</title>
<body>
<script type="text/javascript" src="/static/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/layui/layui.js"></script>
<link rel="stylesheet" href="/static/layui/css/layui.css">

<div>
    <ul>
        <#list productList as plist>
           <li>${plist.title}</li>
        </#list>
    </ul>
</div>
产品管理
<ul id="list1">
</ul>
<div id="pagediv" class="laypage_main laypageskin_default"></div>
<script>
    $(function(){
        list();
    })
    function list(curr){

        $.ajax({
            type: 'POST',
            url: "/product/list" ,
            data: {page:curr||1,rows:3},
            dataType: "json",
            success: function(resp){
                if(resp.success){
                    var htmlStr = "";
                    $.each(resp.o,function(){
                        var ut = this;
                        htmlStr += "<li>"+ut.title + " " + ut.nick + "  |<a href='javascript:modify(\""+ut.id+"\")'>修改</a>" + "</li>";
                    });
                    $('#list1').html(htmlStr);

                    layui.use('laypage',function(){
                        var laypage = layui.laypage;
                        layui.laypage({
                            cont: 'pagediv', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                            pages: resp.msg, //通过后台拿到的总页数
                            skip:true,
                            groups:5,
                            first:'首页',
                            curr: curr || 1, //当前页
                            jump: function(obj, first){ //触发分页后的回调
                                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                    list(obj.curr);
                                }

                            }
                        });
                    });
                }
            },
            error:function(resp){
                console.log(resp);
            }
        });
    }
function modify(id){
        alert(id);
}

</script>
</body>
</html>