package pakira.tech.bai_tap_28_10.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor // Sinh ra constructor mặc định
@AllArgsConstructor // Sinh ra constructor có tham số
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoryname", columnDefinition = "nvarchar(50)")
    private String name;

    @Column(name = "images", columnDefinition = "nvarchar(500)")
    private String images;

    @Column(name = "status")
    private int status;
}