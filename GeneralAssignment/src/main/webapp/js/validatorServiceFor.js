$(document).ready(function () {
  var serviceID, serviceName, unit, price;
  var serviceIDErr, serviceNameErr, unitErr, priceErr;
  //Regex
  var serviceIdRegex = /^(DV)[0-9]{3}$/;

  function getData() {
    serviceID = $("#serviceID").val();
    serviceName = $("#serviceName").val();
    unit = $("#unit").val();
    price = $("#price").val();

    serviceIDErr = $("#serviceID-err");
    serviceNameErr = $("#serviceName-err");
    unitErr = $("#unit-err");
    priceErr = $("#price-err");
  }

  //Xu ly sự kiện Add

  $("#btn-addService").on("click", function (e) {
    e.preventDefault();
    //Lay du lieu tu Form
    getData();
    //Validate Empty
    var kqServiceIDEmpty = checkEmpty(
      serviceID,
      serviceIDErr,
      "You must insert data!"
    );

    var kqServiceNameEmpty = checkEmpty(
      serviceName,
      serviceNameErr,
      "You must insert data!"
    );

    var kqUnitEmpty = checkEmpty(
        unit, 
        unitErr, 
        "You must insert data!");

    var kqPriceEmpty = checkEmpty(
        price, 
        priceErr, 
        "You must insert data!");

    //Validate Format
    var kqServiceIDFormat = checkRegex(
        serviceID,
        serviceIDErr,
       "ServiceID Format DVXXX",
        serviceIdRegex
    );
    // Validate Business
    var kqPrice = checkPrice(
        price,
        priceErr,
       "Giá Tiền Phải Là Số Nguyên Dương"
    );
    
    if(kqServiceIDEmpty&&kqServiceNameEmpty&&
    kqUnitEmpty&&kqPriceEmpty&&kqServiceIDFormat&&kqPrice){
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

  function checkPrice(inputElm, errElm, msg) {
      let price =parseInt(inputElm);
      console.log(price);
    if (price<=0) {
      $(errElm).addClass("text-danger").html(msg);
      return false;
    } else {
      $(errElm).removeClass("text-danger").html("");
      return true;
    }
  }
});
