package com.green.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity             // 클래스를 테이블로 생성한다
@Data               // Getter+Setter+ToString+HashCode+equals
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 모든 인자 생성자
@SequenceGenerator(name="COMMENTS_SEQ_GENERATOR", sequenceName="COMMENTS_SEQ", initialValue   = 1, allocationSize = 1 )
public class Comments {
	
	@Id               // 기본키(import jakarta.persistence.Column)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="COMMENTS_SEQ_GENERATOR")
	private Long    id;            // id
	
	@ManyToOne                     // 관계 : 다대일 설정(Comments<->Article)
	@JoinColumn(name="article_id") // 외래키 이름이 아니고 외래키 칼럼임 (부모키 Article id칼럼)- 키 이름은 FKnwlc4xv9fm2swgesuas3uf3mo
	private Article article;       // 연결될 entity 객체의 이름
	
	// @Column(name="nick_name", nullable=false, length = 255)
	@Column
	private String  nickname;      // nikcname
	
	@Column
	private String  body;          // body
}
