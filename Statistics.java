import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Statistics {
    Customer customer;
    WashCard washCard;
    ArrayList<String> arr;
    String name;
    public Statistics(ArrayList<String> arr){
        this.arr = arr;
    }
    public void writeToFile(ArrayList<String> arr) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("stats.txt", true));

        for (String line : arr) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    public void readFromFile() {
        try {
            FileReader reader = new FileReader("stats.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAmountOfWashes() throws IOException {
        String[] words;
        FileReader fr = new FileReader("stats.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        String input = String.valueOf(washCard.getCardID());
        int count=0;
        while((s=br.readLine())!=null)
        {
            words=s.split(" ");
            for (String word : words)
            {
                if (word.equals(input))
                {
                    count++;
                    System.out.println(word);
                }
            }
        }
        if(count!=0)
        {
            System.out.println("The given word is present for "+count+ " Times in the file");
        }
        else
        {
            System.out.println("The given word is not present in the file");
        }

    }

}
