var ajax;

if (window.XMLHttpRequest) {
    // Mozilla, Safari, IE7+ ...
    ajax = new XMLHttpRequest();
} else if (window.ActiveXObject) {
    // IE 6 and older
    ajax = new ActiveXObject('Microsoft.XMLHTTP');
}



window.onload = function () {

    // run this when the ajax request completes
    ajax.onreadystatechange = function () {
        if (ajax.readyState === 4 && ajax.status === 200) {
            addictionData = JSON.parse(ajax.responseText);
            console.log(addictionData);
            var totalCigars = 0;
            addictionData.forEach(function (addiction) {
                //create a new table row, added to the end of the table
                totalCigars += addiction.numberOfSmokedCigarretes;
                var row = addictionTable.insertRow(-1);
                var rowData = "<td>" + addiction.date + "</td>" +
                    "<td>" + addiction.numberOfSmokedCigarretes + "</td>" +
                    "<td>" + addiction.moneySpent + "</td>";
                row.innerHTML = rowData;
            });
            var total = document.getElementById('total');
            total.innerHTML = totalCigars;
        }
    };

    // start the AJAX request
    ajax.open('GET', 'http://localhost:8080/iwanttobreakfree2/customer/1/diary', true);
    ajax.setRequestHeader('Content-type', 'application/json');
    ajax.send();

    // get the table's DOM object
    var addictionTable = document.getElementById('cigarstable');


};

$(document).ready(function () {

    console.log('here');

    $('#add').click(function () {
        //var actualUser = user.val(localStorage.user);

        var addictionData = {
            numberOfSmokedCigarrettes: $('#cigarsmoked').val(),
        };


        console.log(addictionData);

        $.ajax('http://localhost:8080/iwanttobreakfree2/customer/1/diary', {
            contentType: 'application/json',
            method: 'POST',
            async: true,
            data: JSON.stringify(addictionData),
            error: function (error) {
                console.log(error);
                alert('error');
            },
            success: function () {
                alert('success');
                window.location.href = "file:///Users/codecadet/Desktop/frontend/userprofile.html";
            }
        });

    });


});

