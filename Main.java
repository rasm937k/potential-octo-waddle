import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        WashCard[] washCards = new WashCard[6];
        Customer[] customers = new Customer[6];

        washCards[0] = new WashCard(0001, 1000, true);
        washCards[1] = new WashCard(0002, 200, false);
        washCards[2] = new WashCard(0003, 400, false);
        washCards[3] = new WashCard(0004, 600, false);
        washCards[4] = new WashCard(0005, 800, false);
        washCards[5] = new WashCard(0006, 1000, false);

        customers[0] = new Customer("Janus Pedersen", washCards[0], washCards[0].getMoney());
        customers[1] = new Customer("Hardy Akira", washCards[1], washCards[1].getMoney());
        customers[2] = new Customer("Oskar Tuska", washCards[2], washCards[2].getMoney());
        customers[3] = new Customer("Amir Khaled", washCards[3], washCards[3].getMoney());
        customers[4] = new Customer("Rasmus Møller", washCards[4], washCards[4].getMoney());
        customers[5] = new Customer("Rasmus Trap", washCards[5], washCards[5].getMoney());

        System.out.println("Hej og velkommen til SuperShine.\nVi er en automatisk vaskehal. Indsæt dit WashCard for at fortsætte (kort ID)");
        Scanner sc = new Scanner(System.in);
        int inputID = sc.nextInt();

        for (int i = 0; i < washCards.length; i++) {
            if(inputID == washCards[i].getCardID() && washCards[i].isAdminStatus()){
                System.out.println("Du har nu følgende valgmuligheder:\n\t - [1] Vælg bil vask\n\t - [2] Tank kort op\n\t - [3] Se balance\n\t - [4] Se statistik");
            }else if(inputID == washCards[i].getCardID() && !washCards[i].isAdminStatus()) {
                System.out.println("Du har nu følgende valgmuligheder:\n\t - [1] Vælg bil vask\n\t - [2] Tank kort op\n\t - [3] Se balance");
            }
        }

        Scanner sc2 = new Scanner(System.in);
        int chosenAction = sc2.nextInt();

        switch (chosenAction){
            case 1:
                System.out.println("Vi hos SuperShine kan tilbyde dig tre forskellige slags vaske\n\t - [1] Economy (50 kr)\n\t - [2] Standard (80 kr)\n\t - [3] De Luxe (120 kr)");
                Scanner sc3 = new Scanner(System.in);
                int chosenWash = sc3.nextInt();
                if(chosenWash == 1 && washCards[inputID - 1].getMoney() > 50){
                    washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - 50);
                    System.out.println("Købet er gennemført, vil du have en kvittering? (y/n)");
                    Scanner receiptSc1 = new Scanner(System.in);
                    String receipt = receiptSc1.nextLine();
                   if(receipt.equals("y")){
                       System.out.print("************************************\n" +
                               "Tak fordi du har gjort brug af SuperShine. Vi ses en anden gang\nForhenværende balance: ");
                       System.out.println(washCards[inputID - 1].getMoney() + 50);
                       System.out.println("Pris på køb: -50\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");
                   }
                }else if(chosenWash == 2 && washCards[inputID - 1].getMoney() > 80){
                    washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - 80);
                    System.out.println("Købet er gennemført, vil du have en kvittering? (y/n)");
                    Scanner receiptSc1 = new Scanner(System.in);
                    String receipt = receiptSc1.nextLine();
                    if(receipt.equals("y")){
                        System.out.print("************************************\n" +
                                "Tak fordi du har gjort brug af SuperShine. Vi ses en anden gang\nForhenværende balance: ");
                        System.out.println(washCards[inputID - 1].getMoney() + 80);
                        System.out.println("Pris på køb: -80\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");
                    }
                }else if(chosenWash == 3 && washCards[inputID - 1].getMoney() > 120) {
                    washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - 120);
                    System.out.println("Købet er gennemført, vil du have en kvittering? (y/n)");
                    Scanner receiptSc1 = new Scanner(System.in);
                    String receipt = receiptSc1.nextLine();
                    if (receipt.equals("y")) {
                        System.out.print("************************************\n" +
                                "Tak fordi du har gjort brug af SuperShine. Vi ses en anden gang\nForhenværende balance: ");
                        System.out.println(washCards[inputID - 1].getMoney() + 120);
                        System.out.println("Pris på køb: -120\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");
                    }
                }
                System.out.println("Du har ikke nok penge på dit WashCard");

                break;
            case 2:
                System.out.println("Hvor mange penge vil du fylde på dit WashCard? (op til 1000 kr)");
                Scanner sc4 = new Scanner(System.in);
                int chosenAmount = sc4.nextInt();
                if(chosenAmount > 1000 || chosenAmount < 1){
                    System.out.println("Ukorrekt beløb indtastet");
                }else {
                    washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() + chosenAmount);
                    System.out.println("Du har nu: " + washCards[inputID - 1].getMoney() + " på dit WashCard");
                }
                break;
            case 3:
                System.out.print("På dit WashCard står der: ");
                System.out.print(washCards[inputID - 1].getMoney());
                System.out.println(" kr");
                break;
            case 4:

                break;
        }

    }

}
