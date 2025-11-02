import java.util.Scanner;

public class CalculadoraCompleta {

    public static double somar(double a, double b) {
        return a + b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Erro: Divisão por zero não é permitida.");
            return Double.NaN; 
        }
        return a / b;
    }


    public static double calcularRaizQuadrada(double base) {
        return Math.sqrt(base);
    }

    public static double calcularRaizCubica(double base) {
        return Math.cbrt(base);
    }

    public static double calcularRaizEnesima(double base, int indice) {
        return Math.pow(base, 1.0 / indice);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true; 

        while (loop) {
            System.out.println("\n--- Calculadora Java ---");
            System.out.println("Escolha a operação:");
            System.out.println("1. Somar");
            System.out.println("2. Subtrair");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Raiz Quadrada");
            System.out.println("6. Raiz Cúbica");
            System.out.println("7. Raiz N-ésima (Ex: Quarta, Quinta...)");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int escolha = scanner.nextInt();
            double resultado;
            double num1, num2;
            int indice;

            switch (escolha) {
                case 1: 
                    System.out.print("Digite o primeiro número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
                    
                    resultado = somar(num1, num2); 
                    System.out.println("Resultado: " + num1 + " + " + num2 + " = " + resultado);
                    break;

                case 2:
                    System.out.print("Digite o primeiro número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
            
                    resultado = subtrair(num1, num2); 
                    System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resultado);
                    break;

                case 3: 
                    System.out.print("Digite o primeiro número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
                   
                    resultado = multiplicar(num1, num2);
                    System.out.println("Resultado: " + num1 + " * " + num2 + " = " + resultado);
                    break;

                case 4:
                    System.out.print("Digite o dividendo: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o divisor: ");
                    num2 = scanner.nextDouble();
                    
                    resultado = dividir(num1, num2);
                    if (!Double.isNaN(resultado)) { 
                         System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
                    }
                    break;

                case 5: 
                    System.out.print("Digite o número (base): ");
                    num1 = scanner.nextDouble();

                    resultado = calcularRaizQuadrada(num1);
                    System.out.println("Resultado: Raiz Quadrada de " + num1 + " = " + resultado);
                    break;

                case 6: 
                    System.out.print("Digite o número (base): ");
                    num1 = scanner.nextDouble();

                    resultado = calcularRaizCubica(num1);
                    System.out.println("Resultado: Raiz Cúbica de " + num1 + " = " + resultado);
                    break;
                
                case 7: 
                    System.out.print("Digite o número (base): ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o índice da raiz (ex: 4 para raiz quarta): ");
                    indice = scanner.nextInt();
                    
                    resultado = calcularRaizEnesima(num1, indice);
                    System.out.println("Resultado: Raiz " + indice + "-ésima de " + num1 + " = " + resultado);
                    break;

                case 0:
                    System.out.println("Encerrando a calculadora...");
                    loop = false; 
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}