package br.ufms.apsoo;

import java.util.Date;

public class Cliente extends Pessoa {
  private int codigo;
  private float renda;

  public Cliente(String cpf, String rg, String nome, Date dataNascimento, Endereco endereco, String telResidencial,
      String telCelular, String email, int codigo, float renda) {
    super(cpf, rg, nome, dataNascimento, endereco, telResidencial, telCelular, email);

    this.codigo = codigo;
    this.renda = renda;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return codigo == cliente.codigo && renda == cliente.renda;
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, renda);
  }

  @Override
  public String toString() {
    return "{" +
      " codigo='" + getCodigo() + "'" +
      ", renda='" + getRenda() + "'" +
      "}";
  }


  public int getCodigo() {
    return this.codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public float getRenda() {
    return this.renda;
  }

  public void setRenda(float renda) {
    this.renda = renda;
  }


}
