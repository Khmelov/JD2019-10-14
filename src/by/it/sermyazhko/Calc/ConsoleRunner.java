package by.it.sermyazhko.Calc;

import java.util.Scanner;

class ConsoleRunner {
    private static void print(Var var) {
        if (var!=null)
            System.out.println(var);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        for(;;){
            String str = scanner.nextLine();
            if (str.equals("end"))
                break;
            //System.out.println(parser.calc(str));
            try {
                Var result = parser.calc(str);//{{1,2},{8,3},{1,8}}*{{1,2},{8,3}}
                printer.print(parser.calc(str));
            }catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            if(str.equals("printvar")){
                Var.printMap();
            }


        }

    }
}

