var firstName, lastName, email, phone, password, dob, gender, account, department;
var firstNameErr ,lastNameErr ,emailErr ,phoneErr, passwordErr, dobErr, genderErr, accountErr, departmentErr; 

function getData() {
    firstName = $('#firstname').val();
    lastName = $('#lastname').val();
    email = $('#email').val();
    phone = $('#email').val();
    password = $('#password').val();
    dob = $('#dob').val();
    gender = $('#gender').val();
    account = $('#account').val();
    department = $('#deparment').val();

    firstNameErr = $('#first-name-err');
    lastNameErr = $('#last-name-err');
    emailErr = $('#email-err');
    phoneErr = $('#phone-err');
    passwordErr = $('#password-err');
    dobErr = $('#dob-err');
    genderErr = $('#gender-err');
    accountErr = $('#account-err');
    departmentErr = $('#deparment-err');

}

//Xu ly sự kiện Add
console.log(123);
$('#btn-addEmp').on('click', function (e) {
    alert(123)
    e.preventDefault();
    //Lay du lieu tu Form
    getData();
    //Validate Ho va ten
    var kq_FirstNameEmpty = checkEmpty(firstName, firstNameErr, "You must insert data!");
    var kq_LastNameEmpty = checkEmpty(lastName, lastNameErr, "You must insert data!");
    var kq_emailEmpty = checkEmpty(email, emailErr, "You must insert data!");
    var kq_phoneEmpty = checkEmpty(phone, phoneErr, "You must insert data!");
    var kq_password = checkEmpty(password, passwordErr, "You must insert data!");
    var kq_dob = checkEmpty(dob, dobErr, "You must insert data!");
    var kq_gender = checkEmpty(gender, genderErr, "You must insert data!");
    var kq_account = checkEmpty(account, accountErr, "You must insert data!");
    var kq_department = checkEmpty(deparment, departmentErr, "You must insert data!");
    
});


function checkEmpty(inputElm, errElm, msg) {
    if (inputElm == "") {
        $(errElm).addClass('text-danger').html(msg);
        return false;
    } else {
        $(errElm).removeClass('text-danger').html("");
        return true;
    }
}

function checkPassword(inputElm, errElm, msg) {
    //Ho va ten chi alphabet Khong space khong ky tu dac biet
    let regex = /^(09[018]|03[158])[0-9]{7}$/;
    if (!regex.test(inputElm)) {
        $(errElm).addClass('text-danger').html(msg);
        return false;
    } else {
        $(errElm).removeClass('text-danger').html("");
        return true;
    }
}