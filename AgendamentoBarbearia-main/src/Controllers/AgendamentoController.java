
package Controllers;

import models.Agendamento;
import models.Cliente;
import models.Funcionario;
import models.TipoServico;
import java.util.Calendar;

import java.util.ArrayList;

public class AgendamentoController {
    private static ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
    
    public static ArrayList<Agendamento> listar() {
	return agendamentos; 
    }

    public static boolean agendar(String tipoServico, String cpfCliente, String cpfFuncionario, Calendar data){
      Funcionario funcionario = FuncionarioController.procurarPorCpf(cpfFuncionario);
      Cliente cliente = ClienteController.procurarPorCpf(cpfCliente);
      TipoServico servico = ServicoController.procurarPorServico((tipoServico));

      if(servico == null) {
          System.out.println("O serviço não existe, por favor cadastre um serviço válido");
          return false;
      }

      if(cliente == null) {
        System.out.println("Não existe um cliente com esse cpf, por favor forneça um CPF válido.");
        return false;
      }

      if(funcionario == null) {
        System.out.println("Não existe um funcionário com esse cpf, por favor forneça um CPF válido.");
        return false;
      }

      if(!(horarioEstaDisponivel(funcionario, data))) {
          System.out.println("Esse horário não está disponível, por favor selecione outro horário");
          return false;
      }

      Agendamento agendamento = new Agendamento(cliente, funcionario, servico, data);

      agendamentos.add(agendamento);
      CarrinhoController.adicionarAoCarrinho(servico, cliente);
      System.out.println("Agendamento cadastrado com sucesso.");
      return true;
    }

    public static boolean horarioEstaDisponivel(Funcionario funcionario, Calendar data){
        for(Agendamento agendamento : agendamentos) {
            System.out.println("Data parametro: "+  data);
            System.out.println("Data agendamento: "+ agendamento.getData());
            if((agendamento.getFuncionario().getCpf().equals(funcionario.getCpf()))) { 
                if(agendamento.getData().get(Calendar.YEAR) == data.get(Calendar.YEAR)) {  
                    if(agendamento.getData().get(Calendar.MONTH) == data.get(Calendar.MONTH)) { 
                        if(agendamento.getData().get(Calendar.DAY_OF_MONTH) == data.get(Calendar.DAY_OF_MONTH)) { 
                            if (agendamento.getData().get(Calendar.HOUR_OF_DAY) == data.get(Calendar.HOUR_OF_DAY)) { 
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
