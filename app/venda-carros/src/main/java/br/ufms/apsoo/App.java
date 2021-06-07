package br.ufms.apsoo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.ufms.apsoo.controllers.CarroController;
import br.ufms.apsoo.controllers.ClienteController;
import br.ufms.apsoo.controllers.FuncionarioController;
import br.ufms.apsoo.controllers.GerenteController;
import br.ufms.apsoo.screens.Telas.Tela;
import br.ufms.apsoo.util.ReadDump;

public class App {
  public static void main(String[] args) {

    // Read JSON
    ReadDump readDumpJSON = new ReadDump();
    JSONParser parserJSON = new JSONParser();
    Path pathFile;
    JSONArray arrayJSON;

    String mainPath = "/workspace/app/venda-carros/src/main/resources/data/";
    String gerentesJSON = mainPath + "gerentes.json";
    String funcionariosJSON = mainPath + "funcionarios.json";
    String carrosJSON = mainPath + "carros.json";
    String clientesJSON = mainPath + "clientes.json";

    // Controllers
    GerenteController gerenteController = new GerenteController();
    FuncionarioController funcionarioContoller = new FuncionarioController();
    CarroController carroController = new CarroController();
    ClienteController clienteController = new ClienteController();

    // Gerente
    String[] cpfGerentes = { "44497902358", "28936864351", "48710146903" };

    // Instancia Gerente
    pathFile = Paths.get(gerentesJSON);
    arrayJSON = readDumpJSON.getJsonArray(pathFile, "gerentes");
    for (Object a : arrayJSON) {
      try {
        JSONObject jsonObject = (JSONObject) parserJSON.parse(a.toString());

        // Gerente
        String cpf = (String) jsonObject.get("cpf");
        String rg = (String) jsonObject.get("rg");
        String nome = (String) jsonObject.get("nome");
        String email = (String) jsonObject.get("email");
        LocalDate dataNascimento = LocalDate.parse((String) jsonObject.get("data_nasc"));
        String telResidencial = (String) jsonObject.get("telefone_fixo");
        String telCelular = (String) jsonObject.get("celular");
        double salario = (double) jsonObject.get("salario");

        // Endereco
        String cep = (String) jsonObject.get("cep");
        String rua = (String) jsonObject.get("endereco");
        String bairro = (String) jsonObject.get("bairro");
        String cidade = (String) jsonObject.get("cidade");
        String estado = (String) jsonObject.get("estado");
        String complemento = (String) jsonObject.get("complemento");
        Long tmp = (Long) jsonObject.get("numero");
        int numero = tmp.intValue();

        gerenteController.cadastrarGerente(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, salario,
            cep, rua, numero, bairro, cidade, estado, complemento);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    // Clean variables
    pathFile = null;
    arrayJSON = null;

    // Instancia Funcionario
    pathFile = Paths.get(funcionariosJSON);
    arrayJSON = readDumpJSON.getJsonArray(pathFile, "funcionarios");
    for (Object a : arrayJSON) {
      try {
        JSONObject jsonObject = (JSONObject) parserJSON.parse(a.toString());

        // Funcionario
        String cpf = (String) jsonObject.get("cpf");
        String rg = (String) jsonObject.get("rg");
        String nome = (String) jsonObject.get("nome");
        String email = (String) jsonObject.get("email");
        LocalDate dataNascimento = LocalDate.parse((String) jsonObject.get("data_nasc"));
        String telResidencial = (String) jsonObject.get("telefone_fixo");
        String telCelular = (String) jsonObject.get("celular");
        String cargo = (String) jsonObject.get("cargo");
        double salario = (double) jsonObject.get("salario");
        String carteiraTrabalho = (String) jsonObject.get("carteiraTrabalho");

        // Endereco
        String cep = (String) jsonObject.get("cep");
        String rua = (String) jsonObject.get("endereco");
        String bairro = (String) jsonObject.get("bairro");
        String cidade = (String) jsonObject.get("cidade");
        String estado = (String) jsonObject.get("estado");
        String complemento = (String) jsonObject.get("complemento");
        Long tmp = (Long) jsonObject.get("numero");
        int numero = tmp.intValue();

        String cpfGerente = cpfGerentes[(int) (Math.random() * 3)];

        funcionarioContoller.cadastrarFuncionario(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular,
            cargo, salario, carteiraTrabalho, cpfGerente, cep, rua, numero, bairro, cidade, estado, complemento);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    // Clean variables
    pathFile = null;
    arrayJSON = null;

    // Instancia Carro
    pathFile = Paths.get(carrosJSON);
    arrayJSON = readDumpJSON.getJsonArray(pathFile, "carros");
    for (Object a : arrayJSON) {
      try {
        JSONObject jsonObject = (JSONObject) parserJSON.parse(a.toString());

        // Carro
        String marca = (String) jsonObject.get("Marca");
        String modelo = (String) jsonObject.get("Modelo");
        String cor = (String) jsonObject.get("Cor");
        double valor = (double) jsonObject.get("Valor");

        Long tmp = (Long) jsonObject.get("Ano");
        int ano = tmp.intValue();

        carroController.cadastrarCarro(modelo, ano, marca, cor, valor);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    // Clean variables
    pathFile = null;
    arrayJSON = null;

    // Instancia Cliente
    pathFile = Paths.get(clientesJSON);
    arrayJSON = readDumpJSON.getJsonArray(pathFile, "clientes");
    for (Object a : arrayJSON) {
      try {
        JSONObject jsonObject = (JSONObject) parserJSON.parse(a.toString());

        // Cliente
        String cpf = (String) jsonObject.get("cpf");
        String rg = (String) jsonObject.get("rg");
        String nome = (String) jsonObject.get("nome");
        String email = (String) jsonObject.get("email");
        LocalDate dataNascimento = LocalDate.parse((String) jsonObject.get("data_nasc"));
        String telResidencial = (String) jsonObject.get("telefone_fixo");
        String telCelular = (String) jsonObject.get("celular");
        double renda = (double) jsonObject.get("renda");

        // Endereco
        String cep = (String) jsonObject.get("cep");
        String rua = (String) jsonObject.get("endereco");
        String bairro = (String) jsonObject.get("bairro");
        String cidade = (String) jsonObject.get("cidade");
        String estado = (String) jsonObject.get("estado");
        String complemento = (String) jsonObject.get("complemento");
        Long tmp = (Long) jsonObject.get("numero");
        int numero = tmp.intValue();

        clienteController.cadastrarCliente(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, renda, cep,
            rua, numero, bairro, cidade, estado, complemento);

      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    // Clean variables
    pathFile = null;
    arrayJSON = null;

    Tela tela = new Tela();
    tela.setVisible(true);

  }
}