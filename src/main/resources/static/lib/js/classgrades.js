//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});

$(function () {

    //查看学生信息

    studentdetail = function(data){
        layui.use('layer', function(){
            var layer = layui.layer;

            layer.open({

                title: ['学生信息'],
                type: 2,
                content: 'page/student/studentdetail.html',
                shadeClose: true,
                area: ['1000px', '700px'],
                success: function (layero,index) {
                    console.log(data);
                    var body = layui.layer.getChildFrame('body', index);
                    body.find(".stuId").text(data.stuId);
                    body.find(".stuName").text(data.stuName);
                    body.find(".stuPassword").text(data.stuPassword);
                    body.find(".stuEmail").text(data.stuEmail);
                    body.find(".stuIdCard").text(data.stuIdCard);
                    body.find(".stuSex").text(data.stuSex);
                    body.find(".stuBirthday").text(data.stuBirthday);
                    body.find(".nationName").text(data.nationName);
                    body.find(".stuStatus").text(data.stuStatus);
                    body.find(".stuAge").text(data.stuAge);
                    body.find(".classId").text(data.classId);
                    body.find(".stuenRollmentTime").text(data.stuenRollmentTime);
                    body.find(".stuPolitical").text(data.stuPolitical);
                    body.find(".stuAddress").text(data.stuAddress);
                    body.find(".stuImage").text(data.stuImage);



                    layui.form.render();
                },
                cancel:function () {

                },
                end:function () {



                }
            });

        });
    }



});
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
    var laydate = layui.laydate //日期
        ,laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,table = layui.table //表格
        ,carousel = layui.carousel //轮播
        ,upload = layui.upload //上传
        ,element = layui.element //元素操作
        ,slider = layui.slider //滑块



    var stuId = $("#stuId").text();
    console.log("id："+stuId);

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 500
        ,url: 'classgrades' //数据接口
        ,title: '用户表'
        ,page: true //开启分页
        ,title:'学生信息表'
        ,toolbar: 'true' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档

        ,cols: [ [ //表头
            {type: 'checkbox', fixed: 'left'}
            // ,{field: 'stuId', title: '学号', width:'10%', sort: true}
            // ,{field: 'stuName', title: '姓名', width:'8%'}
            ,{field: 'classId', title: '班级', width:'8%', sort: true}
            ,{field: 'testTime', title: '考试时间', width:'8%', sort: true}
            ,{field: 'testDescribe', title: '描述', width:'8%', sort: true}


            ,{field: 'totalMax', title: '总分最高分', width:'9%', sort: true}
            ,{field: 'totalMin', title: '总分最低分', width:'9%', sort: true}
            ,{field: 'totalAve', title: '总分平均分', width:'9%', sort: true}


            ,{field: 'chineseMax', title: '语文最高分', width:'9%', sort: true}
            ,{field: 'chineseMin', title: '语文最低分', width:'9%', sort: true}
            ,{field: 'chineseAve', title: '语文平均分', width:'9%', sort: true}

            ,{field: 'mathematicsMin', title: '数学最高分', width:'9%', sort: true}
            ,{field: 'mathematicsMax', title: '数学最低分', width:'9%', sort: true}
            ,{field: 'mathematicsAve', title: '数学平均分', width:'9%', sort: true}

            ,{field: 'englishMax', title: '英语最高分', width:'9%', sort: true}
            ,{field: 'englishMin', title: '英语最低分', width:'9%', sort: true}
            ,{field: 'englishAve', title: '英语平均分', width:'9%', sort: true}

            ,{field: 'politicsMax', title: '政治最高分', width:'9%', sort: true}
            ,{field: 'politicsMin', title: '政治最低分', width:'9%', sort: true}
            ,{field: 'politicsAve', title: '政治平均分', width:'9%', sort: true}

            ,{field: 'historyMax', title: '历史最高分', width:'9%', sort: true}
            ,{field: 'historyMin', title: '历史最低分', width:'9%', sort: true}
            ,{field: 'historyAve', title: '历史平均分', width:'9%', sort: true}

            ,{field: 'geographyMax', title: '地理最高分', width:'9%', sort: true}
            ,{field: 'geographyMin', title: '地理最低分', width:'9%', sort: true}
            ,{field: 'geographyAve', title: '地理平均分', width:'9%', sort: true}


            ,{field: 'biologyMax', title: '生物最高分', width:'9%', sort: true}
            ,{field: 'biologyMin', title: '生物最低分', width:'9%', sort: true}
            ,{field: 'biologyAve', title: '生物平均分', width:'9%', sort: true}

            ,{field: 'chemistryMax', title: '化学最高分', width:'9%', sort: true}
            ,{field: 'chemistryMin', title: '化学最低分', width:'9%', sort: true}
            ,{field: 'chemistryAve', title: '化学平均分', width:'9%', sort: true}

            ,{field: 'physicsMax', title: '物理最高分', width:'9%', sort: true}
            ,{field: 'physicsMin', title: '物理最低分', width:'9%', sort: true}
            ,{field: 'physicsAve', title: '物理平均分', width:'9%', sort: true}

            ,{field: 'musicMax', title: '音乐最高分', width:'9%', sort: true}
            ,{field: 'musicMin', title: '音乐最低分', width:'9%', sort: true}
            ,{field: 'musicAve', title: '音乐平均分', width:'9%', sort: true}

            ,{field: 'artsMax', title: '美术最高分', width:'9%', sort: true}
            ,{field: 'artsMin', title: '美术最低分', width:'9%', sort: true}
            ,{field: 'artsAve', title: '美术平均分', width:'9%', sort: true}



            ,{field: 'sportsMax', title: '体育最高分', width:'9%', sort: true}
            ,{field: 'sportsMin', title: '体育最低分', width:'9%', sort: true}
            ,{field: 'sportsAve', title: '体育平均分', width:'9%', sort: true}

            // ,{fixed: 'right', width: '9%', align:'center', toolbar: '#barDemo'}

        ] ]
    });


    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            var classId = obj.data.classId;
            var url = 'class/detail/'+classId;
            console.log(url);

            $(window).attr("location",url);





        }
    });

//
});