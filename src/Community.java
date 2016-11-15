import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymsil on 11/7/2016.
 */
public class Community
{
    public ArrayList<CommunityMember> communityMembers = new ArrayList<>();

    private int balance;
    private float moneyForDonations;

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance)
    {
        this.balance = balance;
        this.moneyForDonations = (float) (this.balance*0.2);
    }
    public float getMoneyForDonations()
    {
        moneyForDonations = (float) (balance*0.2);
        return moneyForDonations;
    }
    public void addMoneyToCommunity(int money)
    {
        setBalance(balance+ money);
    }


    public void addMember(CommunityMember member)
    {
        communityMembers.add(member);
    }
    public int expectedTaxFromMembers()
    {
        int tax = 0;
        for (CommunityMember member : communityMembers)
        {
            tax += member.taxForMember();
        }
        return tax;
    }

    public float DonationRequest(CommunityMember member)
    {
        int DonationToMember = member.maxCharityForMember();
        if (DonationToMember < moneyForDonations)
        {
            int newBalance = balance - DonationToMember;
            setBalance(newBalance);
            return DonationToMember;
        }
        else
        {
            int newBalance = (balance - (int)(moneyForDonations));
            setBalance(newBalance);
            return (int)(moneyForDonations);
        }
    }

    public Map listOfVolunteeringHours()
    {
        Map VolunteeringHours = new HashMap<>();
        for (VolunteeringActivity cont : VolunteeringActivity.values())
            VolunteeringHours.put(cont, 0);
        VolunteeringActivity activity;
        int hours;
        for (CommunityMember member : communityMembers)
        {
            activity = member.getVolunteeringActivity();
            hours = member.RecommendedVolunteeringHoursForMember();
            VolunteeringHours.put(activity, (int)VolunteeringHours.get(activity) + hours);
        }
        return VolunteeringHours;
    }


    public void printCommunityDetails()
    {
        for (CommunityMember member : communityMembers)
        {
            System.out.println(member.toString());
            System.out.println();
        }
    }

    public void removeMember(int aId) throws Exception
    {
        CommunityMember memberToRemove = getMember(aId);
        communityMembers.remove(memberToRemove);
    }
    public CommunityMember getMember(int aId) throws Exception
    {
        for (CommunityMember member : communityMembers)
        {
            if (member.getId() == aId) return member;
            break;
        }
        throw new Exception("no member with this id");
    }

    public int amountGemachLoan(int aId) throws Exception
    {
        CommunityMember memberToDonate = getMember(aId);
        return memberToDonate.maxCharityForMember();
    }
}
