$(document).ready(function () {
  var customerID, customerName, address, phone, email;
  var customerIDErr, customerNameErr, addressErr, phoneErr, emailErr;

  // var emailRegex = /^[A-Za-z][A-Za-z0-9]{0,60}[@][A-Za-z]+([.][A-Za-z]+)+$/;
  var customerIdRegex = /^(KH)[0-9]{5}$/;
  var emailRegex = /^[A-Za-z][A-Za-z0-9]{0,60}[@](gmail.com)$/;
  var phoneRegex = /^(((090)|(091))[0-9]{7})|((\(84\))\+9(0|1)[0-9]{7})$/;

  function getData() {
    customerID = $("#customerID").val();
    customerName = $("#customerName").val();
    email = $("#email").val();
    phone = $("#phone").val();
    address = $("#address").val();

    customerIDErr = $("#customerID-err");
    customerNameErr = $("#customerName-err");
    addressErr = $("#address-err");
    phoneErr = $("#phone-err");
    emailErr = $("#email-err");
  }

  //Xu ly sự kiện Add

  $("#btn-addCustomer").on("click", function (e) {
    e.preventDefault();
    //Lay du lieu tu Form
    getData();
    //Validate Empty
    var kqCustomerIDEmpty = checkEmpty(
      customerID,
      customerIDErr,
      "You must insert data!"
    );
    var kqCustomerNameEmpty = checkEmpty(
      customerName,
      customerNameErr,
      "You must insert data!"
    );
    var kqEmailEmpty = checkEmpty(email, emailErr, "You must insert data!");
    var kqPhoneEmpty = checkEmpty(phone, phoneErr, "You must insert data!");
    var kqAddress = checkEmpty(address, addressErr, "You must insert data!");

    //Validate Format
    var kqCustomerIDFormat = checkRegex(
      customerID,
      customerIDErr,
      "CustomerID Format KHXXXXX",
      customerIdRegex
    );
    var kqEmailFormat = checkRegex(
      email,
      emailErr,
      "Email Format Abc1@gmail.com!",
      emailRegex
    );
    var kqPhoneFormat = checkRegex(
      phone,
      phoneErr,
      "Phone dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx",
      phoneRegex
    );
    
    if(kqCustomerIDEmpty&&kqCustomerNameEmpty&&
    kqEmailEmpty&&kqPhoneEmpty&&kqAddress&&kqEmailFormat&&kqCustomerIDFormat&&kqPhoneFormat){
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
