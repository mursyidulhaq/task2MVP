<?php
include_once('koneksi.php');
if(!empty($_POST['nama_penghutang']) && !empty($_POST['nohp_penghutang']) && !empty($_POST['tanggal_pinjam']) && !empty($_POST['tanggal_kembali']) )
{
    $nama_penghutang = $_POST['nama_penghutang'];
    $nohp_penghutang = md5($_POST['nohp_penghutang']);
    $tanggal_pinjam = $_POST['tanggal_pinjam'];
    $tanggal_kembali = $_POST['tanggal_kembali'];

        $query = "INSERT INTO hutang(nama_penghutang,nohp_penghutang,tanggal_pinjam,tanggal_kembali) VALUES ('$nama_penghutang','$nohp_penghutang',' $tanggal_pinjam','$tanggal_kembali')";
        $insert = mysqli_query($connect, $query);
        if($insert)
        {
            set_response(true,"Register succes");
        }else{
            set_response(false,"Register false");
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