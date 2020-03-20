import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        WashCard[] washCards = new WashCard[6];
        Customer[] customers = new Customer[6];
        ArrayList<String> arr = new ArrayList<>();
        Statistics stats = new Statistics(arr);

        // Sætter tiden til for rabat til 14 og en boolean der tjekker om klokken er før 14.
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 14);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        boolean beforeTwo = Calendar.getInstance().before(cal);
        // da der kaldes getInstance() på Calender ovenfor, kan denne ikke være dynamisk og derfor benyttes timeStamp nedenfor som dato og tid i statistikken
        String timeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(LocalDateTime.now());

        //sætter vaskepriserne samt rabatpriserne
        double economyWash = 50;
        double economyDiscount = economyWash*0.8;
        double standardWash = 80;
        double standardDiscount = standardWash*0.8;

        //opretter WashCards
        washCards[0] = new WashCard(1, 1000, true);
        washCards[1] = new WashCard(2, 200, false);
        washCards[2] = new WashCard(3, 400, false);
        washCards[3] = new WashCard(4, 600, false);
        washCards[4] = new WashCard(5, 800, false);
        washCards[5] = new WashCard(6, 1000, false);

        //opretter customers og tildeler dem WashCards
        customers[0] = new Customer("Janus Pedersen", washCards[0], washCards[0].getMoney());
        customers[1] = new Customer("Hardy Akira", washCards[1], washCards[1].getMoney());
        customers[2] = new Customer("Oskar Tuska", washCards[2], washCards[2].getMoney());
        customers[3] = new Customer("Amir Khaled", washCards[3], washCards[3].getMoney());
        customers[4] = new Customer("Rasmus Møller", washCards[4], washCards[4].getMoney());
        customers[5] = new Customer("Rasmus Trap", washCards[5], washCards[5].getMoney());

        stats.readAmountOfWashes();


        System.out.println("Hej og velkommen til SuperShine.\nVi er en automatisk vaskehal. Indsæt dit WashCard for at fortsætte (kort ID)");
        Scanner sc = new Scanner(System.in);
        int inputID = sc.nextInt();

        for (WashCard washCard : washCards) {
            if (inputID == washCard.getCardID() && washCard.isAdminStatus()) {
                System.out.println("Du har nu følgende valgmuligheder:\n\t - [1] Vælg bil vask\n\t - [2] Tank kort op\n\t - [3] Se balance\n\t - [4] Se statistik");
            } else if (inputID == washCard.getCardID() && !washCard.isAdminStatus()) {
                System.out.println("Du har nu følgende valgmuligheder:\n\t - [1] Vælg bil vask\n\t - [2] Tank kort op\n\t - [3] Se balance");
            }
        }
        if(inputID > washCards.length){
            System.out.println("Du har indsat forkert kort(forkert ID)");
            return;
        }

        Scanner sc2 = new Scanner(System.in);
        int chosenAction = sc2.nextInt();
        switch (chosenAction){
            case 1:
                System.out.println("Vi hos SuperShine kan tilbyde dig tre forskellige slags vaske\n\t - [1] Economy (50 kr)\n\t - [2] Standard (80 kr)\n\t - [3] De Luxe (120 kr)");
                Scanner sc3 = new Scanner(System.in);
                int chosenWash = sc3.nextInt();

                if(chosenWash == 1 && washCards[inputID - 1].getMoney() > economyWash){
                    if(beforeTwo){
                        washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - economyDiscount);
                       arr.add("-----\n" + timeStamp + "\nWashType: Economy (discount)\n" + "ID: " + washCards[inputID - 1].getCardID() +  ", Name: " + customers[inputID - 1].getName() + "\n-----");
                    }else{
                        washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - economyWash);
                        arr.add("-----\n" + timeStamp + "\nWashType: Economy (no discount)\n" + "ID: " + washCards[inputID - 1].getCardID() +  ", Name: " + customers[inputID - 1].getName() + "\n-----");
                    }
                    System.out.println("Købet er gennemført, vil du have en kvittering? (y/n)");
                    Scanner receiptSc1 = new Scanner(System.in);
                    String receipt = receiptSc1.nextLine();
                   if(receipt.equals("y")){
                       System.out.print("************************************\n" +
                               "Tak fordi du har gjort brug af SuperShine. Vi ses en anden gang\nForhenværende balance: ");
                       if(beforeTwo){
                           System.out.println(washCards[inputID - 1].getMoney() + economyDiscount);
                           System.out.println("Pris på køb: -" + economyDiscount + "\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");
                       }else {
                           System.out.println(washCards[inputID - 1].getMoney() + economyWash);
                           System.out.println("Pris på køb: -" + economyWash + "\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");
                       }
                   }

                }else if(chosenWash == 2 && washCards[inputID - 1].getMoney() > standardWash){
                    if(beforeTwo){
                        washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - standardDiscount);
                        arr.add("-----\n" + timeStamp + "\nWashType: Standard (discount)\n" + "ID: " + washCards[inputID - 1].getCardID() +  ", Name: " + customers[inputID - 1].getName() + "\n-----");
                    }else{
                        washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - standardWash);
                        arr.add("-----\n" + timeStamp + "\nWashType: Standard (no discount)\n" + "ID: " + washCards[inputID - 1].getCardID() +  ", Name: " + customers[inputID - 1].getName() + "\n-----");
                    }
                    System.out.println("Købet er gennemført, vil du have en kvittering? (y/n)");
                    Scanner receiptSc1 = new Scanner(System.in);
                    String receipt = receiptSc1.nextLine();
                    if(receipt.equals("y")){
                        System.out.print("************************************\n" +
                                "Tak fordi du har gjort brug af SuperShine. Vi ses en anden gang\nForhenværende balance: ");
                        if(beforeTwo){
                            System.out.println(washCards[inputID - 1].getMoney() + standardDiscount);
                            System.out.println("Pris på køb: " + standardDiscount + "\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");
                        }else{
                            System.out.println(washCards[inputID - 1].getMoney() + standardWash);
                            System.out.println("Pris på køb: -80\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");
                        }
                    }
                }else if(chosenWash == 3 && washCards[inputID - 1].getMoney() > 120) {
                    washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() - 120);
                    arr.add("-----\n" + timeStamp + "\nWashType: De Luxe\n" + "ID: " + washCards[inputID - 1].getCardID() +  ", Name: " + customers[inputID - 1].getName() + "\n-----");
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

                if(washCards[inputID - 1].getMoney() < 120 || washCards[inputID - 1].getMoney() < standardWash || washCards[inputID - 1].getMoney() < standardDiscount || washCards[inputID - 1].getMoney() < economyWash || washCards[inputID - 1].getMoney() < economyDiscount){
                    System.out.println("Du har ikke nok penge på dit WashCard");
                }
                break;
            case 2:
                System.out.println("Hvor mange penge vil du fylde på dit WashCard? (op til 1000 kr)");
                Scanner sc4 = new Scanner(System.in);
                String chosenAmount = sc4.nextLine();
                double chosenAmountDouble = Double.parseDouble(chosenAmount);
                if(chosenAmountDouble > 1000.0 || chosenAmountDouble < 1.0){
                    System.out.println("Ukorrekt beløb indtastet");
                }else {
                    washCards[inputID - 1].setMoney(washCards[inputID - 1].getMoney() + chosenAmountDouble);
                    System.out.println("Din optankning er gennemført. Vil du have en kvittering? (y/n)");
                }
                Scanner receiptSc2 = new Scanner(System.in);
                String receipt = receiptSc2.nextLine();
                if(receipt.equals("y")){
                    System.out.print("************************************\n" +
                            "Tak fordi du har gjort brug af SuperShine. Vi ses en anden gang\nForhenværende balance: ");
                        System.out.println(washCards[inputID - 1].getMoney() - chosenAmountDouble);
                        System.out.println("Pris på køb: + " + chosenAmountDouble + "\nI alt tilbage: " + washCards[inputID - 1].getMoney() + "\n************************************ ");

                }
                break;
            case 3:
                System.out.print("På dit WashCard står der: ");
                System.out.print(washCards[inputID - 1].getMoney());
                System.out.println(" kr");
                break;
            case 4:
                stats.readFromFile();
                arr.forEach(System.out::println);
                break;
        }
        stats.writeToFile(arr);
    }



}
