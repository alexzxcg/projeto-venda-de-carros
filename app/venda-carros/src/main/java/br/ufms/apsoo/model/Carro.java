package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carros")
public class Carro {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer codigo;
  private String modelo;
  private int ano;
  private String marca;
  private String cor;
  private String status = "disponivel";

  @Column(name = "criado_em")
  private LocalDate criadoEm = LocalDate.now();

  @Column(name = "atualizado_em")
  private LocalDate atualizadoEm = null;
  

  public Carro() {
  }

  public Carro(String modelo, int ano, String marca, String cor) {
    this.modelo = modelo;
    this.ano = ano;
    this.marca = marca;
    this.cor = cor;
  }

  public Integer getCodigo() {
    return this.codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getModelo() {
    return this.modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getAno() {
    return this.ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String getMarca() {
    return this.marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getCor() {
    return this.cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDate getCriadoEm() {
    return this.criadoEm;
  }

  public void setCriadoEm(LocalDate criadoEm) {
    this.criadoEm = criadoEm;
  }

  public LocalDate getAtualizadoEm() {
    return this.atualizadoEm;
  }

  public void setAtualizadoEm(LocalDate atualizadoEm) {
    this.atualizadoEm = atualizadoEm;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Carro)) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(codigo, carro.codigo) && Objects.equals(modelo, carro.modelo) && ano == carro.ano && Objects.equals(marca, carro.marca) && Objects.equals(cor, carro.cor) && Objects.equals(status, carro.status) && Objects.equals(criadoEm, carro.criadoEm) && Objects.equals(atualizadoEm, carro.atualizadoEm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, modelo, ano, marca, cor, status, criadoEm, atualizadoEm);
  }

  @Override
  public String toString() {
    return "{" +
      " codigo='" + getCodigo() + "'" +
      ", modelo='" + getModelo() + "'" +
      ", ano='" + getAno() + "'" +
      ", marca='" + getMarca() + "'" +
      ", cor='" + getCor() + "'" +
      ", status='" + getStatus() + "'" +
      ", criadoEm='" + getCriadoEm() + "'" +
      ", atualizadoEm='" + getAtualizadoEm() + "'" +
      "}";
  }

}
