package org.example.ss13.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicines")   // Tên bảng theo quy định của bệnh viện: viết thường + số nhiều
@Data                    // Lombok: tự sinh getter, setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Tự động tăng (phù hợp với MySQL)
    @Column(name = "medicine_id")
    private Long medicineId;

    @Column(name = "medicine_code", length = 50, nullable = false, unique = true)
    private String medicineCode;   // Mã thuốc (ví dụ: MED001)

    @Column(name = "name", length = 255, nullable = false)
    private String name;           // Tên thuốc

    @Column(name = "unit", length = 50, nullable = false)
    private String unit;           // Đơn vị tính (Viên, Hộp, Chai, Lọ...)

    // Có thể thêm các trường khác sau này: giá bán, hạn sử dụng, số lượng tồn kho...
}