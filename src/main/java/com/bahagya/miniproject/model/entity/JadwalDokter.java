package com.bahagya.miniproject.model.entity;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "jadwaldokter")
public class JadwalDokter {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer id;
	 	
		@ManyToOne
	 	@JoinColumn(name = "idDokter", nullable = false,insertable=false, updatable=false)
	    private Dokter dokter;
		
		@Column(name="idDokter", nullable = false)
	    private Integer idDokter;

		@ManyToOne
	 	@JoinColumn(name = "idPraktek", nullable=false, insertable=false, updatable=false)
	    private Praktek praktek;
		
		@Column(name="idPraktek", nullable = false)
	    private Integer idPraktek;
		
//		@ManyToOne
//	 	@JoinColumn(name = "idPasien", nullable=false)
//	    private Pasien pasien;

	    @Column(name = "pasien", nullable = false)
	    private String nama_lengkap;
}
