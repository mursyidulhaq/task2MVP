<?php 
include_once('koneksi.php');

	if (!empty($_POST['nama_penghutang']) && !empty($_POST['nohp_penghutang'])&& !empty($_POST['tanggal_pinjam'])&& !empty($_POST['tanggal_kembali'])){
	$nama_penghutang = $_GET['nama_penghutang'];
	$nohp_penghutang = $_GET['nohp_penghutang'];
	$tanggal_pinjam = $_GET['tanggal_pinjam'];
	$tanggal_kembali= $_GET['tanggal_kembali'];
		$query = "DELETE FROM hutang WHERE id_hutang = '$id_hutang'";
		$delete = mysqli_query($connect, $query);

		if($delete){
			set_response(true, "Succes delete data");
		}
		else {
			set_response(false, "Failed delete data");
		}
	}else {
		set_response(false, " ID  harus diisi");
	}
	function set_response($isSuccess, $message){
		$result = array(
			'isSuccess' => $isSuccess,
			'message' => $message
		);
		echo json_encode($result);
	 }
 ?>