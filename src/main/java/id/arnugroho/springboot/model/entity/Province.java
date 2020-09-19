package id.arnugroho.springboot.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_province")
public class Province {
    @Id
    @Column(name = "kdprov", length = 25)
    private String kodeProvince;

    @Column(name = "nmprov")
    private String namaProvince;

//    @OneToMany(mappedBy = "province")
//    private List<Kota> kotaList;
//
//    public List<Kota> getKotaList() {
//        return kotaList;
//    }
//
//    public void setKotaList(List<Kota> kotaList) {
//        this.kotaList = kotaList;
//    }

    public String getKodeProvince() {
        return kodeProvince;
    }

    public void setKodeProvince(String kodeProvince) {
        this.kodeProvince = kodeProvince;
    }

    public String getNamaProvince() {
        return namaProvince;
    }

    public void setNamaProvince(String namaProvince) {
        this.namaProvince = namaProvince;
    }
}
