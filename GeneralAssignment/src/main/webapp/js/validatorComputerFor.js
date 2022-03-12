$(document).ready(function () {
  var position;
  var positionErr;

  // var emailRegex = /^[A-Za-z][A-Za-z0-9]{0,60}[@][A-Za-z]+([.][A-Za-z]+)+$/;
  var positionRegex = /^(MAY)[0-9]{2}$/;

  function getData() {
    position = $("#position").val();

    positionErr = $("#position-err");
  }

  //Xu ly sự kiện Add

  $("#btn-addComputer").on("click", function (e) {
    e.preventDefault();
    //Lay du lieu tu Form
    getData();
    //Validate Empty
    var kqPosition = checkEmpty(position, positionErr, "You must insert data!");

    //Validate Format
    var kqPositionFormat = checkRegex(
      position,
      positionErr,
      "position Format MAYXX",
      positionRegex
    );
    
    if(kqPosition&&kqPositionFormat){
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

  function checkRegex(inputElm, errElm, msg, regex) {
    // let regex = /^(09[018]|03[158])[0-9]{7}$/;
    if (!regex.test(inputElm)) {
      $(errElm).addClass("text-danger").html(msg);
      return false;
    } else {
      $(errElm).removeClass("text-danger").html("");
      return true;
    }
  }
});
