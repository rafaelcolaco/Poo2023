package Views;

import java.util.Scanner;
import Util.Console;

import models.Funcionario;
import models.Cliente;
import models.TipoServico;
import models.Agendamento;

import Controllers.ServicoController;
import Controllers.ClienteController;
import Controllers.FuncionarioController;
import Controllers.AgendamentoController;
import java.util.Calendar;

public class Principal {
     public static void main(String[] args) {
         try (Scanner sc = new Scanner(System.in)) {
             int opcao;
             
             do{
                 System.out.println("----BARBEARIA IFC----");
                 
                 System.out.println("\n 1- Cadastrar cliente");
                 System.out.println("\n 2- Listar clientes");
                 System.out.println("\n 3- Cadastrar funcionario");
                 System.out.println("\n 4- Cadastrar Serviço");
                 System.out.println("\n 5- Agendar um serviço");
                 System.out.println("\n 6- Listar serviços agendados");
                 System.out.println("\n 7- Cadastrar Produto");
                 System.out.println("\n 8- Listar Produtos");
                 System.out.println("\n 9- Comprar produto");
                 System.out.println("\n 10- Finalizar compra");
                 System.out.println("\n 0- Sair");
                 opcao = Console.lerInteiro("\nEscolha uma opção:");
                 
                 switch (opcao) {
                    case 1 :
                        CadastrarCliente.renderizar();
                        break;
                    case 2:
                        ListarClientes.renderizar();
                        break;
                    case 3 :
                        CadastrarFuncionario.renderizar();
                        break;
                    case 4 :
                        CadastrarServico.renderizar();
                        break;
                    case 5 :
                        AgendarServico.renderizar();
                        break;
                    case 6 :
                        ListarAgendamentos.renderizar();
                        break;
                    case 7 : CadastrarProduto.renderizar();
                        break;
                    case 8 : ListarProdutos.renderizar();
                        break;
                     case 9 :
                         ComprarProduto.renderizar();
                         break;
                     case 10 :
                         FinalizarCompra.renderizar();
                         break;
                 }
                 
             }while(opcao != 0);
             sc.close();
         }
    }
}

