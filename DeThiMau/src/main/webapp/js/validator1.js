$(document).ready(function () {
  var bienSoXe;
  var bienSoXeErr;

  var bienSoRegex = /^[0-9]{2}[A-Z]{1}[0-9]{1}[-][0-9]{5}$/;

  function getData() {
    bienSoXe = $("#bienSo").val();
    bienSoXeErr = $("#bienSo-err");

  }

  //Xu ly sự kiện Add

  $("#btn-addXe").on("click", function (e) {
    e.preventDefault();
    //Lay du lieu tu Form
    getData();

    //Validate Format
    var kqBienSoXe = checkRegex(
      bienSoXe,
      bienSoXeErr,
      "Khong Duoc BO Trong",
      "BienSoXe Format xxYx-xxxxx",
      bienSoRegex
    );

    
    if(kqBienSoXe){
        $('form').submit();
    }
  });

  function checkEmpty(inputElm, errElm, msg) {
    if (inputElm == "") {
      $(errElm).addClass("text-danger").html(msg);
      return false;
    } else {
      $(errElm).removeClass("text-danger").html("");
      return true;
    }
  }

  function checkRegex(inputElm, errElm,msgEmpty, msgPattern, regex) {

    if(checkEmpty(inputElm, errElm, msgEmpty)){
      if (!regex.test(inputElm)) {
        $(errElm).addClass("text-danger").html(msgPattern);
        return false;
      } else {
        $(errElm).removeClass("text-danger").html("");
        return true;
      }
    }
  }
});