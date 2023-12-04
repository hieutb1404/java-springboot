package com.buitrunghieu.tutorial.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer>{
	List<SinhVien> findBytenkhoaContainingIgnoreCase(String tenkhoa);
	 // findByTenkhoaAndDiemtinGreaterThanEqual (dieu kien lon hon)
	// findByTenkhoaAndDiemtinLessThanEqual(dieu kien nho )
	// camelCase tim thuoc tinh trong repository
	List<SinhVien>findByTenkhoaAndDiemtinGreaterThanEqual(String tenkhoa, float diemtin);
	
}

