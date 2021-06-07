package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class Venda {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private LocalDate data = LocalDate.now();

  @Column(name = "valor_entrada")
  private double valorEntrada;

  @Column(name = "valor_total")
  private double valorTotal;

  @Column(name = "forma_pagamento")
  private String formaPagamento;

  @Column(name = "numero_parcelas")
  private int numParcelas;

  @ManyToOne
  private Funcionario funcionario;

  @ManyToOne
  private Cliente cliente;

  @OneToOne(cascade = CascadeType.ALL)
  private Carro carro;

  public Venda() {
  }

  public Venda(double valorEntrada, double valorTotal, String formaPagamento, int numParcelas) {
    this.valorEntrada = valorEntrada;
    this.valorTotal = valorTotal;
    this.formaPagamento = formaPagamento;
    this.numParcelas = numParcelas;
  }

  public Integer getId() {
    return this.id;
  }

  public LocalDate getData() {
    return this.data;
  }

  public double getValorEntrada() {
    return this.valorEntrada;
  }

  public void setValorEntrada(double valorEntrada) {
    this.valorEntrada = valorEntrada;
  }

  public double getValorTotal() {
    return this.valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public String getFormaPagamento() {
    return this.formaPagamento;
  }

  public void setFormaPagamento(String formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  public int getNumParcelas() {
    return this.numParcelas;
  }

  public void setNumParcelas(int numParcelas) {
    this.numParcelas = numParcelas;
  }

  public Funcionario getFuncionario() {
    return this.funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Carro getCarro() {
    return this.carro;
  }

  public void setCarro(Carro carro) {
    this.carro = carro;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Venda)) {
            return false;
        }
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id) && Objects.equals(data, venda.data) && Objects.equals(valorEntrada, venda.valorEntrada) && Objects.equals(valorTotal, venda.valorTotal) && Objects.equals(formaPagamento, venda.formaPagamento) && numParcelas == venda.numParcelas && Objects.equals(funcionario, venda.funcionario) && Objects.equals(cliente, venda.cliente) && Objects.equals(carro, venda.carro);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, data, valorEntrada, valorTotal, formaPagamento, numParcelas, funcionario, cliente, carro);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", data='" + getData() + "'" +
      ", valorEntrada='" + getValorEntrada() + "'" +
      ", valorTotal='" + getValorTotal() + "'" +
      ", formaPagamento='" + getFormaPagamento() + "'" +
      ", numParcelas='" + getNumParcelas() + "'" +
      ", funcionario='" + getFuncionario() + "'" +
      ", cliente='" + getCliente() + "'" +
      ", carro='" + getCarro() + "'" +
      "}";
  }

}
