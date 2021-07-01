package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Orcamento {
  private Integer id;
  private LocalDate data = LocalDate.now();

  private double valorEntrada;

  private double valorTotal;

  private String formaPagamento;

  private int numParcelas;

  private Funcionario funcionario;

  private Cliente cliente;

  private Carro carro;

  public Orcamento() {
  }

  public Orcamento(double valorEntrada, double valorTotal, String formaPagamento, int numParcelas) {
    this.valorEntrada = valorEntrada;
    this.valorTotal = valorTotal;
    this.formaPagamento = formaPagamento;
    this.numParcelas = numParcelas;
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
        if (!(o instanceof Orcamento)) {
            return false;
        }
        Orcamento venda = (Orcamento) o;
        return Objects.equals(id, venda.id) && Objects.equals(data, venda.data) && Objects.equals(valorEntrada, venda.valorEntrada) && Objects.equals(valorTotal, venda.valorTotal) && Objects.equals(formaPagamento, venda.formaPagamento) && numParcelas == venda.numParcelas && Objects.equals(funcionario, venda.funcionario) && Objects.equals(cliente, venda.cliente) && Objects.equals(carro, venda.carro);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, data, valorEntrada, valorTotal, formaPagamento, numParcelas, funcionario, cliente, carro);
  }

  @Override
  public String toString() {
    return "{" +
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
