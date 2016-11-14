import java.util.Scanner;

public class Main{

    // fields
    public static Scanner input = new Scanner(System.in);
    public static Community COM;

    public static void main(String[] args) {
        init();
        while (true) {
            try
            {
                int choice = menu();
                switch (choice) {
                    case 1:
                        addMember();
                        break;
                    case 2:
                        removeMember();
                        break;
                    case 3:
                        charityForMember();
                        break;
                    case 4:
                        maxTax();
                        break;
                    case 5:
                        System.out.println(COM.listOfVolunteeringHours());
                        break;
                    case 6:
                        addingMoneyToComunity();
                        break;
                    case 7:
                        COM.printCommunityDetails();
                        break;
                    case 0:
                        return;
                }
            }
            catch (Exception e) {
                System.out.println(e.toString() + "\n");
            }
        }
    }

    private static void printCommunityDetails() {
        COM.printCommunityDetails();
    }

    private static void maxTax() {
        System.out.println("the tax is: " + COM.expectedTaxFromMembers());
    }

    private static void addingMoneyToComunity() throws Exception {
        System.out.println("enter the amount of money that you want to give to the community");
        int money = input.nextInt();
        COM.addMoneyToCommunity(money);
    }

    private static void charityForMember() throws Exception {
        System.out.println("enter the ID of the member that needs the money");
        int tmpID = input.nextInt();
        System.out.println("the maximum amount he can get is: " + COM.amountGemachLoan(tmpID));
    }

    private static void removeMember()throws Exception {
        System.out.println("enter the ID of the member you want to remove");
        int tmpID = input.nextInt();
        try
        {
            COM.removeMember(tmpID);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    private static void addMembersInit() throws Exception {
        COM.addMember(new Married(201643798, Gender.Male, "Yair Stesh", "Talpiot", "4/7/1989", 121 ,0, 0, VolunteeringActivity.Physical, 305277980, 1));

    }

    private static void init() {
        System.out.println("welcome!\n" +
                "\n");
        while (true) {
            try {
                COM = new Community();
                addMembersInit();
                System.out.println("the members of the community:");
                printCommunityDetails();
                return;
            } catch (Exception e) {
                System.out.println(e.toString() + "\n");
            }
        }
    }

    public static int menu() {
        int choice = 0;
        while (true) {
            System.out.println("\n\n-----------------------------------------\n" +
                    "-------- please enter your choice --------\n" +
                    "for adding a member, press -------------- 1\n" +
                    "for removing a member, press ------------ 2\n" +
                    "to giving charity to a member, press ---- 3\n" +
                    "for printing tax details, press --------- 4\n" +
                    "for printing volunteering hours, press -- 5\n" +
                    "for adding money to the Community, press  6\n" +
                    "for printing the community details, press 7\n" +
                    "for exit, press ------------------------- 0\n\n");

            choice = input.nextInt();
            if (choice >= 0 && choice < 8)
                return choice;
            else
                System.out.println("please make a choice from the menu\n");
        }
    }

    public static void addMember() throws Exception {
        int choice;
        int aId, aTorahWeeklyHours, aWorkHours, aIncome, aUnder18children, aIdPartner, aYears;
        Gender aGender;
        String aName, aAddress, aBirthdayDate;
        String  gen, act;
        VolunteeringActivity aMemberContribution;
        Residence residence;
        boolean aLeave;
        System.out.println("for adding a married member press 1" +
                "\nfor adding an unmarried member press 2" +
                "\nfor exit press 0");
        while (true) {
            choice = input.nextInt();
            if (1 == choice) {
                printParm();
                System.out.println("11.partner ID \n" + "12.number of children under 18");

                aId = input.nextInt();
                gen = input.next();
                switch (gen)
                {
                    case "M": aGender = Gender.Male; break;
                    case "F": aGender = Gender.Female; break;
                    default: throw new Exception("gender unknown");
                }
                aName = input.next();
                aAddress = input.next();
                aBirthdayDate = input.next();
                aTorahWeeklyHours = input.nextInt();
                aWorkHours = input.nextInt();
                aIncome = input.nextInt();
                act =input.next();
                switch (act)
                {
                    case "s": aMemberContribution = VolunteeringActivity.Spiritual; break;
                    case "p": aMemberContribution = VolunteeringActivity.Physical; break;
                    case "m": aMemberContribution = VolunteeringActivity.Musical; break;
                    default: throw new Exception("volunteering activity unknown");                }
                aIdPartner = input.nextInt();
                aUnder18children = input.nextInt();

                COM.addMember(new Married(aId, aGender, aName, aAddress, aBirthdayDate, aTorahWeeklyHours ,aWorkHours,
                                            aIncome, aMemberContribution, aIdPartner, aUnder18children));
                System.out.println("the member was added successfuly.");
                return;
            } else if (choice == 2) {
                printParm();
                System.out.println("10.number of years he studding" +
                        "\n11. does he live with his\\her parents? (if so, enter 1. if not enter 0");
                aId = input.nextInt();
                gen = input.next();
                switch (gen)
                {
                    case "M": aGender = Gender.Male; break;
                    case "F": aGender = Gender.Female; break;
                    default: throw new Exception("gender unknown");
                }
                aName = input.next();
                aAddress = input.next();
                aBirthdayDate = input.next();
                aTorahWeeklyHours = input.nextInt();
                aWorkHours = input.nextInt();
                aIncome = input.nextInt();
                act =input.next();
                switch (act)
                {
                    case "s": aMemberContribution = VolunteeringActivity.Spiritual; break;
                    case "p": aMemberContribution = VolunteeringActivity.Physical; break;
                    case "m": aMemberContribution = VolunteeringActivity.Musical; break;
                    default: throw new Exception("volunteering activity unknown");
                }
                aYears = input.nextInt();
                aLeave = input.nextBoolean();
                if (aLeave) residence = Residence.WithParents;
                else residence = Residence.Alone;

                COM.addMember(new Single(aId, aGender, aName, aAddress, aBirthdayDate, aTorahWeeklyHours ,aWorkHours,
                        aIncome, aMemberContribution, aYears, residence));
                System.out.println("the member was added successfully.");
                return;
            } else if (choice == 0)
                return;

            System.out.println("please enter 0, 1 or 2 only");
        }
    }

    private static void printParm() {
        System.out.println("enter the next details in this order (Enter between each detail):" +
                "\n1. member ID" +
                "\n2. gender ( M for male or F for female)" +
                "\n3. name" +
                "\n4. address" +
                "\n5. birthday date in this pattern: dd/mm/yyyy" +
                "\n6. number of hours learning Torah (per week)" +
                "\n7. number of hours working (per week)" +
                "\n8. income (per month)" +
                "\n9. contribution type (s for spiritual, p for physical or m for music)");
    }

}