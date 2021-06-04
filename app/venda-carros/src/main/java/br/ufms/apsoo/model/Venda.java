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
@Table(name = "vendas")
public class Venda {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private LocalDate data = LocalDate.now();

  @Column(name = "valor_entrada")
  private Double valorEntrada;

  @Column(name = "forma_pagamento")
  private String formaPagamento;

  public Venda() {
  }

  public Venda(Double valorEntrada, String formaPagamento) {
    this.valorEntrada = valorEntrada;
    this.formaPagamento = formaPagamento;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getData() {
    return this.data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Double getValorEntrada() {
    return this.valorEntrada;
  }

  public void setValorEntrada(Double valorEntrada) {
    this.valorEntrada = valorEntrada;
  }

  public String getFormaPagamento() {
    return this.formaPagamento;
  }

  public void setFormaPagamento(String formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Venda)) {
      return false;
    }
    Venda venda = (Venda) o;
    return Objects.equals(id, venda.id) && Objects.equals(data, venda.data)
        && Objects.equals(valorEntrada, venda.valorEntrada) && Objects.equals(formaPagamento, venda.formaPagamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, data, valorEntrada, formaPagamento);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", data='" + getData() + "'" + ", valorEntrada='" + getValorEntrada() + "'"
        + ", formaPagamento='" + getFormaPagamento() + "'" + "}";
  }

}
