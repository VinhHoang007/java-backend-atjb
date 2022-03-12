$(document).ready(function () {
    var customerID, computerID, dateOfUsage, beginTimeUsage, timeOfUsage;
    var customerIDErr, computerIDErr, dateOfUsageErr, beginTimeUsageErr, timeOfUsageErr;
  
    // var emailRegex = /^[A-Za-z][A-Za-z0-9]{0,60}[@][A-Za-z]+([.][A-Za-z]+)+$/;
    var customerIdRegex = /^(KH)[0-9]{5}$/;
    var computerRegex = /^[0-9]+$/;
    var timeRegex = /^[1-9]+$/;
  
    function getData() {
      customerID = $("#customerID").val();
      computerID = $("#computerID").val();
      dateOfUsage = $("#date-service-usage").val();
      beginTimeUsage = $("#begin-time-computer").val();
      timeOfUsage = $("#time-computer-use").val();
  
      customerIDErr = $("#customerID-err");
      computerIDErr = $("#computerID-err");
      dateOfUsageErr = $("#date-service-usage-err");
      beginTimeUsageErr = $("#begin-time-computer-err");
      timeOfUsageErr = $("#time-computer-use-err");
    }
  
    //Xu ly sự kiện Add
  
    $("#btn-addRegisterComputer").on("click", function (e) {
      e.preventDefault();
      //Lay du lieu tu Form
      getData();
      //Validate Empty
      var kqCustomerIDEmpty = checkEmpty(
        customerID,
        customerIDErr,
        "You must insert data!"
      );
      
      var kqComputerIDEmpty = checkEmpty(
        computerID,
        computerIDErr,
        "You must insert data!"
      );
      var kqDateOfUsageEmpty = checkEmpty(dateOfUsage, dateOfUsageErr, "You must insert data!");
      var kqBeginTimeUsageEmpty = checkEmpty(beginTimeUsage, beginTimeUsageErr, "You must insert data!");
      var kqTimeOfUsageEmpty = checkEmpty(timeOfUsage, timeOfUsageErr, "You must insert data!");
  
      //Validate Format
      var kqCustormerIDFormat = checkRegex(
        customerID,
        customerIDErr,
        "CustomerID Format KHXXXXX",
        customerIdRegex
      );

      var kqTime = checkRegex(
        timeOfUsage,
        timeOfUsageErr,
        "Thời gian sử dụng: phải là số nguyên dương!",
        timeRegex
      );
      
      if (
      kqCustomerIDEmpty &&
      kqComputerIDEmpty&&
      kqDateOfUsageEmpty &&
      kqBeginTimeUsageEmpty &&
      kqTimeOfUsageEmpty &&
      kqCustormerIDFormat &&
      kqTime
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
  