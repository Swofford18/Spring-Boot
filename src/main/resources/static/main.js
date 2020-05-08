

$('document').ready(function () {

    $('.edit-but').on('click',function(event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(user, status){
            $('#idEdit').val(user.id);
            $('#usernameEdit').val(user.username);
            $('#passwordEdit').val(user.password);
            $('#emailEdit').val(user.email);
        });

        $('#editModal').modal();

    });

    $('.delete-but').on('click',function(event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(user, status){
            $('#idDel').val(user.id);
            $('#usernameDel').val(user.username);
            $('#passwordDel').val(user.password);
            $('#emailDel').val(user.email);
        });

        $('#deleteModal').modal();

    });

});