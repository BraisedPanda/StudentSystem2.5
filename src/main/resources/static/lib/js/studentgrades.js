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
        ,url: 'grades/sudent/'+stuId //数据接口
        ,title: '用户表'
        ,page: true //开启分页
        ,title:'学生信息表'
        ,toolbar: 'true' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档

        ,cols: [ [ //表头
            {type: 'checkbox', fixed: 'left'}
            // ,{field: 'stuId', title: '学号', width:'10%', sort: true}
            // ,{field: 'stuName', title: '姓名', width:'8%'}
            // ,{field: 'classId', title: '班级', width:'8%', sort: true}
            ,{field: 'testTime', title: '考试时间', width:'8%', sort: true}
            ,{field: 'testDescribe', title: '描述', width:'8%', sort: true}

            ,{field: 'total', title: '总分', width:'8%', sort: true}
            ,{field: 'average', title: '平均分', width:'8%', sort: true}
            ,{field: 'maxScore', title: '最高分', width:'8%', sort: true}
            ,{field: 'minScore', title: '最低分', width:'8%', sort: true}

            ,{field: 'chinese', title: '语文', width:'8%', sort: true}
            ,{field: 'mathematics', title: '数学', width:'8%', sort: true}

            ,{field: 'english', title: '英语', width:'8%', sort: true}
            ,{field: 'politics', title: '政治', width:'8%', sort: true}
            ,{field: 'history', title: '历史', width: '8%', sort: true}
            ,{field: 'geography', title: '地理', width:'8%', sort: true}
            ,{field: 'biology', title: '生物', width:'8%', sort: true}

            ,{field: 'chemistry', title: '化学', width:'8%', sort: true}
            ,{field: 'music', title: '音乐', width:'8%', sort: true}
            ,{field: 'arts', title: '美术', width: '8%', sort: true}
            ,{field: 'sports', title: '体育', width:'8%', sort: true}


            // ,{fixed: 'right', width: '16%', align:'center', toolbar: '#barDemo'}


        ] ]
    });



//
});