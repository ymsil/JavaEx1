/**
 * Created by ymsil on 11/7/2016.
 */
public class Married extends CommunityMember
{
    private int partnerId;
    private int numOfKidsUnder18;

    public Married(int id, Gender gender, String name, String address, String dateOfBirth,
                   int weeklyTorahHours, int weeklyWorkHours, int monthlyIncome, Contribution contribution,
                   int partnerId, int numOfKidsUnder18)
            throws Exception
    {
        super(id, gender, name, address, dateOfBirth, weeklyTorahHours, weeklyWorkHours, monthlyIncome, contribution);
        this.partnerId = partnerId;
        this.numOfKidsUnder18 = numOfKidsUnder18;
    }

    public int getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }
    public int getNumOfKidsUnder18() {
        return numOfKidsUnder18;
    }
    public void setNumOfKidsUnder18(int numOfKidsUnder18) {
        this.numOfKidsUnder18 = numOfKidsUnder18;
    }

    @Override
    public int taxForMember()
    {
        if ( maxChartiyForMember() > 0 ) return 0;
        if (numOfKidsUnder18 > 1) return 2500;
        return 1000;
    }

    @Override
    public int maxChartiyForMember()
    {
        if (isToratoOmanoto()) return (1800+(getNumOfKidsUnder18()*400));
        else if (getMonthlyIncome() < 5000) return (1000+(getNumOfKidsUnder18()*200));
        return 0;
    }

    @Override
    public int RecommendedVolunteeringHoursForMember()
    {
        if (isToratoOmanoto()) return 2;
        return 5;
    }
}
