<?php 
	include_once 'koneksi.php' ;

	if (!empty(!empty($_POST['id_hutang']) && $_POST['nama_penghutang']) && !empty($_POST['nohp_penghutang']) && !empty($_POST['tanggal_pinjam']) && !empty($_POST['tanggal_kembali'])) {
       $id_hutang=$_POST['id_hutang'];
        $nama_penghutang = $_POST['nama_penghutang'];
        $nohp_penghutang = $_POST['nohp_penghutang'];
        $tanggal_pinjam = $_POST['tanggal_pinjam'];
        $tanggal_kembali = $_POST['tanggal_kembali'];
		
	

		$query = "UPDATE hutang set  nama_penghutang = '$nama_penghutang', nohp_penghutang = '$nohp_penghutang', tanggal_pinjam = '$tanggal_pinjam'WHERE id_hutang = '$id_hutang' ";

		$update = mysqli_query($connect, $query);

		if($update){
			set_response(true, "Success update data");
		}else{
			set_response(false,"Failed update data");
		}
	
	} else{
		set_response(false, "id mahasiswa harus diisi ");
	}

	function set_response($isSuccess, $message){

		$result = array(
			'isSuccess' => $isSuccess,
			'message' => $message
		);

		echo json_encode($result);
	}

