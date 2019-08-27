//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});

$(function () {

    //查看班级信息

    classDetail = function(data){
        layui.use('layer', function(){
            var layer = layui.layer;

            layer.open({

                title: ['班级信息'],
                type: 2,
                content: 'page/class/classDetail.html',
                shadeClose: true,
                area: ['1000px', '700px'],
                success: function (layero,index) {
                    console.log(data);
                    var body = layui.layer.getChildFrame('body', index);
                    body.find(".classId").text(data.classId);
                    body.find(".className").text(data.className);
                    body.find(".classTeacher").text(data.classTeacher);
                    body.find(".classCount").text(data.classCount);
                    body.find(".chineseTeacher").text(data.chineseTeacher);
                    body.find(".mathematicsTeacher").text(data.mathematicsTeacher);
                    body.find(".englishTeacher").text(data.englishTeacher);
                    body.find(".politicsTeacher").text(data.politicsTeacher);
                    body.find(".historyTeacher").text(data.historyTeacher);
                    body.find(".geographyTeacher").text(data.geographyTeacher);
                    body.find(".biologyTeacher").text(data.biologyTeacher);
                    body.find(".chemistryTeacher").text(data.chemistryTeacher);
                    body.find(".physicsTeacher").text(data.physicsTeacher);
                    body.find(".musicTeacher").text(data.musicTeacher);
                    body.find(".artsTeacher").text(data.artsTeacher);
                    body.find(".sportsTeacher").text(data.sportsTeacher);



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





    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 600
        ,url: 'class/all' //数据接口
        ,title: '班级表'
        ,page: true //开启分页
        ,title:'班级信息表'
        ,toolbar: 'true ' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档

        ,cols: [ [ //表头
            {type: 'checkbox', fixed: 'left'}

            ,{field: 'className', title: '班级名称', width:'8%', sort: true}

            ,{field: 'classCount', title: '学生人数', width:'8%', sort: true}
            ,{field: 'classTeacher', title: '班主任',width:'7%'}
            ,{field: 'chineseTeacher', title: '语文老师', width:'7%'}
            ,{field: 'mathematicsTeacher', title: '数学老师', width:'7%'}
            ,{field: 'englishTeacher', title: '英语老师', width:'7%'}
            ,{field: 'politicsTeacher', title: '政治老师', width:'7%'}

            ,{field: 'historyTeacher', title: '历史老师', width:'7%'}
            ,{field: 'geographyTeacher', title: '地理老师', width:'7%'}

            ,{field: 'biologyTeacher', title: '生物老师', width:'7%'}
            ,{field: 'chemistryTeacher', title: '化学老师', width:'7%'}
            ,{field: 'physicsTeacher', title: '物理老师', width: '7%'}
            ,{field: 'musicTeacher', title: '音乐老师', width: '7%'}
            ,{field: 'artsTeacher', title: '美术老师', width: '7%'}
            ,{field: 'sportsTeacher', title: '体育老师', width: '7%'}

            ,{fixed: 'right', width: '12%', align:'center', toolbar: '#barDemo'}


        ] ]
    });



    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            classDetail(data);

        } else if(layEvent === 'del'){
            layer.confirm('是否确认删除？', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                var classId = obj.data.classId;

                $.ajax({
                    type:"post",
                    url:'class/delete/'+classId

                }
                    ,layer.msg("删除成功",{icon:'1',time:2000})
                );

                // window.location.reload();

            });
        } else if(layEvent === 'edit'){
            var classId = data.classId;
            var url = 'class/toeditclass/'+classId
            $(window).attr('location',url);



        }
    });

//
});