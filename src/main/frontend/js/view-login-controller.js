$(document).ready(function () {
    //caching the properties


    function newPage() {
        console.log("func newpage");
        window.location.href = "file:///Users/codecadet/Desktop/frontend/userprofile.html";


    }



    // POST Operation
    $('#login').click(function () {
        //localStorage.user = user;
        //var userstring = localStorage['myKey'] = name.text;
        localStorage['myKey'] = name;


        var loginData = {
            username: $('#username').val(),
            password: $('#password').val(),
        };

        console.log(loginData)

        $.ajax('http://localhost:8080/iwanttobreakfree2/login', {
            contentType: 'application/json',
            method: 'POST',
            data: JSON.stringify(loginData),
            error: function () {
                alert('error');
            },
            success: function () {
                alert('success');
                newPage();
            }
        });

    });

});

