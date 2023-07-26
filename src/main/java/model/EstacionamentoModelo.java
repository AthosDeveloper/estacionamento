package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
responsabilidade da classe:
controlar os dados inseridos na tabela
 */
public class EstacionamentoModelo {
//crio a variável connection do sql e depois estabeleço essa conexão pelo construtor.
     private Connection connection;
     private List<Carro> carrosEstacionados;
    public EstacionamentoModelo(){
        carrosEstacionados = new ArrayList<>();

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://database-1.ct2jygfmnue8.sa-east-1.rds.amazonaws.com:5432/athos_estacionamento",
    "postgres", "catalisa");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //agora vou criar um método para consultar os carros cadastrados:
    public List<Carro> getCarrosEstacionados(){
        List<Carro> carros = new ArrayList<>();
  try {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM carros_estacionados");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()){
          Carro carro = new Carro(
                  resultSet.getString("nome"),
                  resultSet.getString("placa"),
                  resultSet.getString("dono"),
                  resultSet.getInt("permanencia"),
                  resultSet.getDouble("valor_pago"));
     carros.add(carro);
      }
      resultSet.close();
      statement.close();
  } catch (SQLException e){
      e.printStackTrace();
  }
  return carros;
    }
    //aqui vou inserir os carros estacionados no banco de dados
    public void adicionarCarrosEstacionados(Carro carro){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO carros_estacionados (nome, placa, dono, permanencia, valor_pago) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, carro.getNome());
            statement.setString(2, carro.getPlaca());
            statement.setString(3, carro.getDono());
            statement.setInt(4, carro.getPermanencia());
            statement.setDouble(5, carro.getValorPago());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //agora o método para atualizar o carro....

    public void atualizarCarroEstacionado(Carro carro){
        try {
        PreparedStatement statement = connection.prepareStatement("UPDATE carros_estacionados SET permanencia = ?, valor_pago = ? WHERE placa = ?");
        statement.setInt(1, carro.getPermanencia());
        statement.setDouble(2, carro.getValorPago());
       statement.setString(3, carro.getPlaca());
       statement.executeUpdate();
   statement.close();
    } catch (SQLException e){
            e.printStackTrace();
        }


    }
    //Agora, excluir carro estacionado...
    public void excluirCarroEstacionado (String placa){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM carros_estacionados WHERE placa = ?");
            statement.setString(1, placa);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
public boolean carroJaEstacionado(String placa){
       for (Carro carro: carrosEstacionados){
           if (carro.getPlaca().equals(placa)){
               return  true;
           }
        }
       return  false;
}
    public boolean verificarAdicao(Carro carro){
        if (!carroJaEstacionado(carro.getPlaca())){
            carrosEstacionados.add(carro);
            return  true;
        }
        return  false;
    }
public boolean verificarExclusao(String placa){

        for (int i = 0; i < carrosEstacionados.size(); i ++){
            if (carrosEstacionados.get(i).getPlaca().equals(placa)){
                carrosEstacionados.remove(i);
           return  true;
            }
    }
        return  false;
}

public boolean verificarAtualizacao(Carro carro){
        for (int i = 0; i < carrosEstacionados.size(); i ++){
            if (carrosEstacionados.get(i).getPlaca().equals(carro.getPlaca())){
                atualizarCarroEstacionado(carro);
           return  true;
            }
        }
        return  false;
}

}

