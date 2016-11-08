/**
 * Created by ymsil on 11/7/2016.
 */
public class Single extends CommunityMember
{
    private int yearsOfEducation;
    private Residence residence;

    public Single(int id, Gender gender, String name, String address, String dateOfBirth,
                  int weeklyTorahHours, int weeklyWorkHours, int monthlyIncome, VolunteeringActivity volunteeringActivity,
                  int yearsOfEducation, Residence residence)
            throws Exception
    {
        super(id, gender, name, address, dateOfBirth,
                weeklyTorahHours, weeklyWorkHours, monthlyIncome, volunteeringActivity);
        this.yearsOfEducation = yearsOfEducation;
        this.residence = residence;
    }

    public int getYearsOfEducation() {
        return yearsOfEducation;
    }
    public void setYearsOfEducation(int yearsOfEducation) {
        this.yearsOfEducation = yearsOfEducation;
    }
    public Residence getResidence() {
        return residence;
    }
    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    @Override
    public int taxForMember()
    {
        if (maxCharityForMember() > 0) return 0;
        return 800;
    }

    @Override
    public int maxCharityForMember()
    {
        return 0;
    }

    @Override
    public int RecommendedVolunteeringHoursForMember()
    {
        if (isToratoOmanoto()) return 4;
        return 10;
    }
}
