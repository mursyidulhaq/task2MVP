<?php
include_once('koneksi.php');

if(!empty($_GET['nama_penghutang']) && !empty($_GET['nohp_penghutang'])&& !empty($_GET['tanggal_pinjam'])&& !empty($_GET['tanggal_kembali']))
{
	$nama_penghutang = $_GET['nama_penghutang'];
	$nohp_penghutang = $_GET['nohp_penghutang'];
	$tanggal_pinjam = $_GET['tanggal_pinjam'];
	$tanggal_kembali= $_GET['tanggal_kembali'];
$query = "SELECT * from hutang ";
}else{
	$query = "SELECT * from hutang";
}
$get = mysqli_query($connect, $query);
$data = array();

if(mysqli_num_rows($get) > 0) {
	while($row = mysqli_fetch_assoc($get)){
		$data[] = $row;
	}
	set_response(true,"data behasil di ambil",$data);
}else{
	set_response(false,"data gagal di ambil",$data);
}

function set_response($isSuccess, $message, $data){
	$result = array(
		'isSuccess'=>$isSuccess,
		'message'=>$message,
		'data'=>$data);

	echo json_encode($result);
}


?>