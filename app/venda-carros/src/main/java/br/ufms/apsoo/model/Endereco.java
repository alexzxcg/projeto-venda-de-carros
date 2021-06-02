package br.ufms.apsoo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Endereco é a classe base para representação de endereços.
 * 
 * @author Alex
 * @author Guilherme Carvalho
 * @author José
 * @author Larissa
 */
@Entity
@Table(name = "enderecos")
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String cep;
  private String rua;
  private int numero;
  private String bairro;
  private String cidade;
  private String estado;
  private String complemento;

  public Endereco() {
  }

  public Endereco(String cep, String rua, int numero, String bairro, String cidade, String estado, String complemento) {
    this.cep = cep;
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.complemento = complemento;
  }

  public Long getId() {
    return this.id;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getRua() {
    return this.rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return this.estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Endereco)) {
      return false;
    }
    Endereco endereco = (Endereco) o;
    return id == endereco.id && Objects.equals(cep, endereco.cep) && Objects.equals(rua, endereco.rua)
        && numero == endereco.numero && Objects.equals(bairro, endereco.bairro)
        && Objects.equals(cidade, endereco.cidade) && Objects.equals(estado, endereco.estado)
        && Objects.equals(complemento, endereco.complemento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cep, rua, numero, bairro, cidade, estado, complemento);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", cep='" + getCep() + "'" + ", rua='" + getRua() + "'" + ", numero='"
        + getNumero() + "'" + ", bairro='" + getBairro() + "'" + ", cidade='" + getCidade() + "'" + ", estado='"
        + getEstado() + "'" + "}";
  }

}
