$(document).ready(function(){
  $(".block-cmt").hide();
  $('p').on('click','#link-cmt',function(){
    $(this).parent().parent().next().toggle();
    /*$(".block-cmt").toggle();*/
})
});
