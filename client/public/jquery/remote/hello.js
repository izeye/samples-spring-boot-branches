$(document).ready(function () {
    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function (data, status, request) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
        console.log(request.getAllResponseHeaders());
    });
});