package br.ufms.apsoo;

/**
 * Endereco é a classe base para representação de endereços.
 * 
 * @author Alex
 * @author Guilherme Carvalho
 * @author José
 * @author Larissa
 */
public class Endereco {
  private String cep;
  private String rua;
  private int numero;
  private String bairro;
  private String cidade;
  private String estado;

  public Endereco(String cep, String rua, int numero, String bairro, String cidade, String estado) {
    this.cep = cep;
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
  }

  // Getters e Setters CPF

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  // Getters e Setters Rua

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  // Getters e Setters Numero

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  // Getters e Setters Bairro

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  // Getters e Setters Cidade

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  // Getters e Setters Estado

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}
