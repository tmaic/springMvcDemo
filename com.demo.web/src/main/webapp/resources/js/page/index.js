$(function(){
    toolbar = [ 'title', 'bold', 'italic', 'underline', 'strikethrough',
        'color', '|', 'ol', 'ul', 'blockquote', 'table', '|',
        'hr', '|', 'indent', 'outdent' ];
    var editor = new Simditor( {
        textarea : $('#editor'),
        placeholder : '请输入文字...',
        toolbar : toolbar  //工具栏

    });
})