$(document).ready(function () {
  var customerID, serviceId, dateOfUsage, quantity, timeOfUsage;
  var customerIDErr, serviceIdErr, dateOfUsageErr, quantityErr, timeOfUsageErr;

  // var emailRegex = /^[A-Za-z][A-Za-z0-9]{0,60}[@][A-Za-z]+([.][A-Za-z]+)+$/;
  var customerIdRegex = /^(KH)[0-9]{5}$/;
  var serviceIdRegex = /^(DV)[0-9]{3}$/;
  var positiveNumRegex = /^[1-9]+$/;

  function getData() {
    customerID = $("#customerID").val();
    serviceId = $("#serviceID").val();
    dateOfUsage = $("#date-service").val();
    quantity = $("#quantity").val();
    timeOfUsage = $("#time-services-use").val();

    customerIDErr = $("#customerID-err");
    serviceIdErr = $("#serviceID-err");
    dateOfUsageErr = $("#date-service-err");
    quantityErr = $("#quantity-err");
    timeOfUsageErr = $("#time-services-use-err");
  }

  //Xu ly sự kiện Add

  $("#btn-addRegisterService").on("click", function (e) {
    e.preventDefault();
    //Lay du lieu tu Form
    getData();
    //Validate Empty
    var kqCustomerIDEmpty = checkEmpty(
      customerID,
      customerIDErr,
      "You must insert data!"
    );
    var kqServiceIdEmpty = checkEmpty(
      serviceId,
      serviceIdErr,
      "You must insert data!"
    );
    var kqDateOfUsageEmpty = checkEmpty(
      dateOfUsage,
      dateOfUsageErr,
      "You must insert data!"
    );
    var kqQuantityEmpty = checkEmpty(
      quantity,
      quantityErr,
      "You must insert data!"
    );
    var kqTimeOfUsageEmpty = checkEmpty(
      timeOfUsage,
      timeOfUsageErr,
      "You must insert data!"
    );

    //Validate Format
    var kqCustormerIDFormat = checkRegex(
      customerID,
      customerIDErr,
      "CustomerID Format KHXXXXX",
      customerIdRegex
    );

    var kqServiceIDFormat = checkRegex(
      serviceId,
      serviceIdErr,
      "ServiceID Format DVXXX!",
      serviceIdRegex
    );

    var kqQuantityFormat = checkRegex(
      quantity,
      quantityErr,
      "So Luong: phải là số nguyên dương!",
      positiveNumRegex
    );

    if (
      kqCustomerIDEmpty &&
      kqServiceIdEmpty &&
      kqDateOfUsageEmpty &&
      kqQuantityEmpty &&
      kqCustormerIDFormat &&
      kqServiceIDFormat &&
      kqQuantityFormat&&
      kqTimeOfUsageEmpty
    ) {
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
