package br.com.estudo.pessoa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private Integer idade;
}
