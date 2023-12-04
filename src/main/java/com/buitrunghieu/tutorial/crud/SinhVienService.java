package com.buitrunghieu.tutorial.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinhVienService {
	@Autowired
    private SinhVienRepository repo;
public List<SinhVien> listAll() {
        return repo.findAll();
    }
    
    public void save(SinhVien std) {
        repo.save(std);
    }
    
    public SinhVien get(int id) {
        return repo.findById(id).get();
    }
    // search condition ten and tuoi
    public List<SinhVien> searchByNameAndAgeWithOperator(String tenkhoa, String operator, float diemtin) {
        if (">=".equals(operator)) {
        	return repo.findByTenkhoaAndDiemtinGreaterThanEqual(tenkhoa,diemtin);
        }
        // Xử lý khi toán tử không hợp lệ
        return null; // Hoặc thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn
    }

    
    //search
    public List<SinhVien> searchByTenSinhVien(String tenSinhVien) {
        return repo.findBytenkhoaContainingIgnoreCase(tenSinhVien);
    }
    
    public void delete(int id) {
        repo.deleteById(id);
    }

}
