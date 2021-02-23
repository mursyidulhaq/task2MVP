<?php
include_once('koneksi.php');
if(!empty($_POST['email']) && !empty($_POST['passwordd']) && !empty($_POST['nama']) )
{
    $email = $_POST['email'];
    $password = md5($_POST['passwordd']);
    $nama = $_POST['nama'];


    $query = "SELECT * FROM user WHERE email= '$email' && passwordd = '$password'";
    $GET =mysqli_query($connect, $query);

    $data = array();
    if(mysqli_num_rows($GET) > 0)
    {
        set_response(true, "Email sudah terdaftar", $data);
    }else{
        $query = "INSERT INTO user(email,password,nama) VALUES ('$email','$password','$nama')";
        $insert = mysqli_query($connect, $query);
        if($insert)
        {
            set_response(true,"Register succes");
        }else{
            set_response(false,"Register false");
        }

    }
}
 else{
    set_response(false," data tidak boleh kosong");
}
function set_response($isSuccess, $message)
{
    $result = array(
        'isSuccess'=>$isSuccess,
        'message'=>$message
    );
    echo json_encode($result);
}


?>