<?php 
include_once('koneksi.php');

	if (!empty($_POST['id_hutang'])){
		$id_hutang=$_POST['id_hutang'];
		
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