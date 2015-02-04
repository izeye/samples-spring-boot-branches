$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/greeting"
    }).then(function (data, status, request) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
        console.log(request.getAllResponseHeaders());
    });
});