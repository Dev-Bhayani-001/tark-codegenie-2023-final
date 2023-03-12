// https://bit.ly/codegenie-2023
//https://bit.ly/codegenie-2023-tests
//https://bit.ly/codegenie-2023-submissions

//testcase-1 taking trains

// S - Sleeper (SL)
// B - 3 Tier AC (3A)
// A - 2 Tier AC (2A)
// H - 1st class AC (1A)

// ArrayList<ArrayList<String>>TwoDimension = new ArrayList<ArrayList<String>>();
import java.util.*;

//Dev Bhayani
public class TrainReservationSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int noOfTrains = sc.nextInt();
        ArrayList<String> trains = new ArrayList<>();
        ArrayList<String> classOfTrains = new ArrayList<>();
        ArrayList<String> train_Number = new ArrayList<>();
        ArrayList<String> dep_city = new ArrayList<>();
        ArrayList<String> dep_dist = new ArrayList<>();
        ArrayList<String> des_city = new ArrayList<>();
        ArrayList<String> des_dist = new ArrayList<>();
        ArrayList<String> coach_in_train = new ArrayList<>();
        HashMap<Character,Integer>classes=new HashMap<>();
        int temp = noOfTrains;

        while (temp > 0) {
            String input = sc.next();
            input += sc.nextLine();
            String input2 = sc.nextLine();


            String arrOfStr[] = input.split(" ");
            train_Number.add(arrOfStr[0]);
            String city_dis[] = arrOfStr[1].split("-");
            dep_city.add(city_dis[0]);
            dep_dist.add(city_dis[1]);
            city_dis = arrOfStr[2].split("-");
            des_city.add(city_dis[0]);
            des_dist.add(city_dis[1]);

            trains.add(input);


            classOfTrains.add(input2.substring(6));
            String []coaches=input2.substring(6).split(" ");
            for(int i=0;i<coaches.length;i++)
            {
                classes.put(coaches[i].charAt(0),classes.getOrDefault(coaches,0)+Integer.parseInt(coaches[i].substring(3)));
            }
            temp--;
        }
        // System.out.println("HEre is your output : ");
        // for(int i=0;i<noOfTrains;i++)
        // {
        // System.out.println(trains.get(i));
        // System.out.println(classOfTrains.get(i));
        // }
        int pnr_no = 100000000;
        int charge = 0;
        ArrayList<Integer> pnr = new ArrayList<>();
        ArrayList<String> from_city = new ArrayList<>();
        ArrayList<String> to_city = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> coach = new ArrayList<>();
        ArrayList<String> passengers = new ArrayList<>();
        ArrayList<Integer> fair = new ArrayList<>();
        // ArrayList<String> seat_count = new ArrayList<>();
        ArrayList<ArrayList<String>> on_date_count = new ArrayList<ArrayList<String>>();

        while (true) {
            String s = sc.nextLine();
            // System.out.println(s);
            String arrofstr[] = s.split(" ");
            if (arrofstr[0].equals(arrofstr[1])) {
                System.out.println("departure and destination are same");
            } else {
                String coach_found = "";
                if (arrofstr[3].equals("SL")) {
                    coach_found = "S";
                } else if (arrofstr[3].equals("3A")) {
                    coach_found = "B";
                } else if (arrofstr[3].equals("2A")) {
                    coach_found = "A";

                } else if (arrofstr[3].equals("1A")) {
                    coach_found = "H";
                } else {
                    System.out.println("Please enter right coach");
                }
                int f = 0;
                for (int i = 0; i < trains.size(); i++) {
                    if (trains.get(i).contains(arrofstr[0]) && trains.get(i).contains(arrofstr[1])
                            && classOfTrains.get(i).contains(coach_found)) {
                        pnr.add(++pnr_no);
                        from_city.add(arrofstr[0]);
                        to_city.add(arrofstr[1]);
                        date.add(arrofstr[2]);
                        coach.add(arrofstr[3]);
                        passengers.add(arrofstr[4]);
                        f = 1;
                        int distance = 0;
                        distance = Integer.parseInt(des_dist.get(i)) - Integer.parseInt(dep_dist.get(i));
                        if (coach_found.equals("H")) {
                            charge = 4 * distance*Integer.parseInt(arrofstr[4]);
                        } else if (coach_found.equals("A")) {
                            charge = 3 * distance*Integer.parseInt(arrofstr[4]);
                        } else if (coach_found.equals("B")) {
                            charge = 2 * distance*Integer.parseInt(arrofstr[4]);
                        } else if (coach_found.equals("S")) {
                            charge = 1 * distance*Integer.parseInt(arrofstr[4]);
                        }
                        fair.add(charge);
                        // if (coach_found.equals("H")) {
                        //     charge = 4 * distance*Integer.parseInt(passengers.get(i));
                        // } else if (coach_found.equals("A")) {
                        //     charge = 3 * distance*Integer.parseInt(passengers.get(i));
                        // } else if (coach_found.equals("B")) {
                        //     charge = 2 * distance*Integer.parseInt(passengers.get(i));
                        // } else if (coach_found.equals("S")) {
                        //     charge = 1 * distance*Integer.parseInt(passengers.get(i));
                        // }
                        // System.out.println(passengers.get(i));
                        break;
                    }
                }
                if (f != 1) {
                    System.out.println("No Trains Available or You entered Invalid coach");
                } else {
                    System.out.println(pnr_no + " " + (charge));
                }
            }
        }

    }

}
